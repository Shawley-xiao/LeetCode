/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rval = root.val;
        int pval = p.val;
        int qval = q.val;
        if (pval > rval && qval > rval) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pval < rval && qval < rval) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
// @lc code=end

