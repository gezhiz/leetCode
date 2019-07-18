package com.gerson.jike.tree;

/**
 * @author gezz
 * @description todo
 * @date 2019/7/17.
 */
public abstract class BinaryTree<T extends Comparable> implements Tree<T> {

    /**
     * 根节点
     */
    protected BinaryTreeNode<T> root;

    protected int size;


    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public abstract BinaryTreeNode<T> lowestCommonAncestor(BinaryTreeNode<T> p, BinaryTreeNode<T> q);

    public abstract BinaryTreeNode<T> findNode(BinaryTreeNode<T> node, T data);
}
