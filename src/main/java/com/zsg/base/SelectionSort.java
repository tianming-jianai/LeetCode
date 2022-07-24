package com.zsg.base;

import java.util.Arrays;

import static com.zsg.base.BubbleSort.swap;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.zsg.base
 * @Author: 张世罡
 * @CreateTime: 2022-07-24 23:19
 * @Description: 选择排序
 * 文字描述：1. 将数组分为2个子集，排序和未排序的，每一轮从未排序的子集中选出最小的元素，放入排序子集
 * 2. 重复以上步骤，直到整个数组有序
 *
 * 与冒泡排序相比：
 * 1. 二者平均时间复杂度都是O(n²)
 * 2. 选择排序一般要快于冒泡，因为其交换次数少
 * 3. 如果集合有序度高，冒泡优于选择
 * 4. 冒泡属于稳定排序，二选择属于不稳定排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {5, 3, 7, 2, 1, 9, 8, 4};
        selection(a);
    }

    private static void selection(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            // i 代表每轮选择最小元素要交换的目标索引
            int s = i;// 代表最小的元素索引
            for (int j = s + 1; j < a.length; j++) {
                if (a[s] > a[j]) {
                    s = j;
                }
            }
            if (i != s) {
                swap(a, i, s);
            }
            System.out.println(Arrays.toString(a));
        }
    }

}
