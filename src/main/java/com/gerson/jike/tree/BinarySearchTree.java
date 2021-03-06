package com.gerson.jike.tree;

import com.gerson.leetcode.structure.MyStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author gezz
 * @description todo
 * @date 2019/7/15.
 */
public class BinarySearchTree<T extends Comparable> extends BinaryTree<T> implements Tree<T> {

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
     * 二叉搜索树的中根遍历的结果是一个递增的数组
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
    public void insert(T data) {
        if (data == null) {
            throw new RuntimeException("data can not be null!");
        }
        if ((findNode(data) != null)) {
            return;
        }
        size++;
        //给root赋值，第一次插入时需要赋值
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
        //根据大小比较的结果，判定应该插入左子树还是右子树
        int compareResult = data.compareTo(p.getVal());
        if (compareResult > 0) {
            //左子树
            p.setRight(insert(data, p.getRight()));
        } else if (compareResult < 0) {
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
        BinaryTreeNode<T> parent = null;
        BinaryTreeNode<T> targetNode = this.root;
        if (targetNode == null) {
            return false;
        }
        //寻找data对应的节点和其parent节点
        boolean isRightChild = false;
        while (targetNode != null) {
            if (targetNode.getLeft() != null && data.compareTo(targetNode.getVal()) < 0) {
                //优先处理data小于左子树根节点的情况
                parent = targetNode;
                targetNode = targetNode.getLeft();
                isRightChild = false;
            } else if (targetNode.getRight() != null && data.compareTo(targetNode.getVal()) > 0) {
                parent = targetNode;
                targetNode = targetNode.getRight();
                isRightChild = true;
            } else {
                break;
            }
        }
        if (targetNode.getVal() != data) {
            //未找到节点
            return false;
        }
        if (targetNode == this.root) {
            //目标节点是根节点
            BinaryTreeNode<T> successor = generateSuccessor(targetNode);
            this.root = successor;
        } else if (targetNode.isLeaf()) {
            //叶子节点
            if (isRightChild) {
                parent.setRight(null);
            } else {
                parent.setLeft(null);
            }
        } else {
            //从右子树中寻找后继子树
            BinaryTreeNode<T> successor = generateSuccessor(targetNode);
            if (isRightChild) {
                parent.setRight(successor);
            } else {
                parent.setLeft(successor);
            }
        }
        size--;
        return true;
    }

    @Override
    public T findMin() {
        BinaryTreeNode<T> curNode = this.findMin(this.root);
        return curNode != null ? curNode.getVal() : null;
    }

    /**
     * 重构node子树,找到node右子树中最小的节点作为根构造一棵树
     *
     * @param node
     * @return
     */
    private BinaryTreeNode<T> generateSuccessor(BinaryTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode<T> successor = node.getRight();
        if (successor != null) {
            //优先从右子树开始寻找
            //右子树不为空
            BinaryTreeNode<T> parent = null;
            while (successor.getLeft() != null) {
                parent = successor;
                successor = successor.getLeft();
            }
            if (parent != null) {
                parent.setLeft(successor.getRight());
            }
            if (successor != node.getRight()) {
                successor.setRight(node.getRight());
            }
            successor.setLeft(node.getLeft());
        } else if (node.getLeft() != null) {
            //左子树不为空
            return node.getLeft();
        } else {
            //叶子节点
            return null;
        }
        return successor;
    }

    @Override
    public BinaryTreeNode<T> findMin(BinaryTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode<T> curNode = node;
        while (curNode.getLeft() != null) {
            curNode = curNode.getLeft();
        }
        if (curNode == null) {
            curNode = node.getRight();
        }
        return curNode;
    }

    @Override
    public T findMax() {
        BinaryTreeNode<T> curNode = this.findMax(this.root);
        return curNode != null ? curNode.getVal() : null;
    }

    @Override
    public BinaryTreeNode findMax(BinaryTreeNode<T> root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode<T> curNode = root;
        while (curNode.getRight() != null) {
            curNode = curNode.getRight();
        }
        if (curNode == null) {
            curNode = curNode.getLeft();
        }
        return curNode;
    }

    @Override
    public BinaryTreeNode<T> findNode(T data) {
        return findNode(this.root,data);
    }


    @Override
    public BinaryTreeNode<T> findNode(BinaryTreeNode<T> node, T data) {
        BinaryTreeNode<T> curNode = node;
        while (curNode != null) {
            int compareResult = data.compareTo(curNode.getVal());
            if (compareResult == 0) {
                return curNode;
            } else if (compareResult > 0) {
                curNode = curNode.getRight();
            } else if (compareResult < 0) {
                curNode = curNode.getLeft();
            }
        }
        return null;
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


    /**
     * 最近公共父节点
     * @param p
     * @param q
     * @return
     */
    @Override
    public BinaryTreeNode<T> lowestCommonAncestor(BinaryTreeNode<T> p, BinaryTreeNode<T> q) {
        return lowestCommonAncestor(this.root, p, q);
    }

    private BinaryTreeNode<T> lowestCommonAncestor(BinaryTreeNode<T> rootNode, BinaryTreeNode<T> p, BinaryTreeNode<T> q) {
        if (rootNode.getVal().compareTo(q.getVal()) > 0 && rootNode.getVal().compareTo(p.getVal()) > 0) {
            //比p q都大，寻找左子树
            return lowestCommonAncestor(rootNode.getLeft(),p,q);
        } else if (rootNode.getVal().compareTo(q.getVal()) < 0 && rootNode.getVal().compareTo(p.getVal()) < 0){
            //比p q都小，寻找右子树
            return lowestCommonAncestor(rootNode.getRight(),p,q);
        }
        return rootNode;
    }

    /**
     * 广度有限搜索算法
     */
    public List<T> breadthSearch() {
        List result = new ArrayList<>(size());
        Queue<BinaryTreeNode<T>> queue = new ArrayBlockingQueue<BinaryTreeNode<T>>(size());
        BinaryTreeNode<T> root = this.root;
        queue.add(root);
        while (queue.size() > 0) {
            BinaryTreeNode node = queue.poll();
            result.add(node.getVal());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return result;
    }

    /**
     * 广度有限搜索算法 :层级遍历
     */
    public List<List<T>> breadthLevelOrder() {
        List<List<T>> result = new ArrayList<>();
        Queue<BinaryTreeNode<T>> queue = new ArrayBlockingQueue<BinaryTreeNode<T>>(size());
        BinaryTreeNode<T> root = this.root;
        queue.add(root);
        while (queue.size() > 0) {
            //核心点 ： len记录出队列之前队列长度，决定出几个元素
            int len = queue.size();
            List curResult = new ArrayList();
            for (int i = 0; i < len; i++) {
                BinaryTreeNode node = queue.poll();
                curResult.add(node.getVal());
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            result.add(curResult);
        }
        return result;
    }

    /**
     * 深度有限搜索算法 使用栈
     */
    public List<T> deapSearch_Stack() {
        List result = new ArrayList<>(size());
        MyStack<BinaryTreeNode<T>> stack = new MyStack<BinaryTreeNode<T>>();
        BinaryTreeNode<T> root = this.root;
        stack.push(root);
        BinaryTreeNode nodeItem;
        while ((nodeItem = stack.pop()) != null) {
            result.add(nodeItem.getVal());

            if (nodeItem.getRight() != null) {
                stack.push(nodeItem.getRight());
            }
            if (nodeItem.getLeft() != null) {
                stack.push(nodeItem.getLeft());
            }
        }
        return result;
    }

    /**
     * 深度优先遍历算法,递归实现
     * @return
     */
    public List<T> deapSearch() {
        List result = new ArrayList<>(size());
        deapSearchHelp(result, this.root);
        return result;
    }

    private void deapSearchHelp(List result, BinaryTreeNode node) {
        result.add(node.getVal());
        if (node.getLeft() != null) {
            deapSearchHelp(result, node.getLeft());
        }
        if (node.getRight() != null) {
            deapSearchHelp(result, node.getRight());
        }
    }

    /**
     * 最大深度和最小深度
     * @return
     */
    public MinMaxDepth minMaxDepth() {
        MinMaxDepth result = new MinMaxDepth();
        Queue<BinaryTreeNode> queue = new ArrayBlockingQueue<BinaryTreeNode>(size());
        queue.add(this.root);
        int depth = 0;
        while (queue.size() > 0) {
            depth++;
            int len = queue.size();
            for (int i = 0; i< len; i++) {
                BinaryTreeNode node = queue.poll();
                if (node.isLeaf() && result.getMin() == null) {
                    //第一个叶子节点就是最小深度
                    result.setMin(depth);
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
            }
        }
        result.setMax(depth);
        return result;

    }

    public static class MinMaxDepth {
        private Integer max;
        private Integer min;

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }

        public Integer getMin() {
            return min;
        }

        public void setMin(Integer min) {
            this.min = min;
        }

        @Override
        public String toString() {
            return "MinMaxDepth{" +
                    "max=" + max +
                    ", min=" + min +
                    '}';
        }
    }

}
