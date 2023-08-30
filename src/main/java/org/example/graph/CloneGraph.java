package org.example.graph;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

//https://leetcode.com/problems/clone-graph/description/
public class CloneGraph {
    public Node cloneGraph(Node node) {
        Node[] visited = new Node[101];
        return dfs(node, visited);
    }

    public static Node dfs(Node node, Node[] visited) {
        if (node == null) {
            return null;
        }

        Node clonedNode = new Node(node.val);
        visited[node.val] = clonedNode;
        for(Node neighb : node.neighbors) {
            if (visited[neighb.val] == null) {
                Set<Integer> set = new HashSet<>();
                Node clonedNeigh = dfs(neighb, visited);
                //clonedNeigh.neighbors.add(clonedNode);
                clonedNode.neighbors.add(clonedNeigh);
            } else {
                clonedNode.neighbors.add(visited[neighb.val]);
            }
        }
        return clonedNode;
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(Arrays.asList(2,4));
        adjList.add(Arrays.asList(1,3));
        adjList.add(Arrays.asList(2,4));
        adjList.add(Arrays.asList(1,3));
        Map<String, Node> map = new HashMap<>();
        for (int i  = 1 ; i < adjList.size()+1 ; i++) {
            map.put("node"+i, new Node(i));
        }
        Node node1 = map.get("node1");
        Node node2 = map.get("node2");
        Node node3 = map.get("node3");
        Node node4 = map.get("node4");

        node1.neighbors.add(node2);node1.neighbors.add(node4);
        node2.neighbors.add(node1);node2.neighbors.add(node3);
        node3.neighbors.add(node2);node3.neighbors.add(node4);
        node4.neighbors.add(node1);node4.neighbors.add(node3);
        Node[] visited = new Node[101];
        Node clone = dfs(node1, visited);
        System.out.println("True");

    }

    public static Node createGraphFromAdj(List<List<Integer>> adjList, int[] visited, AtomicInteger i) {
        Node node = new Node(i.intValue());
        visited[i.intValue()] = 1;
        for (Integer integer : adjList.get(i.intValue() - 1)) {
            if (visited[integer] == 0) {
                Node neighNode = createGraphFromAdj(adjList, visited, new AtomicInteger(integer));
                node.neighbors.add(neighNode);
            }
        }
        visited[i.intValue()] = 0;
        return node;
    }
}
