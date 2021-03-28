package com.chao.algorithmdemo;

import android.util.Log;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Date: 2021/3/27 16:02
 * Author: hans yang
 * Description:
 */
class Algorithm2 {

    static final String TAG = "Algorithm2";

    public static void main(String[] args) {
//        test();
    }

     /**
     *  *一个M*N的二维数组，只有行有序，找第K大元素。
     * 不可以用优先级队列！
     * 例如{{3,10,12},{2,4,6},{24,27,29}}, k = 5，第5大的元素为10
     *  */

     public void test(){
         int[][] data = {{3,10,12},{2,4,6},{24,27,29}};
         // 保存不再需要查询的行
         HashMap<Integer, Integer> lineList = new HashMap();
         // 保存遍历到的前几最大数的集合
         List<Integer> maxList = new ArrayList<>();
         // 第k大的元素
         int k = 2;
         int p = data.length;
         int p2 = p > 0 ? data[0].length : 0;
         if (k > p * p2){
             // 越界了
             return;
         }
         for (int i = p2 - 1; i > -1; i--) {
             if (lineList.size() >= p){
                 Log.d(TAG, "test: break i = " + i);
                 break;
             }
             for (int j = 0; j < p; j++) {
                 if (lineList.containsKey(j)){
                     continue;
                 }
                 int a = data[j][i];
                 if (maxList.size() < k){
                     maxList.add(a);
                     if (maxList.size() == k){
                         sortList(maxList);
                     }
                 }else {
                     if (a > maxList.get(k - 1)){
                         maxList.remove(k-1);
                         maxList.add(a);
                         sortList(maxList);
                     }else {
                         lineList.put(j, j);
                         Log.d(TAG, "test: in lineList j = " + j);
                     }
                 }
             }
         }
         Log.d(TAG, String.format("test: 前 %d this value =  %d", k, maxList.get(k - 1)));
     }

    private void sortList(List<Integer> maxList) {
        maxList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }


}
