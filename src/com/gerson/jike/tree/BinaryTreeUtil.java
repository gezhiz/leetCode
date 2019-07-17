package com.gerson.jike.tree;

/**
 * @author gezz
 * @description todo
 * @date 2019/7/17.
 */
public class BinaryTreeUtil {

    /**
     * 递归方法判定一颗二叉树是否为二叉搜索树
     * @param rootNode
     * @param <T>
     * @return
     */
    private static <T extends Comparable> boolean isBinarySearchTree(BinaryTree<T> tree, BinaryTreeNode<T> rootNode) {
        if (rootNode == null) {
            return true;
        }
        if (rootNode.getLeft() != null && rootNode.getRight() != null) {
            return rootNode.getVal().compareTo(tree.findMax(rootNode.getLeft()).getVal()) > 0
                    && rootNode.getVal().compareTo(tree.findMin(rootNode.getRight()).getVal()) < 0
                    && isBinarySearchTree(tree,rootNode.getRight())
                    && isBinarySearchTree(tree,rootNode.getLeft())
                    ;
        } if (rootNode.getLeft() != null) {
            return rootNode.getVal().compareTo(tree.findMax(rootNode.getLeft()).getVal()) > 0
                    && isBinarySearchTree(tree,rootNode.getLeft())
                    ;
        } else if (rootNode.getRight() != null) {
            return rootNode.getVal().compareTo(tree.findMin(rootNode.getRight()).getVal()) < 0
                    && isBinarySearchTree(tree,rootNode.getRight())
                    ;
        }
        return true;
    }

    /**
     * 递归方法判定一颗二叉树是否为二叉搜索树
     * @param tree
     * @param <T>
     * @return
     */
    public static <T extends Comparable> boolean isBinarySearchTree(BinaryTree<T> tree) {
        if (tree == null || tree.getRoot() == null) {
            return true;
        }
        return isBinarySearchTree(tree, tree.getRoot());
    }

}
