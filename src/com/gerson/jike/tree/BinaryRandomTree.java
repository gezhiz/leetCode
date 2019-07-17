package com.gerson.jike.tree;

import java.util.Random;

/**
 * @author gezz
 * @description todo
 * @date 2019/7/15.
 */
public class BinaryRandomTree<T extends Comparable> extends BinaryTree<T> implements Tree<T> {

    private static Random random = new Random(System.currentTimeMillis());

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        return 0;
    }

    /**
     * 前根遍历
     *
     * @return
     */
    @Override
    public void preOrder() {
        System.out.println();
        System.out.println("前根遍历-------------------------start");
        preOrder(this.root);
        System.out.println();
        System.out.println("前根遍历-------------------------end");

    }
    private void preOrder(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getVal() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    /**
     * 中根遍历
     *
     * @return
     */
    @Override
    public void inOrder() {
        System.out.println();
        System.out.println("中根遍历-------------------------start");
        inOrder(this.root);
        System.out.println();
        System.out.println("中根遍历-------------------------end");
    }

    private void inOrder(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.print(node.getVal() + " ");
        inOrder(node.getRight());
    }



    /**
     * 后根遍历
     *
     * @return
     */
    @Override
    public void postOrder() {
        System.out.println();
        System.out.println("后根遍历-------------------------start");
        postOrder(this.root);
        System.out.println();
        System.out.println("后根遍历-------------------------end");
    }

    private void postOrder(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getVal() + " ");
    }

    @Override
    public void levelOrder() {
    }

    @Override
    public void insert(T data) {
        if (this.contains(data)) {
            return;
        }
        size++;
        root = insert(data, root);
    }

    /**
     * 插入操作，递归实现
     *
     * @param data 插入节点的data值
     * @param p    根节点、递归出口返回叶子节点
     * @return
     */
    private BinaryTreeNode<T> insert(T data, BinaryTreeNode p) {
        if (p == null) {
            //p 为null时就是递归出口
            p = new BinaryTreeNode(data, null, null);
        }

        int rand = random.nextInt(2);
        if (data.equals(p.getVal())) {
            //递归出口
            return p;
        } else if (rand % 2 == 0) {
            //左子树
            p.setRight(insert(data, p.getRight()));
        } else {
            //右子树
            p.setLeft(insert(data, p.getLeft()));
        }
        return p;
    }

    /**
     * 递归删除
     * 使用被删除元素的右子树中最小的元素替换被删除元素，然后递归处理
     *
     * @param data
     * @return
     */
    @Override
    public boolean remove(T data) {
        throw new RuntimeException("不支持remove");
    }

    @Override
    public T findMin() {
        return findMin(this.root).getVal();
    }

    @Override
    public T findMax() {
        return findMax(this.root).getVal();
    }

    @Override
    public BinaryTreeNode<T> findMin(BinaryTreeNode<T> node) {
        if (node.getLeft() != null && node.getRight() != null) {
            BinaryTreeNode<T> rMin = findMin(node.getRight());
            BinaryTreeNode<T> lMin = findMin(node.getLeft());
            BinaryTreeNode<T> lrMin = rMin.getVal().compareTo(lMin.getVal()) > 0 ? lMin : rMin;
            return lrMin.getVal().compareTo(node.getVal()) > 0 ? node : lrMin;
        } else if (node.getRight() != null) {
            BinaryTreeNode<T> rMin = findMin(node.getRight());
            return rMin.getVal().compareTo(node.getVal()) > 0 ? node : rMin;
        } else if (node.getLeft() != null) {
            BinaryTreeNode<T> lMin = findMin(node.getLeft());
            return lMin.getVal().compareTo(node.getVal()) > 0 ? node : lMin;
        } else {
            return node;
        }
    }

    @Override
    public BinaryTreeNode<T> findMax(BinaryTreeNode<T> node) {
        if (node.getLeft() != null && node.getRight() != null) {
            BinaryTreeNode<T> rMax = findMax(node.getRight());
            BinaryTreeNode<T> lMax = findMax(node.getLeft());
            BinaryTreeNode<T> lrMax = rMax.getVal().compareTo(lMax.getVal()) < 0 ? lMax : rMax;
            return lrMax.getVal().compareTo(node.getVal()) < 0 ? node : lrMax;
        } else if (node.getRight() != null) {
            BinaryTreeNode<T> rMax = findMax(node.getRight());
            return rMax.getVal().compareTo(node.getVal()) < 0 ? node : rMax;
        } else if (node.getLeft() != null) {
            BinaryTreeNode<T> lMax = findMax(node.getLeft());
            return lMax.getVal().compareTo(node.getVal()) < 0 ? node : lMax;
        } else {
            return node;
        }
    }

    @Override
    public BinaryTreeNode<T> findNode(T data) {
        return findNode(this.root,data);
    }

    private BinaryTreeNode<T> findNode(BinaryTreeNode<T> node, T data) {
        if (node == null) {
            return null;
        }
        int compareResult = data.compareTo(node.getVal());
        BinaryTreeNode<T> result = null;
        if (compareResult == 0) {
            result = node;
        }
        if (result == null){
            result = findNode(node.getRight(), data);
        }
        if (result == null){
            result = findNode(node.getLeft(), data);
        }
        return result;
    }

    @Override
    public boolean contains(T data) {
        return findNode(data) != null;
    }

    @Override
    public void clear() {
        size = 0;
        this.root = null;
    }
}
