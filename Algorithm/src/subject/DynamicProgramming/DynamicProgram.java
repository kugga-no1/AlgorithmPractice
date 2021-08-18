package subject.DynamicProgramming;

import java.util.Arrays;

/**
 * @program: DynamicProgram
 * @description: 动态规划类
 * @author: liyifan
 * @create: 2021/08/17/8:54
 */
public class DynamicProgram {
    /**
     * 斐波那契数列
     */
    public int fib(int n) {
        int a=0,b=1;
        if(n==0||n==1){
            return n;
        }
        int tmp=a+b;
        for(int i=2;i<=n;i++){
            tmp=(a+b)%1000000007;
            a=b;
            b=tmp;
        }
        return tmp;
    }
/**
 * 青蛙跳台阶
 */
    public int numWays(int n) {
        int a=1,b=1;
        int sum=a+b;
        if(n==0||n==1) {
            return 1;
        }
        for(int i=2;i<n;i++){
            a=b;
            b=sum;
            sum=(a+b) % 1000000007;
        }
        return sum;
    }
/**
 * 股票最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * 示例 2
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
    public int maxProfit(int[] prices) {
    int minprice=Integer.MAX_VALUE;
    int maxprofit=0;
    for(int price:prices){
        //到当日为止的价格最小值
        minprice=Math.min(minprice,price);
        maxprofit=Math.max(maxprofit,price-minprice);
    }
    return maxprofit;
    }

    /**
     * @quetion:
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * 要求时间复杂度为O(n)。
     * 示例1:
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    /**
     * 动态规划 dp[i]表示以第i个元素结尾的最大子数组之和
     */
    public static int maxSubArray0(int[] nums) {
    int[] dp=new int[nums.length];
    dp[0]=nums[0];
    for(int i=1;i<=nums.length-1;i++){
        dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
    }
    Arrays.sort(dp);
    return dp[dp.length-1];
    }
/**
 * 动态规划优化 遍历nums dp存储以第i个元素为结尾的最大子数组之和，maxnum维护dp出现过的最大值
 */
    public static int maxSubArray1(int[] nums) {
        int maxnum=nums[0];
        int dp=nums[0];
        for(int i=1;i<=nums.length-1;i++){
            dp=Math.max(dp+nums[i],nums[i]);
            maxnum=dp>maxnum?dp:maxnum;
        }
        return maxnum;
    }
/**
 * @question:在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 示例 1:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 */
/**
 * @思路:dp[i][j]表示从grid[0][0]到grid[i][j]的最大礼物值
 * 数组从左到右一排一排遍历，要到达grid[i][j] 则要么从grid[i-1][j] 要么从grid[i][j-1]走一步到达
 * 所以 dp[i][j]=max{dp[i-1][j],dp[i][j-1]}+grid[i][j]
 */
    public static int maxValue(int[][] grid) {
    int[][] dp=new int[grid.length][grid[0].length];
    dp[0][0]=grid[0][0];
    for(int i=0;i<= grid.length-1;i++){
        for (int j=0;j<=grid[0].length-1;j++){
            dp[i][j]=Math.max(i-1>=0?dp[i-1][j]:0,j-1>=0?dp[i][j-1]:0)+grid[i][j];
            System.out.println(dp[i][j]);
        }
    }
    return dp[grid.length-1][grid[0].length-1];
}
/**
 * @Description: 最多礼物问题空间复杂度优化  直接原地修改grid数组 不需要额外dp
 */
    public static int maxValue2(int[][] grid) {
        for(int i=0;i<= grid.length-1;i++){
            for (int j=0;j<=grid[0].length-1;j++){
                grid[i][j]=Math.max(i-1>=0?grid[i-1][j]:0,j-1>=0?grid[i][j-1]:0)+grid[i][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
    int[][] grid=new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(maxValue2(grid));
    }
}
