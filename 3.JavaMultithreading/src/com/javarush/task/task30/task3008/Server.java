package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String args[]) throws IOException {
        int socketNumber = ConsoleHelper.readInt();
        try(ServerSocket serverSocket = new ServerSocket(socketNumber)) {
            System.out.println("сервер запущен");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (Exception e) {
            System.out.println("error happens");
        }

    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message message;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                message = connection.receive();
                if (message.getType() == MessageType.USER_NAME && !message.getData().isEmpty() && connectionMap.get(message.getData()) == null) {
                    break;
                }
            }
            String name = message.getData();
            connectionMap.put(name, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return name;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (!userName.equals(name)) {
                    Message message = new Message(MessageType.USER_ADDED, name);
                    connection.send(message);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    Message newMessage = new Message(message.getType(),userName + ": " + message.getData() );
                    sendBroadcastMessage(newMessage);
                } else {
                    ConsoleHelper.writeMessage("неверный тип сообщения");
                }
            }
        }

        @Override
        public void run() {

            if (socket != null && socket.getRemoteSocketAddress() != null) {
                ConsoleHelper.writeMessage("Established a new connection to a remote socket address: " + socket.getRemoteSocketAddress());
            }
            String userName = null;

            try (Connection connection = new Connection(socket)) {

                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("An exchange of data error to a remote socket address");
            } finally {
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                ConsoleHelper.writeMessage("Closed connection to a remote socket address: "); // + socketAddress);
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                System.out.println("не смогли отправить сообщение");
            }
        }
    }
}
