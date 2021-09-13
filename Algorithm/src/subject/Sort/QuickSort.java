package subject.Sort;

/**
 * @author ：kugga-no1
 * @date ：Created in 2021/9/13 11:44
 * @description：快排
 */
public class QuickSort {
//    public static int[] getARrr(int[] arr){
//        quickSort(arr,0,arr.length-1);
//        return arr;
//    }
//
//    private static void quickSort(int[] arr, int left, int right) {
//        if(right<=left){
//            return ;
//        }
//        int i=left;
//        int j=right;
//        while(i<j){
//            while(i<j&&arr[j]>=arr[left]){
//                j--;
//            }
//            while(i<j&&arr[i]<=arr[left]){
//                i++;
//            }
//            swap(arr,i,j);
//        }
//        swap(arr,left,i);
//        quickSort(arr,left,i-1);
//        quickSort(arr,i+1,right);
//    }


    public static int[] getARrr(int[] arr){
        quicksort(arr,0,arr.length-1);
        return arr;
    }

    private static void quicksort(int[] arr, int left, int right) {
        if(right<=left){
            return ;
        }
        int i=left;
        int j=right;
        while(i<j){
            while(i<j&&arr[j]>=arr[left]){
                j--;
            }
            while(i<j&&arr[i]<=arr[left]){
                i++;
            }
            swap(arr,i,j);
        }
        swap(arr,left,i);
        quicksort(arr,left,i-1);
        quicksort(arr,i+1,right);
    }

    private static  void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int arr[]=new int[]{3,1,3,6,8,9,2};
        arr=getARrr(arr);
        for(int i:arr){
            System.out.println(i);
        }
    }
}
