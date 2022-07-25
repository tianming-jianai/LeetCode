package com.zsg.base;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.zsg.base
 * @Author: 张世罡
 * @CreateTime: 2022-07-24 23:41
 * @Description: 插入排序
 * 文字描述：1. 将数组分为两个区域，排序区和未排序区，每一轮从未排序区中取出第一个元素，插入到排序区域（需保证顺序）
 * 2. 重复以上步骤，直到整个数组有序
 * 优化方式：
 * 1. 待插入元素进行比较时，遇到比自己小的元素，就代表找到了插入位置，无需进行后续比较
 * 2. 插入时直接移动元素，而不是交换元素
 * 与选择排序比较：
 * 1. 二者平均时间复杂度都是O(n²)
 * 2. 大部分情况下，插入都优于选择
 * 3. 有序集合插入的时间复杂度为O(n)
 * 4. 插入属于稳定排序算法，而选择属于不稳定排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {9, 3, 7, 2, 5, 8, 1, 4};
        insert(a);
        System.out.println(Arrays.toString(a));
    }

    private static void insert(int[] a) {
        // i 代表待插入元素的索引
        for (int i = 1; i < a.length; i++) {
            int t = a[i]; // 代表待插入的元素值
            int j = i - 1; // 代表已排序区的元素索引
            while (j >= 0) {
                if (t < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;// 退出循环
                }
                j--;
            }
            a[j + 1] = t;
            System.out.println(Arrays.toString(a));
        }
    }
}
