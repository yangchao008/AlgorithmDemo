package com.chao.algorithmdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/3/28 10:03
 * Author: hans yang
 * Description: 排序算法
 */
public class DataSort {

    static final String TAG = "DataSort";
    static Integer[] mData = {8, 47 , 58 ,5 ,6 ,9 ,25 ,14 ,35 ,25, 32 ,7 ,47 ,9 ,58 ,56 ,42 ,4, 58 , 98, 100};

    public static void main(String[] args) {
        quickSort();
        insertSort();
    }
    /**
    快速排序
    快速排序用一种分而治之的思想，
    快速排序的步骤：
            (1) 选择基准值。
            (2) 将数组分成两个子数组：小于基准值的元素和大于基准值的元素。
            (3) 对这两个子数组进行快速排序。
    快速排序的例子(采用了递归的思想)：
    算法简单描述：选择数组第一位元素位基准值，创建两个新数组，分别存放小于基准值和大于基准值的元素。然后这两个新数组递归进行上述操作，直到数组为空。然后将左右数组和基准值进行拼接
     平均时间复杂度：O(NlogN)
     最佳时间复杂度：O(NlogN)
     最差时间复杂度：O(N^2)
     空间复杂度：根据实现方式的不同而不同
    */
    public static void quickSort(){
        Integer[] sort = _quickSort(mData);
        result(sort, "quickSort");

        // 网上拷贝代码
        int[] newArr = new int[mData.length];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = mData[i];
        }
        new quick_sort().sort(newArr);
        result(sort, "网上拷贝代码");
    }

    private static Integer[] _quickSort(Integer[] a){
        if (a.length < 2){
            return a;
        }else {
            int p = a[0];
            List<Integer> less = new ArrayList<>();
            List<Integer> greater = new ArrayList<>();
            for (int i = 1; i < a.length; i++) {
                int d = a[i];
                if (d < p) {
                    less.add(d);
                } else {
                    greater.add(d);
                }
            }
            Integer[] newArray = new Integer[a.length];
            Integer[] lessArray = _quickSort(less.toArray(new Integer[less.size()]));
            System.arraycopy(lessArray, 0, newArray, 0, lessArray.length);

            newArray[lessArray.length] = p;

            Integer[] greaterArray = _quickSort(greater.toArray(new Integer[greater.size()]));
            System.arraycopy(greaterArray, 0, newArray, newArray.length - greaterArray.length, greaterArray.length);

            return newArray;
        }
    }


    /**
     * 插入排序
     * 将数组分为前后两部分，前一部分是已排序的元素集合，后一部分是未排序的元素集合。每次选中未排序的第一个数组，插入到已排序集合中的合适的位置。
     * 工作原理：是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，也就是进行比较，找到相应位置并插入。
     * 插入排序在实现上，在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。和冒泡排序类似
     * 平均时间复杂度：O(N^2)
     * 最差时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 排序方式：In-place
     * 稳定性：稳定
     */
    public static void insertSort(){
        Integer[] arr = new Integer[mData.length];
        System.arraycopy(mData, 0 , arr , 0, mData.length);
        for (int i = 1; i < arr.length; i++) {
            for (int j = i -1; j > -1; j--) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j +1] = temp;
                }
            }
        }
        result(arr, "insertSort");
    }




    private static void result(Integer[] sort, String msg) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sort.length; i++) {
            builder.append(sort[i]).append(", ");
        }
        log( msg + " -->" + builder.toString());
    }

    private static void log(String msg){
        log(TAG, msg);
    }

    private static void log(String tag, String msg){
        if (tag == null || tag.equals("")){
            tag = TAG;
        }
        System.out.println(String.format("%s, %s", tag, msg));
    }

}
