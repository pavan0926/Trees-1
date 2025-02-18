// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer,Integer> inorderIndexMap=new HashMap<>();
    int preorderIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null)
        return null;
        for(int i=0;i<inorder.length;i++){
            inorderIndexMap.put(inorder[i],i);
        }
        return createtree(preorder,0,preorder.length-1);
    }

    public TreeNode createtree(int[] preorder,int left,int right){
        if(left>right) return null;
        int rootVal=preorder[preorderIndex++];
        TreeNode root=new TreeNode(rootVal);
        root.left=createtree(preorder,left,inorderIndexMap.get(rootVal)-1);
        root.right=createtree(preorder,inorderIndexMap.get(rootVal)+1,right);
        return root;
    }
}