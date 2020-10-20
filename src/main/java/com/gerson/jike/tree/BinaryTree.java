package com.gerson.jike.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

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

    @Override
    public void levelOrder() {
        Queue<BinaryTreeNode> resultQueue = new LinkedBlockingDeque<BinaryTreeNode>();
        resultQueue.add(root);
        BinaryTreeNode<Integer> node = null;
        while ((node = resultQueue.poll()) != null) {
            System.out.print(node.getVal() + " ");
            if (node.getLeft() != null) {
                resultQueue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                resultQueue.add(node.getRight());
            }
        }
    }
}
