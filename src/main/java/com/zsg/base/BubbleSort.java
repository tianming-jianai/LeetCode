package com.zsg.base;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.zsg.base
 * @Author: 张世罡
 * @CreateTime: 2022-07-24 22:22
 * @Description: 冒泡排序
 * 文字描述：1. 依次比较数组中相邻两个元素大小，若a[i]>a[i+1]，则交换两个元素，
 * 两两都比较一遍称为一轮冒泡，结果是让最大的元素排至最后
 * 2. 重复以上步骤，知道整个数组有序
 * 3. 优化方式：每轮冒泡是，最后一次交换索引可以作为下一轮冒泡的比较次数，
 * 如果这个值为0，表示整个数组有序，直接退出外层循环即可
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {5, 9, 7, 4, 1, 3, 2, 8};
        // 有序数组
        int[] b = {1, 2, 3, 4, 5, 7, 8, 9};
//        bubble(b);
        bubble_v2(b);
    }

    private static void bubble_v2(int[] a) {
        // 需要比较的次数
        int n = a.length - 1;
        while (true) {
            int last = 0;
            for (int i = 0; i < n; i++) {
                System.out.println("比较次数" + i);
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    last = i;
                }
            }
            System.out.println(String.format("第轮冒泡：%s", Arrays.toString(a)));
            n = last;
            if (n == 0) {
                break;
            }
        }
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
