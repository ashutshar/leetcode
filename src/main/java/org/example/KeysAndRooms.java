package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        int count = 0;
        int i = 0;
        Queue<Integer> queue = new LinkedList<Integer>(rooms.get(0));
        visited[0] = true;
        count++;
        while(!queue.isEmpty()) {
            int next = queue.poll();
            if(!visited[next]) {
                count++;
                queue.addAll(rooms.get(next));
                visited[next] = true;
            }
        }
        return count == rooms.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> list = List.of(
                List.of(1,3),
                List.of(3,0,1),
                List.of(2),
                List.of(0)
        );
        List<List<Integer>> list1 = List.of(
                List.of(0)
        );
        System.out.println(canVisitAllRooms(list));
        System.out.println(canVisitAllRooms(list1));
    }
}
