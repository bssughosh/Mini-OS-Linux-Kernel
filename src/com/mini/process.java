package com.mini;

import java.util.Scanner;

public class process {
    private int bt[], np, ts, rts, i, j, k, np1, arr[], z;
    private float rem_bt[], wt[], totalt, total, total1, tat[], awt, atat;
    Scanner sc =new Scanner(System.in);
    public process() {
        bt = new int[10];
        arr = new int[10];
        rem_bt = new float[10];
        wt = new float[10];
        tat = new float[10];
    }

    public void getdata(){
        System.out.println("Enter no of processes");
        np = sc.nextInt();
        np1=np;
        System.out.println("Enter no of processes burst time");
        for(i=0;i<np;i++)
        {
            bt[i] = sc.nextInt();
            rem_bt[i]=bt[i];
        }
        System.out.println("Enter no of processes arrival time");
        for(i=0;i<np;i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter time slice");
        ts = sc.nextInt();
    }

    public void calc(){
        totalt=0;
        total1=0;
        total=0;
        atat=0;
        awt=0;
        rts=0;
        i=0;
        j=0;
        k=0;
        z=0;
        boolean x=true;
        for(i=0;x;i++)
        {
            k=0;
            for(z=0;z<np1;z++)
            {
                if(arr[z]<=totalt && rem_bt[z]!=0)
                {
                    k++;
                }
            }
            rts=ts/k;
            for(j=0;j<np1;j++)
            {
                if(arr[j]<=totalt && rem_bt[j]>rts)
                {
                    totalt=totalt+rts;
                    rem_bt[j]=rem_bt[j]-rts;
                }
                else if(arr[j]<=totalt && rem_bt[j]>0 && rem_bt[j]<=rts)
                {
                    totalt=totalt+rem_bt[j];
                    rem_bt[j]=0;
                    wt[j]=totalt-bt[j]-arr[j];
                }

            }
            for(z=0;z<np1;z++){
                if(rem_bt[z]==0){
                    x=false;
                }else
                {
                    x = true;
                    break;
                }
            }
        }
        for(i=0;i<np1;i++)
        {
            total=total+wt[i];
        }
        for(i=0;i<np1;i++)
        {
            tat[i]=wt[i]+bt[i];
            total1=total1+tat[i];
        }
        awt=total/np1;
        atat=total1/np1;
        System.out.println("Process\tBurst Time\tArrival Time\tWaiting Time\tTAT");
        for(i=0;i<np1;i++)
        {
            System.out.println("P"+(i+1)+"\t\t\t"+bt[i]+"\t\t\t"+arr[i]+"\t\t\t"+wt[i]+"\t\t\t\t"+tat[i]);
        }
    }
}
