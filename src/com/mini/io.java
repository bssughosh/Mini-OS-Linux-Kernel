package com.mini;

        import java.util.LinkedList;
        import java.util.Scanner;

public class io {
    private int header;
    private int difference;
    private LinkedList<Integer> inputData = new LinkedList<>();

    io() {
        Scanner sc = new Scanner(System.in);
        difference = 0;

        System.out.print("Enter the current header location: ");
        header = sc.nextInt();
        System.out.println();
    }

    void addElement(int elementCount) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the elements: ");
        for (int i = 0; i < elementCount; i++)
            inputData.add(sc.nextInt());
        System.out.println();
    }

    int getInputDataCount() {
        return inputData.size();
    }

    private int nextElement() {
        /*
         * Gets the distance between the header and the next element
         */

        int difference = Integer.MAX_VALUE;
        int smallest = -1;

        for (int i : inputData) {
            int temp =  i - header;
            if (temp < difference && temp > 0) {
                difference = temp;
                smallest = i;
            }
        }

        if (smallest == -1) return -1;

        header = smallest;
        inputData.remove((Integer) smallest);
        return difference;
    }

    private int eliminateSmallest() {
        int temp = Integer.MAX_VALUE;
        for (int i : inputData)
            if (temp > i)
                temp = i;

        int difference = Math.abs(header - temp);
        header = temp;
        inputData.remove((Integer) temp);
        return difference;
    }

    //C-LOOK
    void cLOOK(int count) {
        System.out.println();
        System.out.print(header);
        for (int i = 0; i < count; i++) {
            int temp = nextElement();
            if (temp == -1)
                temp = eliminateSmallest();

            difference += temp;
            System.out.print(" -> " +header);
        }
        System.out.println();
        System.out.println("Distance travelled by header: " +difference);
    }
}
