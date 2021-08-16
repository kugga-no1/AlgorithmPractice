package subject.TreeKind;

/**
 * @program: IsSymmetric
 * @description: 对称二叉树
 * @author: liyifan
 * @create: 2021/08/16/11:01
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * @question: 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * @return:
 */
public class IsSymmetric {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static boolean isSymmetric1(TreeNode root) {
        if(root==null){
            return true;
        }
        int nullnumber=(int)(Math.random()*10000000);
        Deque<TreeNode> deque=new LinkedList<TreeNode>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            //用于检测一层是否镜像
            Deque<Integer> testDeque=new LinkedList<Integer>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                } else if(node.left==null&&node.right!=null) {
                    deque.offer(new TreeNode(nullnumber));
                }
                if (node.right != null) {
                    deque.offer(node.right);
                } else if(node.right==null&&node.left!=null) {
                    deque.offer(new TreeNode(nullnumber));
                }
                testDeque.offer(node.val);
            }
            while (!testDeque.isEmpty()&&testDeque.size()%2==0) {
                //从双端队列两头取数值，如果不相等则不是镜像
                if (!testDeque.pollFirst().equals(testDeque.pollLast())) {
                    return false;
                }
            }
        }
        return true;
    }
/**
 * 若一个树对称，则他的每对对称节点满足 1.val相等 2.a。left=b。right  3.a。right=b.left
 */
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if(L == null || R == null || L.val != R.val) {
            return false;
        }
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = null;
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = null;
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        treeNode2.left=treeNode5;
        treeNode2.right=treeNode6;
    }
}
