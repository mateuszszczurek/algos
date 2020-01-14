package com.algos.trees;

import com.algos.structures.Tree;
import com.algos.structures.Tree.Node;

import java.util.Set;

import static com.algos.structures.Tree.Node.leaf;
import static com.algos.structures.Tree.Node.node;

//https://www.geeksforgeeks.org/sum-of-lengths-of-all-paths-possible-in-a-given-tree/
public class SumOfLengths {

    public static void main(String[] args) {
        var tree = new Tree(
                node(
                        node(
                                leaf(), leaf()),
                        leaf()
                )
        );

        // TODO
//        System.out.println(sumOfLengths(tree));
    }

//    public static int sumOfLengths(Tree tree) {
//        return checkPaths(tree.getRoot(), 0);
//    }

    private static int checkPaths(Node current, int lengthSoFar, Set<Route> knownRoutes) {
        return 0;
    }

    public static class Route {

        private final int start;
        private final int end;

        public Route(int start, int end) {
            if (start > end) {
                this.start = start;
                this.end = end;
            } else {
                this.start = end;
                this.end = start;
            }
        }
    }
}
