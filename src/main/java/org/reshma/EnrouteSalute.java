package org.reshma;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class EnrouteSalute {
    public static void main(String[] args) {
        System.out.println("no. salutes : " + getSalute("--->-><-><-->-"));
    }
    public static int getSalute(String s){
        char[] ch = s.toCharArray();
        int count=0;
        for(int i = 0;i<ch.length-1;i++){
            if(ch[i]=='>') {
                for (int j = i + 1; j < ch.length; j++) {
                    if(ch[j]=='<') {
                        count=count+2;
                    }
                    }
                }
            }
        return count;
    }
}
