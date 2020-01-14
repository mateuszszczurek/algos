package com.algos.structures;

import java.util.ArrayList;
import java.util.List;

//https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
public class Graph {

    private final Node[] nodes;

    public Graph(int amountOfNodes, int[] edges) {
        nodes = new Node[amountOfNodes];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }
        for(int i= 0 ; i < edges.length; i+=2) {
            nodes[edges[i]].addEdge(edges[i+1]);
        }
    }

    class Node {

        private final int nodeIndex;

        private final List<Integer> edges = new ArrayList<>();

        Node(int nodeIndex) {
            this.nodeIndex = nodeIndex;
        }

        void addEdge(int toWhere) {
            edges.add(toWhere);
        }

        void traverse(boolean[] wasVisited) {
            System.out.println(nodeIndex);
            wasVisited[nodeIndex] = true;
            for (Integer edge : edges) {
                if(!wasVisited[edge]) {
                    nodes[edge].traverse(wasVisited);
                }
            }
        }

    }
    private void depthFirstTraversal() {
        boolean[] visited = new boolean[nodes.length];
        nodes[0].traverse(visited);
    }

    public static void main(String[] args) {

        // 2  - test cases
        // 4 3 - 3 number of nodes and edges
        // 0 1 1 2 0 3
        // Output -> print nodes while doing DFS starting from node 0

        int numberOfNodes = 4;
        int[] edges = {0, 1, 1, 2, 0, 3, 3, 0};

        Graph graph = new Graph(numberOfNodes, edges);

        graph.depthFirstTraversal();

    }


}
