package com.mini;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c, i = 1;
        while (i == 1) {
            System.out.println("Enter 1 for process, 2 for memory, 3 for IO, 4 for file, 5 for exit");
            c = sc.nextInt();
            switch (c){
                case 1:
                    process p =new process();
                    p.getdata();
                    p.calc();
                    break;

                case 3:
                    io obj =new io();
                    System.out.print("Enter the number of elements to input: ");
                    int num = sc.nextInt();
                    obj.addElement(num);
                    while (true) {
                        if (obj.getInputDataCount() > 4) {
                            obj.cLOOK(obj.getInputDataCount() / 2);

                            System.out.print("Would you like to enter more elements? [Y/n]: ");
                            String st = sc.next();
                            if (st.equalsIgnoreCase("Y")) {
                                System.out.print("Enter the number of elements to input: ");
                                num = sc.nextInt();
                                for (i = 0; i < num; i++) obj.addElement(i);
                            }
                        }
                        else {
                            obj.cLOOK(obj.getInputDataCount());
                            System.out.print("Would you like to continue? [Y/n]: ");
                            String st = sc.next();
                            if (st.equalsIgnoreCase("N")) return;
                            System.out.print("Enter the number of elements to input: ");
                            num = sc.nextInt();
                            obj.addElement(num);
                        }
                    }


                case 2:
                    memory m =new memory();
                    m.getdata();
                    //m.print_table();
                    break;

                case 4:
                    FilePermissions f =new FilePermissions();
                    f.calc();
                    break;

                case 5:
                    i=2;
                    break;

                default:
                    System.out.println("Wrong choice");
            }
        }
    }
}
