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
        // 有序数组
        int[] b = {1, 2, 3, 4, 5, 7, 8, 9};
        bubble(b);
    }

    private static void bubble(int[] a) {
        for (int j = 0; j < a.length - 1; j++) {
            // 一轮冒泡
            // 减少内层循环次数
            // 当不再交换时，意味着数组已经有序了
            boolean swapped = false;
            for (int i = 0; i < a.length - 1 - j; i++) {
                System.out.println("比较次数" + i);
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }
            System.out.println(String.format("第%d轮冒泡：%s", j, Arrays.toString(a)));
            if (!swapped) {
                break;
            }
        }

    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
