package com.mini;


import java.util.Random;
import java.util.Scanner;

public class memory {

    private int[] sm;
    private int[] mm;
    private String[] smn;
    private int div;

    private Scanner sc = new Scanner(System.in);

    public memory() {
        sm = new int[1000];
        mm = new int[200];
        smn = new String[1000];
        for (int i = 0; i < 1000; i++) {
            sm[i] = -1;
        }
        for (int i = 0; i < 200; i++) {
            mm[i] = -1;
        }
        System.out.println("Enter the number of instructions in a page");
        div = sc.nextInt();
    }

    void getdata() {
        int i, c, r = 0, k, t;
        i = 0;
        String n;
        int x;
        boolean b;
        t = 0;
        Proc_Table p[] = new Proc_Table[50];
        for (int j = 0; j < 50; j++) {
            p[j] = new Proc_Table();
        }

        while (i == 0) {
            System.out.println("Enter 1 to enter process, 2 view a page and 3 to exit");
            c = sc.nextInt();
            switch (c) {

                case 1:
                    System.out.println("Enter Process Name");
                    sc.nextLine();
                    n = sc.nextLine();
                    System.out.println("Enter number of instructions to be used by process");
                    x = sc.nextInt();
                    double y = Math.ceil(1.0 * x / div);
                    x = (int) y;
                    p[t].setdata(x, n);
                    b = false;
                    while (b == false) {
                        r = getRandomNumberInRange(0, 999);
                        while (sm[r] != -1) {
                            r = getRandomNumberInRange(0, 999);
                        }
                        if ((999 - r) >= x) {
                            for (int z = r; z < (r + x); z++) {
                                if (sm[z] != -1) {
                                    b = false;
                                    break;
                                } else
                                    b = true;
                            }
                        }
                    }
                    int d = 1;
                    for (int z = r; z < (r + x); z++) {
                        sm[z] = d;
                        d++;
                        smn[z] = n;
                    }

                    p[t].get_sm(sm, r);
                    k = 0;

                    while (k < x) {

                        r = getRandomNumberInRange(0, 199);
                        if (mm[r] == -1) {
                            mm[r] = p[t].ret_sm(k);
                            k++;
                            p[t].get_mm(r);
                        }
                    }
                    t++;
                    break;

                case 2:
                    int z;
                    System.out.println("Enter Process Name from where a page is to be read");
                    sc.nextLine();
                    n = sc.nextLine();

                    for (z = 0; z < t; z++) {
                        if (n.equals(p[z].getName())) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    if (z == t) {
                        System.out.println("Required process not found");
                    } else {
                        System.out.println("Enter page number to be searched");
                        x = sc.nextInt();
                        System.out.println("Enter page offset");
                        int po = sc.nextInt();
                        System.out.println("Found the frame in memory");
                        LA_PA(z, x, po, p);
                    }

                    break;

                case 3:
                    i = 1;
                    break;

                default:
                    System.out.println("Wrong choice");
            }
        }
    }


    void LA_PA(int a, int pg, int d, Proc_Table p[]) {
        int x;
        x = p[a].ret_mm(pg);
        System.out.println("Page number - "+pg);
        System.out.println("Logical Address is " + (pg+d));
        System.out.println("Physical Address is " + (x+d));
        System.out.println("Base address of required frame "+x);
    }

    private int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
/*
while (i == 0) {
            System.out.println("Enter 1 to enter process, 2 view a page and 3 to exit");
            c = sc.nextInt();
            switch (c) {

                case 1:
                    System.out.println("Enter Process Name");
                    sc.nextLine();
                    n = sc.nextLine();
                    System.out.println("Enter Number of instructions");
                    x = sc.nextInt();
                    //double y = Math.ceil((1.0*x/div));
                    //x = (int)y;
                    Proc_Table u =new Proc_Table();
                    b = false;
                    while(b == false){
                        r = (int) (Math.random() * ((998 - 1) + 1)) + 1;
                        while (sm[r] != -1) {
                            r = (int) (Math.random() * ((998 - 1) + 1)) + 1;
                        }

                        for (int z = r; z < (r + x); z++) {
                            if (sm[z] != -1) {
                                b = false;
                                break;
                            } else
                                b = true;
                        }
                    }
                    int d=1;
                    for (int z = r; z < (r + x); z++) {
                        sm[z] = d;
                        d++;
                        smn[z] = n;
                    }
                    u.get_sm(sm, r);
                    k=0;
                    while (k < x) {

                        r = (int) (Math.random() * ((198 - 1) + 1)) + 1;
                        if (mm[r] == -1) {
                            mm[r] = u.ret_sm(k);
                            k++;
                            u.get_mm(r);
                        }
                    }
                    p.add(u);
                    break;

                case 2:
                    int z;
                    System.out.println("Enter Process Name from where a page is to be read");
                    sc.nextLine();
                    n = sc.nextLine();

                    for (z = 0; z < p.size(); z++) {
                        if (n.equals(p.get(z).getName())) {
                            break;
                        }
                    }
                    if (z == t) {
                        System.out.println("Required process not found");
                    }
                    else{
                        System.out.println("Enter page number to be searched");
                        x = sc.nextInt();
                        System.out.println("Enter page offset");
                        int po = sc.nextInt();
                        System.out.println("Found the frame in memory");
                        LA_PA(t,x,po);
                    }
                    break;

                case 3:
                    i=1;
                    break;

                default:
                    System.out.println("Wrong choice");
            }
        }
*/