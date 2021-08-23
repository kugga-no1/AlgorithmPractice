package subject.SearchBacktrackingKind;

/**
 * @program: Exist
 * @description: 搜索矩阵中是否存在路径
 * @author: liyifan
 * @create: 2021/08/23/9:39
 */
/**
 * @question:给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * @思路:剪枝dfs+回溯
 */
public class Exist {
    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i=0;i<=board.length-1;i++){
            for(int j=0;j<=board[0].length-1;j++){
                if(dfs(board,words,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board,char[] words,int i,int j,int k){
        if(i>=board.length||i<0||j>=board[0].length||j<0||board[i][j]!=words[k]){
            return false;
        }
        if(k==words.length-1){
            return true;
        }
        board[i][j]='*';
        boolean res=dfs(board,words,i-1,j,k+1)||
                dfs(board,words,i+1,j,k+1)||
                dfs(board,words,i,j-1,k+1)||
                dfs(board,words,i,j+1,k+1);
        board[i][j]=words[k];
        return res;
    }

    public static void main(String[] args) {
        char[][] board=new char[][]{{'a','b'}};
        exist(board,"ba");
    }
}
