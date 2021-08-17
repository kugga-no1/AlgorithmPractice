package subject.DynamicProgramming;

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
}
