package com.algos.structures;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

public class Tree {

    public Tree(Node root) {
        this.root = root;
    }

    public static class Node {
        private Collection<Node> nodes;

        private Node(Collection<Node> nodes) {
            this.nodes = nodes;
        }

        public static Node node(Node ... nodes) {
            return new Node(Arrays.asList(nodes));
        }

        public static Node leaf() {
            return new Node(emptyList());
        }

        public Collection<Node> getNodes() {
            return nodes;
        }

    }

    private final Node root;

    public Node getRoot() {
        return root;
    }

}
