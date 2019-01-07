package com.algos.structures;

public class BinarySearchTree {

    static class Node {

        private Node left;
        private Node right;

        private int value;

        Node(int value) {
            this.value = value;
        }

        Node getLeft() {
            return left;
        }

        Node getRight() {
            return right;
        }

        int getValue() {
            return value;
        }

        public void setRight(Node leftNode) {
            safetyCheck(this.right);
            this.right = leftNode;
        }

        private void safetyCheck(Node node) {
            if (node != null) {
                throw new IllegalStateException();
            }
        }

        public void setLeft(Node leftNode) {
            safetyCheck(this.left);
            this.left = leftNode;
        }
    }

    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insertNode(value, root);
        }
    }

    private void insertNode(int value, Node node) {

        if (leftEmpty(value, node)) {
            node.setLeft(new Node(value));
        } else if (rightEmpty(value, node)) {
            node.setRight(new Node(value));
        } else if (leftOccupied(value, node)) {
            insertNode(value, node.getLeft());
        } else if (rightOccupied(value, node)) {
            insertNode(value, node.getRight());
        } else {
            throw new IllegalStateException();
        }
    }

    private boolean rightOccupied(int value, Node node) {
        return rightCondition(value, node.getValue()) && node.getRight() != null;
    }

    private boolean leftOccupied(int value, Node node) {
        return leftCondition(value, node.getValue()) && node.getLeft() != null;
    }

    private boolean rightEmpty(int value, Node node) {
        return rightCondition(value, node.getValue()) && node.getRight() == null;
    }

    private boolean leftEmpty(int value, Node node) {
        return leftCondition(value, node.getValue()) && node.getLeft() == null;
    }

    public boolean lookup(int value) {
        return root.getValue() == value || recursiveLookup(value, root);
    }

    private boolean recursiveLookup(int value, Node node) {
        int nodeValue = node.getValue();

        if(nodeValue == value) {
            return true;
        } else if (leftOccupied(value, node)) {
            return recursiveLookup(value, node.getLeft());
        } else if (rightOccupied(value, node)) {
            return recursiveLookup(value, node.getRight());
        } else if (leftEmpty(value, node)) {
            return false;
        } else if (rightEmpty(value, node)) {
            return false;
        }
        throw new IllegalStateException();
    }

    public boolean iterativeLookup(int value) {
        return false;
    }

    public void delete(int value) {

    }

    public void treeDepth() {

    }

    private boolean rightCondition(int value, int nodeValue) {
        return value > nodeValue;
    }

    private boolean leftCondition(int value, int nodeValue) {
        return value <= nodeValue;
    }

}
