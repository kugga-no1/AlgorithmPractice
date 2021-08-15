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
/**
 * @question:请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @思路:和之前大体类似，只是要正序一遍逆序一遍打印而已，方法有很多：1。遍历时加个奇偶层判断  2.按之前一样打印 打印完后再对结果做处理（这里写的就是这种）
 */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(res.size() % 2 == 1) Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
    }

}
