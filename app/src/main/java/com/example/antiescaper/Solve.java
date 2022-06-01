package com.example.antiescaper;

import android.text.BoringLayout;

public class Solve {
    int osn1;
    int osn2;
    String stroka;
    String res;
    public Solve(String s, int x, int y)
    {
        this.osn1=x;
        this.osn2=y;
        this.stroka=s;
    }
    public String InBtoDec(String s, int x){
        char[] S=s.toCharArray();
        String s1 = "";
        int k=0,w=1,i=s.length()-1,q=1;

        while (i >= 0) {
            if (S[i] == 'A' || S[i] == 'a') q = 10;
            if (S[i] == 'B' || S[i] == 'b') q = 11;
            if (S[i] == 'C' || S[i] == 'c') q = 12;
            if (S[i] == 'D' || S[i] == 'd') q = 13;
            if (S[i] == 'E' || S[i] == 'e') q = 14;
            if (S[i] == 'F' || S[i] == 'f') q = 15;
            if (S[i] == '9') q = 9;
            if (S[i] == '8') q = 8;
            if (S[i] == '7') q = 7;
            if (S[i] == '6') q = 6;
            if (S[i] == '5') q = 5;
            if (S[i] == '4') q = 4;
            if (S[i] == '3') q = 3;
            if (S[i] == '2') q = 2;
            if (S[i] == '1') q = 1;
            if (S[i] == '0') q = 0;
            k += q * w;
            w *= x;
            i--;
        }
        while (k > 0) {
            char c;
            int r=k%10;
            int d=r+48;
            c = (char) d;
            s1 = c + s1;
            k /= 10;
        }
        return s1;
    }
    public String InDecToB(String s, int x){
        char c='1';
        String s1="";
        char[] S=s.toCharArray();
        int t=Integer.parseInt(s);
        while(t>0) {
            int r =  t % x;
            if (r > 9) {
                if (r == 10)
                    c='A';
                if (r == 11)
                    c='B';
                if (r == 12)
                    c='C';
                if (r == 13)
                    c='D';
                if (r == 14)
                    c='E';
                if (r == 15)
                    c='F';
            }
            else {
                int d = r + 48;
                c = (char) d;
            }
            s1=c+s1;
            t/=x;
        }
        return s1;
    }
    public Boolean provekaosn(int i) {
        return (i>1&&i<17);
    }
    public Boolean proverkastr (String s, int x){
        char q='0';
        int k=0;
        if(x==11) q='A';
        else if(x==12) q='B';
        else if(x==13) q='C';
        else if(x==14) q='D';
        else if(x==15) q='E';
        else if(x==16) q='F';
        else if(x==10) q='9';
        else if(x==9) q='8';
        else if(x==8) q='7';
        else if(x==7) q='6';
        else if(x==6) q='5';
        else if(x==5) q='4';
        else if(x==4) q='3';
        else if(x==3) q='2';
        else if(x==2) q='1';
        int u=0;
        int i=0;
        char[] S=s.toCharArray();
        while(i<s.length()){
            if(x<11 && S[i]>='0' && S[i]<=q)
                k+=1;
            else if(x>10 && ((S[i]>='A'&&S[i]<=q)||(S[i]>='0'&&S[i]<='9')))
                k+=1;
            if(S[i]=='.'|| S[i]==',') u+=1;
            i+=1;
        }
        return ((u+k)==s.length()&&u<=1);
    }

}
