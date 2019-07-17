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
    private static <T extends Comparable> boolean isBinarySearchTree(BinaryTreeNode<T> rootNode) {
        if (rootNode == null) {
            return true;
        }
        if (rootNode.getLeft() != null && rootNode.getRight() != null) {
            return rootNode.getVal().compareTo(rootNode.getLeft().getVal()) > 0
                    && rootNode.getVal().compareTo(rootNode.getRight().getVal()) < 0
                    && isBinarySearchTree(rootNode.getRight())
                    && isBinarySearchTree(rootNode.getLeft())
                    ;
        } if (rootNode.getLeft() != null) {
            return rootNode.getVal().compareTo(rootNode.getLeft().getVal()) > 0
                    && isBinarySearchTree(rootNode.getLeft())
                    ;
        } else if (rootNode.getRight() != null) {
            return rootNode.getVal().compareTo(rootNode.getRight().getVal()) < 0
                    && isBinarySearchTree(rootNode.getRight())
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
        return isBinarySearchTree(tree.getRoot());
    }
}
