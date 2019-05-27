package com.zzti;

public class test {
    public static void main(String[] args) {
        System.out.println(searchM(11));
    }
    public static int searchM(int m){
        if(m==1){
            return 2;
        }else
        if(m==2){
            return 3;
        }else
        if(m==3){
            return 4;
        }else
        if(m==4){
            return 5;
        }else {
            new String();
            return searchM(m - 2) + searchM(m - 3);
        }
    }
}
