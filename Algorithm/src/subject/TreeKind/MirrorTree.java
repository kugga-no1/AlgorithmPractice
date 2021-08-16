package subject.TreeKind;

/**
 * @program: MirrorTree
 * @description: 二叉树的镜像
 * @author: liyifan
 * @create: 2021/08/16/10:19
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * @question:请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @思路:遍历树（先序遍历，用栈，用队列都可以 这里用队列）交互子节点
 */
public class MirrorTree {
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  /**
   * @辅助队列
   */
    public static TreeNode mirrorTree(TreeNode root) {
          if(root==null){
              return null;
          }
          Deque<TreeNode> deque=new LinkedList<TreeNode>();
          deque.offer(root);
          while(!deque.isEmpty()){
              TreeNode node = deque.poll();
              TreeNode tmp;
              tmp=node.left;
              node.left=node.right;
              node.right=tmp;
              if (node.left!=null){
                  deque.offer(node.left);
              }
              if(node.right!=null){
                  deque.offer(node.right);
              }
          }
        return root;
    }


    /**
     * 先序遍历
     */
    public static TreeNode mirrorTree2(TreeNode root){
        exchange(root);
        return root;
    }
    public static void exchange(TreeNode root){
        if(root==null){
            return ;
        }
        System.out.println(root.val);
        TreeNode tmp;
        tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        exchange(root.left);
        exchange(root.right);
    }

}
