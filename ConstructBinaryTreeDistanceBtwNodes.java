package com.ishm.codingchallenge.leetcode;


import java.util.Arrays;
import java.util.List;

public class ConstructBinaryTreeDistanceBtwNodes {

    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        int node1 = 1, node2 = 3;

        System.out.println(distBwTwoNodes(nums,node1,node2));
    }

    public static int distBwTwoNodes(int[] nums ,  int node1, int node2)
    {
        TreeNode root = new TreeNode(nums[0]);
        boolean n1 = false;
        boolean n2 = false;
        if(nums[0] == node1)
            n1=true;
        if(nums[0] == node2)
            n2=true;

        // construct BST
        for(int i=1;i<nums.length;i++){
            insertIntoBST(root, nums[i]);
            if(nums[i] == node1)
                n1=true;
            if(nums[i] == node2)
                n2=true;
        }

        if(n1==false || n2==false)
            return -1;
        TreeNode lca = lowestCommonAncestor(root, new TreeNode(node1), new TreeNode(node2));
        int d1 = finDis(lca,node1,0);
        int d2 = finDis(lca,node2,0);
        return d1+d2;
    }

    public static int finDis(TreeNode lca, int val, int d){
        if(lca.val==val)
            return d;

        if(lca.val < val)
            return finDis(lca.right,val,++d);


        return finDis(lca.left,val,++d);
    }

    // insert a val to BSt with root given root
    public static TreeNode insertIntoBST(TreeNode root, int val)
    {
        TreeNode droot = root;
        TreeNode par =  find(droot, val, null);
        if(par==null)
            return par;
        if(par.val < val)
            par.right = new TreeNode(val);
        else
            par.left = new TreeNode(val);
        return root;
    }

    public static TreeNode find(TreeNode root, int val, TreeNode p)
    {
        if(root==null)
            return p;

        if(root.val > val)
            return find(root.left, val, root);


        return find(root.right, val, root);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > Math.max(p.val, q.val))
            return lowestCommonAncestor(root.left, p, q);
        else if(root.val < Math.min(p.val ,q.val))
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val = x;
    }
}
