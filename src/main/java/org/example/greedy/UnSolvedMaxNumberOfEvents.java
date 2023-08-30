package org.example.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class UnSolvedMaxNumberOfEvents {
    public static int maxEvents(int[][] events) {

        Arrays.sort(events, (a,b) ->  {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int j = 0;
        int attended = 0;

        // by fefault, from small to big
        // PriorityQueue contains last day
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<100_001; i++) {
            //  remove from pq everything < currect day
            while(!pq.isEmpty() && pq.peek() < i)
                pq.poll();

            //  for all events started on day d, add the last day to queue
            for(; j<events.length && events[j][0] == i; j++) {
                pq.offer(events[j][1]);
            }

            if(!pq.isEmpty()) {
                pq.poll();
                attended++;
            }
        }

        return attended;
    }

    public static void main(String[] args) {
/*
        int[][] arr = new int[][]{
                {1,2},{2,3},{3,4},{1,2}
        };

        int[][] arr1 = new int[][]{
                {1,4},{4,4}, {2,2}, {3,4}, {1,1}
        };
        System.out.println(maxEvents(arr));
        System.out.println(maxEvents(arr1));

        int[][] arr2 = new int[][]{
                {1,2},{1,2}, {3,3}, {1,5}, {1,5}
        };
        System.out.println(maxEvents(arr2));
*/

        int[][] arr3 = new int[][]{
                {1,5},{1,5}, {1,5}, {2,3}, {2,3}
        };
        System.out.println(maxEvents(arr3));
    }
}
