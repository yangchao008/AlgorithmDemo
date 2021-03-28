package com.chao.algorithmdemo;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/3/28 10:03
 * Author: hans yang
 * Description: 排序算法
 */
public class DataSort {

    final String TAG = "DataSort";
    Integer[] data = {8, 47 , 58 ,5 ,6 ,9 ,25 ,14 ,35 ,25, 32 ,7 ,47 ,9 ,58 ,56 ,42 ,4, 58 , 98, 100};

    /**
    快速排序
    快速排序用一种分而治之的思想，
    快速排序的步骤：
            (1) 选择基准值。
            (2) 将数组分成两个子数组：小于基准值的元素和大于基准值的元素。
            (3) 对这两个子数组进行快速排序。
    快速排序的例子(采用了递归的思想)：
    算法简单描述：选择数组第一位元素位基准值，创建两个新数组，分别存放小于基准值和大于基准值的元素。然后这两个新数组递归进行上述操作，直到数组为空。然后将左右数组和基准值进行拼接
    */
    public void quickSort(){
        Integer[] sort = _quickSort(data);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sort.length; i++) {
            builder.append(sort[i]).append(", ");
        }
        Log.d(TAG, "quickSort: " + builder.toString());
    }

    private Integer[] _quickSort(Integer[] a){
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





}
