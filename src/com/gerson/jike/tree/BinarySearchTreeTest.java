package com.gerson.jike.tree;

import org.junit.Test;

/**
 * @author gezz
 * @description todo
 * @date 2019/7/15.
 */
public class BinarySearchTreeTest {
    @Test
    public void testInsert() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(6);
        binarySearchTree.insert(1);
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        binarySearchTree.insert(8);
        binarySearchTree.insert(9);
        binarySearchTree.insert(9);
    }
}
