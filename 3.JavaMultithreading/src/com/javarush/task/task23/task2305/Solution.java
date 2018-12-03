package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution solutionFirst = new Solution();
        Solution.InnerClass innerClass11 = solutionFirst.new InnerClass();
        Solution.InnerClass innerClass12 = solutionFirst.new InnerClass();
        solutionFirst.innerClasses[0] = innerClass11;
        solutionFirst.innerClasses[1] = innerClass12;

        Solution solutionSecond = new Solution();
        Solution.InnerClass innerClass21 = solutionSecond.new InnerClass();
        Solution.InnerClass innerClass22 = solutionSecond.new InnerClass();
        solutionSecond.innerClasses[0] = innerClass21;
        solutionSecond.innerClasses[1] = innerClass22;

        return new Solution[]{solutionFirst, solutionSecond};
    }

    public static void main(String[] args) {

    }
}
