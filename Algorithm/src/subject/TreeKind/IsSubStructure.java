package subject.TreeKind;

/**
 * @program: IsSubStructure
 * @description: 输入两棵二叉树A和B，判断B是不是A的子结构
 * @author: liyifan
 * @create: 2021/08/16/9:47
 */

/**
 * @question: 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * @return:
 */
public class IsSubStructure {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
    if (A==null||B==null){
        return false;
    }
    else{
        return dfs(A,B);
    }
    }

    /**
     * 不断遍历树的每一个节点
     */
    public boolean dfs(TreeNode A,TreeNode B){
          //A遍历完了还没找到
          if(A==null){
              return false;
          }
          if(A.val==B.val&&contain(A,B)){
              return true;
          }
          else{
              return dfs(A.left,B)||dfs(A.right,B);
          }
    }

    public boolean contain(TreeNode A,TreeNode B){
        //B遍历完了 全相等
        if(B==null){
            return true;
        }
        if(A==null||A.val!=B.val){
            return false;
        }
        return contain(A.left,B.left)&&contain(A.right,B.right);
    }

}
