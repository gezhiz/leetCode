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
        throw new RuntimeException("不支持findMin");
    }

    @Override
    public T findMax() {
        throw new RuntimeException("不支持findMax");
    }

    @Override
    public BinaryTreeNode<T> findNode(T data) {
        BinaryTreeNode<T> curNode = this.root;
        while(curNode != null) {
            int compareResult = data.compareTo(curNode.getVal());
            if (compareResult == 0) {
                return curNode;
            } else if (compareResult > 0){
                curNode = curNode.getRight();
            } else if (compareResult < 0){
                curNode = curNode.getLeft();
            }
        }
        return null;
    }

    @Override
    public boolean contains(T data) throws Exception {
        return findNode(data) != null;
    }

    @Override
    public void clear() {
        size = 0;
        this.root = null;
    }
}
