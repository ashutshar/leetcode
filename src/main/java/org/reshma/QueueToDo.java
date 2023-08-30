package org.reshma;

public class QueueToDo {
    public static void main(String[] args) {
        System.out.println("Get checksum of getChecksum(0,3) : "+ getChecksum(0,3));
    }
    public static int getChecksum(int start,int length){
        int count = length;
        int chksum = 0;
    int mid = 0;
    for(int i =0;i<length;i++){
        mid = start + i*length;
        chksum = chksum^mid;
        System.out.println("mem ID :"+mid);
        int next = mid+1;
        for(int j =1;j<count;j++){
            System.out.println("mem ID :"+mid+" next : "+next);
            chksum = chksum^next;
           System.out.println("cheksum :"+chksum);
            next++;
        }

        count--;
        System.out.println("count :"+count);
    }
        return chksum;
    }
}
