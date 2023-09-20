package org.example.priorityqueue;

import java.util.PriorityQueue;

public class SamplePQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> defaultPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeapPQ = new PriorityQueue<>((o1, o2) -> o1 > o2 ? -1 : o1 == o2 ? 0 : 1);

        defaultPQ.offer(5);
        maxHeapPQ.offer(5);

        defaultPQ.offer(8);
        maxHeapPQ.offer(8);

        defaultPQ.offer(-1);
        maxHeapPQ.offer(-1);

        defaultPQ.offer(2);
        maxHeapPQ.offer(2);

        defaultPQ.offer(4);
        maxHeapPQ.offer(4);

        System.out.println(defaultPQ.peek());
        System.out.println(maxHeapPQ.peek());

    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 > o2 ? -1 : o1 == o2 ? 0 : 1);
        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int first =  pq.poll();
            int second = pq.poll();
            if(first-second > 0) {
                pq.add(first - second);
            }
        }

        return pq.size() == 1 ? pq.peek() : 0;
    }
}
