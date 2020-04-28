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


    /**
     * 中序遍历的方法，递归判定是否为排序树
     * 核心：
     * 中序遍历的递归过程，反复判断每一个节点是否符合左节点是否小于根，右节点是否大于根
     * @param tree
     * @param <T>
     * @return
     */
    public static<T extends Comparable> boolean isBinSearchTree(BinaryTree tree) {
        if (tree == null || tree.getRoot() == null) {
            return true;
        }
        return isBinSearchTree(tree.getRoot());
    }

    private static <T extends Comparable> boolean isBinSearchTree(BinaryTreeNode<T> root) {
        if (root == null) {
            return true;
        }
        BinaryTreeNode<T> left = root.getLeft();
        BinaryTreeNode<T> right = root.getRight();
        if (left != null && left.getVal().compareTo(root.getVal()) > 0) {
            return false;
        }
        if (right != null && right.getVal().compareTo(root.getVal()) < 0) {
            return false;
        }
        return isBinSearchTree(root.getLeft()) && isBinSearchTree(root.getRight());
    }
}
