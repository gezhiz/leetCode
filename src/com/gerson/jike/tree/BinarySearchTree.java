package com.gerson.jike.tree;

/**
 * @author gezz
 * @description todo
 * @date 2019/7/15.
 */
public class BinarySearchTree<T extends Comparable> implements Tree<T> {

    /**
     * 根节点
     */
    private BinaryTreeNode<T> root;

    private int size;

    @Override
    public boolean isEmpty() {
        return false;
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
     * @return
     */
    @Override
    public String preOrder() {
        return null;
    }

    /**
     * 中跟遍历
     * @return
     */
    @Override
    public String inOrder() {
        return null;
    }

    /**
     * 后跟遍历
     * @return
     */
    @Override
    public String postOrder() {
        return null;
    }

    @Override
    public String levelOrder() {
        return null;
    }

    @Override
    public void insert(T data) {
        if (data == null) {
            throw new RuntimeException("data can not be null!");
        }
        //给root赋值，第一次插入时需要赋值
        root = insert(data,root);
        size++;
    }

    /**
     * 插入操作，递归实现
     * @param data  插入节点的data值
     * @param p 根节点、递归出口返回叶子节点
     * @return
     */
    private BinaryTreeNode<T> insert(T data, BinaryTreeNode p) {
        if (p == null) {
            //p 为null时就是递归出口
            p = new BinaryTreeNode(data, null, null);
        }
        //根据大小比较的结果，判定应该插入左子树还是右子树
        int compareResult = data.compareTo(p.getVal());
        if (compareResult > 0) {
            //左子树
            p.setLeft(insert(data,p.getLeft()));
        } else if (compareResult < 0) {
            //右子树
            p.setRight(insert(data,p.getLeft()));
        }
        return p;
    }

    /**
     * 递归删除
     * 使用被删除元素的右子树中最小的元素替换被删除元素，然后递归处理
     * @param data
     * @return
     */
    @Override
    public boolean remove(T data) {

    }

    @Override
    public T findMin() {
        if (this.root == null) {
            return null;
        }
        BinaryTreeNode<T> curNode = root;
        while(curNode.getLeft() != null) {
            curNode = curNode.getLeft();
        }
        return curNode.getVal();
    }

    @Override
    public T findMax() {
        if (this.root == null) {
            return null;
        }
        BinaryTreeNode<T> curNode = root;
        while(curNode.getRight() != null) {
            curNode = curNode.getRight();
        }
        return curNode.getVal();
    }

    @Override
    public BinaryTreeNode<T> findNode(T data) {
        return null;
    }

    @Override
    public boolean contains(T data) throws Exception {
        return false;
    }

    @Override
    public void clear() {

    }
}
