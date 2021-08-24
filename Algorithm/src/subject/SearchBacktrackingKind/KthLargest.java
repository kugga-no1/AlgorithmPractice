package subject.SearchBacktrackingKind;

/**
 * @program: KthLargest
 * @description: 剑指 Offer 54. 二叉搜索树的第k大节点
 * @author: liyifan
 * @create: 2021/08/24/10:07
 */

/**
 * @Description:给定一棵二叉搜索树，请找出其中第k大的节点。
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * @return:
 */
public class KthLargest {

    /**
     * @Description: 中序倒序遍历
     * @return:
     */
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
}
