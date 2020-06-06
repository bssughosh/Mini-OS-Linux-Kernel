package com.mini;

import java.util.LinkedList;
import java.util.Scanner;

public class FilePermissions extends file {
    private static LinkedList<file> fileLinkedList = new LinkedList<>();

    public void calc() {
        Scanner sc = new Scanner(System.in);
        boolean escape = false;
        boolean isRoot = false;

        while (true) {
            System.out.print("Are you root user? [Y/n] ");
            String c;

            while (true) {
                c = sc.next();
                if (c.equalsIgnoreCase("Y") || c.equalsIgnoreCase("N")) {
                    isRoot = (c.equalsIgnoreCase("Y"));
                    break;
                } else System.out.print("Error, re-enter choice: ");
            }

            while (true) {
                System.out.println("Enter 1 to enter new file");
                System.out.println("Enter 2 to read");
                System.out.println("Enter 3 to write");
                System.out.println("Enter 4 to execute");
                System.out.println("Enter 0 to exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1: {
                        System.out.print("Enter file name: ");
                        String fileName = sc.next();

                        System.out.print("Enter file permissions: ");
                        String filePermissions = sc.next();

                        file file1 = new file(fileName, filePermissions);
                        fileLinkedList.add(file1);
                        break;
                    }

                    case 2:
                        for (int i = 0; i < fileLinkedList.size(); i++)
                            System.out.println("File" + i + ": " + fileLinkedList.get(i).fileName);

                        System.out.print("Enter your choice: ");
                        choice = sc.nextInt();
                        fileLinkedList.get(choice).read(isRoot);
                        break;

                    case 3:
                        for (int i = 0; i < fileLinkedList.size(); i++)
                            System.out.println("File" + i + ": " + fileLinkedList.get(i).fileName);

                        System.out.print("Enter your choice: ");
                        choice = sc.nextInt();
                        fileLinkedList.get(choice).write(isRoot);
                        break;

                    case 4:
                        for (int i = 0; i < fileLinkedList.size(); i++)
                            System.out.println("File" + i + ": " + fileLinkedList.get(i).fileName);

                        System.out.print("Enter your choice: ");
                        choice = sc.nextInt();
                        fileLinkedList.get(choice).execute(isRoot);
                        break;

                    case 0:
                        escape = true;
                        break;
                }
                if (escape)
                    break;
            }

            System.out.print("Do you want to exit? [Y/n] ");

            while (true) {
                c = sc.next();
                if (c.equalsIgnoreCase("Y") || c.equalsIgnoreCase("N")) {
                    escape = (c.equalsIgnoreCase("Y"));
                    break;
                } else System.out.print("Error, re-enter choice: ");
            }

            if (escape)
                break;
        }
    }
}