/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
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
    public TreeNode invertTree(TreeNode root) {
        invertSubTree(root);
        return root;
    }

    public void invertSubTree(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertSubTree(node.left);
        invertSubTree(node.right);
    }
}
// @lc code=end

