package subject;

/**
 * @program: FindNumberIn2DArray
 * @description: 二维数组中的查找
 * @author: liyifan
 * @create: 2021/08/14/15:54
 */
public class FindNumberIn2DArray {
    /**
     从左下角或者从右上角看很像一颗二叉平衡树，直接从左下角或者右上角开始遍历即可
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
    int j=matrix.length-1;
    int k=0;
    while(k<=matrix[0].length-1&&j>=0){
         if(matrix[j][k]==target){
            return true;
        }
        else if(target<matrix[j][k]){
            j--;
        }
        else if(target>matrix[j][k]){
            k++;
        }
    }
    return false;
    }
/**
测试用例
 */
    public static void main(String[] args) {
        int[][] matrix={{1,4,7,11,15}
                       ,{2,5,8,12,19}
                       ,{3,6,9,16,22}
                       ,{10,13,14,17,24}
                       ,{18,21,23,26,30}};
        System.out.println(findNumberIn2DArray(matrix,16));
    }
}
