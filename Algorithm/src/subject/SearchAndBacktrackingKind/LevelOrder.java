package subject.SearchAndBacktrackingKind;

import java.util.*;

/**
 * @program: LevelOrder
 * @description: 从上到下打印二叉树
 * @author: liyifan
 * @create: 2021/08/15/13:33
 */
public class LevelOrder {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
/**
 * @question: 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 * [3,9,20,15,7]
 * @思路: 使用队列 放入node 每弹出一个node，就要将这个node的左子树和右子树添加到队列
 */
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        ArrayList<Integer> resArray = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            resArray.add(node.val);
            if(node.left!=null) {
                queue.offer(node.left);
            }
            if(node.right!=null) {
                queue.offer(node.right);
            }
        }
        int[] res=new int[resArray.size()];
        for(int i=0;i<=res.length-1;i++){
            res[i]=resArray.get(i);
        }
        return res;
    }

    /**
     * @question:从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 返回其层次遍历结果：
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     * @思路:和第一种基本类似就是输出不同  每次把一层的值保存 关键在于for(int i=queue.size();i>0;i--) 精髓
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<List<Integer>> resArray = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for(int i=queue.size();i>0;i--){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
            resArray.add(tmp);
        }
        return resArray;
    }
}
