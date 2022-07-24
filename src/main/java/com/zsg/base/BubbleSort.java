package com.zsg.base;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.zsg.base
 * @Author: 张世罡
 * @CreateTime: 2022-07-24 22:22
 * @Description: 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {5, 9, 7, 4, 1, 3, 2, 8};
        bubble(a);
    }

    private static void bubble(int[] a) {
        for (int j = 0; j < a.length - 1; j++) {
            // 一轮冒泡
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                }
            }
            System.out.println(String.format("第%d轮冒泡：%s", j, Arrays.toString(a)));
        }

    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
