package com.gerson.jike.tree;

/**
 * @author gezz
 * @description 二叉树节点
 * @date 2019/7/11.
 */
public class BinaryTreeNode<T extends Comparable> {

    /**
     * 值
     */
    private T val;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(T val, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }


    public boolean isLeaf() {
        return this.right == null && this.left == null;
    }

    public class Accessor {
        public static final String EX = "";
//        public static String EX1 = "";//非静态类不允许定义这种静态成员变量
        /**
         * 访问
         * @param node
         */
        public void access(BinaryTreeNode node) {
            System.out.println(node.getVal());
        }
    }

}
