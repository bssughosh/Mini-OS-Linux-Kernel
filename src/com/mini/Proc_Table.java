package com.mini;

public class Proc_Table {
    private int[] pts;
    private int[] ptm;
    private int l,j;
    private String a;

    public Proc_Table() {
        j=0;
    }

    public void setdata(int x, String y){
        pts = new int[x];
        ptm = new int[x];
        l = x;
        a = y;
    }

    public void get_sm(int s[], int r) {
        for (int i = 0; i < l; i++) {
            pts[i] = s[r];
            r++;
        }
    }

    public int ret_sm(int r) {
        return pts[r];
    }

    public void get_mm(int r) {
            ptm[j] = r;
            j++;
    }

    public int ret_mm(int r) {
        return ptm[r-1];
    }

    public String getName() {
        return a;
    }



}
