package com.gerson.jike.tree;

import java.util.List;

/**
 * @author gezz
 * @description todo
 * @date 2019/7/15.
 */
public class TreeNode<T> {
    private T val;

    private List<TreeNode<T>> children;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public void addChild(TreeNode<T> child) {
        children.add(child);
    }

    public void removeChild(TreeNode<T> child) {
        child.removeChild(child);
    }

    public boolean isLeaf() {
        return children == null || children.size() == 0;
    }
}
