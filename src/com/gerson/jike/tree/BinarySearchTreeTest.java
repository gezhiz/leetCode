package com.gerson.jike.tree;

import org.junit.Test;

import java.util.Random;

/**
 * @author gezz
 * @description todo
 * @date 2019/7/15.
 */
public class BinarySearchTreeTest {
    @Test
    public void testInsert() {
        BinaryTree<Integer> binarySearchTree = generateTree();
        binarySearchTree.remove(3);

        binarySearchTree.insert(3);
        for (int i = 1; i <= 9; i++) {
            BinaryTreeNode<Integer> binaryTreeNode = binarySearchTree.findNode(i);
            if (binaryTreeNode != null) {
                System.out.println(binaryTreeNode.getVal());
            }
        }
        System.out.println("max:" + binarySearchTree.findMax());
        System.out.println("min:" + binarySearchTree.findMin());

        while (binarySearchTree.size() > 0) {
            Integer max = binarySearchTree.findMax();
            binarySearchTree.remove(max);
        }

    }

    private BinaryTree<Integer> generateTree() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(8);
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(1);
        binarySearchTree.insert(9);
        return binarySearchTree;
    }

    private BinaryTree<Integer> generateRandTree() {
        BinaryTree<Integer> randTree = new BinaryRandomTree<>();
        randTree.insert(6);
        randTree.insert(7);
        randTree.insert(3);
        randTree.insert(2);
        randTree.insert(8);
        randTree.insert(4);
        randTree.insert(5);
        randTree.insert(1);
        randTree.insert(9);
        return randTree;
    }



    @Test
    public void insertRandom() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        int numSize = 100000;
        while (binarySearchTree.size() < numSize) {
            int random = new Random().nextInt(numSize);
            System.out.println("insert:" + random);
            binarySearchTree.insert(random);
        }

        while (binarySearchTree.size() > 10) {
            Integer max = binarySearchTree.findMax();
            if (max != null) {
                System.out.println("remove:" + max);
            }
            binarySearchTree.remove(max);
        }

        System.out.println("max:" + binarySearchTree.findMax());
        System.out.println("min:" + binarySearchTree.findMin());
    }

    @Test
    public void testPreOrder() {
        BinaryTree<Integer> binarySearchTree = generateTree();
        binarySearchTree.preOrder();
        binarySearchTree.inOrder();
        binarySearchTree.postOrder();
    }

    @Test
    public void testValidateSearch() {
        System.out.println(BinaryTreeUtil.isBinarySearchTree(generateTree()));
        BinaryTree<Integer> randTree = generateRandTree();
        System.out.println(BinaryTreeUtil.isBinarySearchTree(randTree));
    }
}
