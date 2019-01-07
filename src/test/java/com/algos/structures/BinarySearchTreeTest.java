package com.algos.structures;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinarySearchTreeTest {

    @Test
    public void should_add_to_binary_search_tree(){

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(5);
        tree.insert(3);
        tree.insert(1);
        tree.insert(4);
        tree.insert(8);

        assertTrue(tree.lookup(1));
        assertFalse(tree.lookup(9));
        assertFalse(tree.lookup(0));
    }

}