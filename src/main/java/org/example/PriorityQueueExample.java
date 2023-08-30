package org.example;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements to the priority queue
        pq.offer(5);
        pq.offer(1);
        pq.offer(3);
        pq.offer(2);
        pq.offer(4);


        // Retrieve and remove the element with the highest priority
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}