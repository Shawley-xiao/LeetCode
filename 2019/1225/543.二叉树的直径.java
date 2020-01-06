/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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

    int ans = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        diameterOfBinaryTreeFrom(root);
        return ans - 1;
    }

    public int diameterOfBinaryTreeFrom(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int L = diameterOfBinaryTreeFrom(node.left);
        int R = diameterOfBinaryTreeFrom(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }
}
// @lc code=end

