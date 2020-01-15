/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversalTree(res, root);
        return res;
    }

    public void inorderTraversalTree(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversalTree(list, root.left);
        list.add(root.val);
        inorderTraversalTree(list, root.right);
    }
}
// @lc code=end

