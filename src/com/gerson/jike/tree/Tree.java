package com.gerson.jike.tree;

/**
 * @author gezz
 * @description todo
 * @date 2019/7/15.
 */

public interface Tree<T extends Comparable> {

    /**
     * 判空
     * @return
     */
    boolean isEmpty();

    /**
     * 二叉树的结点个数
     * @return
     */
    int size();

    /**
     * 返回二叉树的高度或者深度,即结点的最大层次
     * @return
     */
    int height();

    /**
     * 先根次序遍历
     */
    void preOrder();

    /**
     * 中根次序遍历
     */
    void inOrder();

    /**
     * 后根次序遍历
     */
    void postOrder();

    /**
     * 层次遍历
     */
    void levelOrder();

    /**
     * 将data 插入
     * @return
     */
    void insert(T data);

    /**
     * 删除
     */
    boolean remove(T data);

    /**
     * 查找最大值
     * @return
     */
    T findMin();

    /**
     * 查找最小值
     * @return
     */
    T findMax();

    BinaryTreeNode<T> findMin(BinaryTreeNode<T> node);

    BinaryTreeNode<T> findMax(BinaryTreeNode<T> node);

    /**
     * 根据值找到结点
     * @param data
     * @return
     */
    BinaryTreeNode<T> findNode(T data);

    /**
     * 是否包含某个值
     * @param data
     * @return
     */
    boolean contains(T data) throws Exception;

    /**
     * 清空
     */
    void clear();
}