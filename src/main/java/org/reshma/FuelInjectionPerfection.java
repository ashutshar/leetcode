package org.reshma;

import java.math.BigInteger;

public class FuelInjectionPerfection {
    public static void main(String[] args) {
        //System.out.println("Num of operations required for fuel injection : "+getNumOperations("1212671267650600228229401496703205376650600221267612676506002282294014967032053765060012676506002282294014967032053762282294014967032053768229401496703205376126765060022822940149612671267650600228229401496703205376650600221267612676506002282294014967032053765060012676506002282294014967032053762282294014967032053768229401496703205376126765060022822940149670320537612676506002282294014967032053761267126765060022822940149670320537665060022126761267650600228229401496703205376506001267650600228229401496703205376228229401496703205376822940149670320537612676506002282294014967032053761267650600228229401496703205376126712676506002282294014967032053766506002212676126765060022822940149670320537650600126765060022822940149670320537622822940149670320537682294014967032053761267650600228229401496126712676506002282294014967032053766506002212676126765060022822940149670320537650600126765060022822940149670320537622822940149670320537682294014967032053761267650600228229401496703205376126765060022822940149670320537612671267650600228229401496703205376650600221267612676506002282294014967032053765060012676506002282294014967032053762282294014967032053768229401496703205376126765060022822940149612671267650600228229401496703205376650600221267612676506002282294014967032053765060012676506002282294014967032053762282294014967032053768229401496703205376126765060022822940149670320537612676506002282294014967032053761267126765060022822940149670320537665060022126761267650600228229401496703205376506001267650600228229401496703205376228229401496703205376822940149670320537612676506002282294014967032053761267650600228229401496703205376126712676506002282294014967032053766506002212676126765060022822940149670320537650600126765060022822940149670320537622822940149670320537682294014967032053761267650600228229401496703205376126765060022822940149670320537612671267650600228229401496703205376650600221267612676506002282294014967032053765060012676506002282294014967032053762282294014967032053768229401496703205376126765060022822940149670320537612676506002282294014967032053767032053761267650600228229401496703205376703205376126765060022822940149670320537670320537612676506002282294014967032053766712676506002282294014967032053766506002212676126765060022126712676506002282294014967032053766506002212676126765060022822940149670320537650600126765060022822940149670320537622822940149670320537682294014967032053761267650600228229401496703205376126765126712676506002282294014967032053766506002212676126765060022822940149670320537650600126765060022822940149670320537622822940149670320537682294014967032053761267650600228229401496703205376126765060022822940149670320537606002282294014967032053768229401496703205376506001267650600228229401496703205376228229401496703205376822940149670320537612676506002282294014967032053761267650600228229401496703205376"));
        System.out.println("Num of operations required for fuel injection : "+getNumOperations("100"));

    }
    public static int getNumOperations(String s){
        System.out.println("s.length : "+s.length());
        if(s.equalsIgnoreCase("1"))
            return 0;
        BigInteger b = new BigInteger(s);
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger four = new BigInteger("4");

        int count=0;
        while(b.intValue()!=1){
            if(b.remainder(two).intValue() == 0){
                b = b.divide(two);
            }else{
                BigInteger b1 = b.subtract(one);
                BigInteger b2 = b.add(one);
                if(b1.remainder(four).intValue() == 0 || b1.equals(two))
                    b = b1;
                else if (b2.remainder(four).intValue() == 0){
                    b = b2;
                }
            }
            count++;

        }

        return count;
    }
}
