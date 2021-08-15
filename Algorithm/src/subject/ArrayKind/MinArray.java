package subject.ArrayKind;

/**
 * @program: MinArray
 * @description: 旋转数组的最小数
 * @author: liyifan
 * @create: 2021/08/14/20:46
 */
public class MinArray {
    /**
    question:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。

     示例 1：
     输入：[3,4,5,1,2]
     输出：1

     示例 2：
     输入：[2,2,2,0,1]
     输出：0

     思路：特殊（有递增）用二分查找：
     必须让temp和R比较而不是和L比较，因为如果和L比较的话，比如[1,2,3,4,5] 和 [2,3,4,5,1]结果就不同。只有用temp和R比才能确定temp在左序列还是右序列

     numbers[temp]>numbers[j] 旋转点x在temp右边
     numbers[temp]<numbers[j] 旋转点x在temp左边
     numbers[temp]==numbers[j] 执行j-- 安全缩小范围
     原因： 若temp<j  易证安全，m还在[i,j]内

     若temp=j
     1.numbers[temp]=numbers[x]=numbers[j]<=numbers[i]   (既然numbers[j]是旋转点，那他肯定是最小的，<=numbers[i])
     2.既然numbers[j]是旋转点，那么j之前肯定是递增，即temp和i在一个递增序列中，那么numbers[x]=numbers[j]=numbers[temp]>=numbers[i]
     3. 1和2 得到：numbers[x]=numbers[j]=numbers[temp]=numbers[i] 要符合的话，[i,temp]全相等或者[temp+1，j]全相等，或者[i,j全部都相等] 此时可以放弃二分查找，直接线性查找最小的元素

     */
    public static int minArray(int[] numbers) {
    if(numbers.length<=0){
        return 0;
    }
    else if(numbers.length==0){
        return numbers[0];
    }
    int L=0,R=numbers.length-1;
    while (L<R){
        int temp=(L+R)/2;
            if (numbers[temp]>numbers[R]){
                L=temp+1;
            }
            else if(numbers[temp]<numbers[R]){
                R=temp;
            }
            else if(numbers[temp]==numbers[L]){
                int x = L;
                for(int k = L + 1; k < R; k++) {
                    if(numbers[k] < numbers[x]) x = k;
                }
                return numbers[x];
            }
    }
    return numbers[L];
    }
/**
测试用例
 */
    public static void main(String[] args) {
        int[] ints = {3,1,1};
        System.out.println(minArray(ints));
    }
}
