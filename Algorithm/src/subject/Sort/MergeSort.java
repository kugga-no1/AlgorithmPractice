package subject.Sort;

/**
 * @author ：kugga-no1
 * @date ：Created in 2021/9/12 23:25
 * @description：归并
 */
public class MergeSort {
//    public static int[] MergeSort(int[] arr,int left,int right){
//        if(left<right){
//            int mid=(left+right)/2;
//            arr=MergeSort(arr,left,mid);
//            arr=MergeSort(arr,mid+1,right);
//            Merge(arr,left,mid,right);
//        }
//        return arr;
//    }
//
//    public static int[] MergeSort2(int[] arr){
//        int n=arr.length;
//        for(int i=1;i<n;i+=i){
//            int left=0;
//            int mid=left+i-1;
//            int right=mid+i;
//            while(right<n){
//                Merge(arr,left,mid,right);
//                left=right+1;
//                mid=left+i-1;
//                right=mid+i;
//            }
//            if(left<n&&mid<n){
//                Merge(arr,left,mid,n-1);
//            }
//        }
//        return arr;
//    }
//
//    public static void Merge(int[] arr,int left,int mid,int right){
//        int[] a=new int[right-left+1];
//        int l=left;
//        int r=mid+1;
//        int k=0;
//        while(l<=mid&&r<=right){
//            if(arr[l]<arr[r]){
//                a[k++]=arr[l++];
//            }else{
//                a[k++]=arr[r++];
//            }
//        }
//        while(l<=mid){
//            a[k++]=arr[l++];
//        }
//        while(r<=right){
//            a[k++]=arr[r++];
//        }
//        for(int i=0;i<=k-1;i++){
//            arr[left++]=a[i];
//        }
//    }
    public static int[] MergeSort(int[] arr,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            arr=MergeSort(arr,left,mid);
            arr=MergeSort(arr,mid+1,right);
            Merge(arr,left,mid,right);
        }
        return arr;
    }
    public static int[] MergeSort2(int[] arr){
        int n=arr.length;
        for(int i=1;i<n;i+=i){
            int left=0;
            int mid=left+i-1;
            int right=mid+i;
            while(right<n){
                Merge(arr,left,mid,right);
                left=right+1;
                mid=left+i-1;
                right=mid+i;
            }
            if(left<n&&mid<n){
                Merge(arr,left,mid,n-1);
            }
        }
        return arr;
    }

    public static void Merge(int[] arr,int left,int mid,int right){
        int []a=new int[right-left+1];
        int l=left;
        int r=mid+1;
        int k=0;
        while(l<=mid&&r<=right){
            if(arr[l]<arr[r]){
                a[k++]=arr[l++];
            }else{
                a[k++]=arr[r++];
            }
        }
        while(l<=mid){
            a[k++]=arr[l++];
        }
        while(r<=right){
            a[k++]=arr[r++];
        }
        k=0;
        for(int i=left;i<=right;i++){
            arr[i]=a[k++];
        }
    }



    public static void main(String[] args) {
        int arr[]=new int[]{3,1,3,6,8,9,2};
        arr=MergeSort2(arr);
        for(int i:arr){
            System.out.println(i);
        }
    }
}
