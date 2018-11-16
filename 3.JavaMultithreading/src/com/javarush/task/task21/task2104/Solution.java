package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (n == null) {
            return false;
        }

        if(!(n instanceof Solution)) {
            return false;
        }

        if (this == n) {
            return true;
        }

        Solution n2 = (Solution) n;

        if (first != null ? !first.equals(n2.first) : n2.first != null) return false;
        if (last != null ? !last.equals(n2.last) : n2.last != null) return false;

        return true;
    }

    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Solution solution = (Solution) o;
//        return Objects.equals(first, solution.first) &&
//                Objects.equals(last, solution.last);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(first, last);
//    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));

    }
}
