package subject.SearchBacktrackingKind;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: TreePathSum
 * @description: 剑指 Offer 34. 二叉树中和为某一值的路径
 * @author: liyifan
 * @create: 2021/08/24/9:07
 */


public class TreePathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static List<Integer> path=new LinkedList<>();
    static List<List<Integer>> res=new LinkedList<>();
    static  List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target);
        return res;
    }

    static void dfs(TreeNode root,int target){
    if(root==null){
        return;
    }
    target=target-root.val;
    path.add(root.val);
    if(target==0&&root.left==null&&root.right==null){
        res.add(new LinkedList<>(path));
    }
    dfs(root.left,target);
    dfs(root.right,target);
    path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);

        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        dfs(treeNode,7);
        System.out.println(path);
    }

}
