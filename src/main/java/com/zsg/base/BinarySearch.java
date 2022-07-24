package com.zsg.base;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.zsg.base
 * @Author: 张世罡
 * @CreateTime: 2022-07-24 18:45
 * @Description: 二分查找
 * 黑马：https://www.bilibili.com/video/BV15b4y117RJ
 * <p>
 * 目标：
 * - 掌握手写二分查找的代码细节
 * - 快速解答二分查找的选择题
 * <p>
 * 前提：有已排序的数组
 * <p>
 * 面试题：
 * 奇数二分取中间
 * 偶数二分取中间靠左
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 5, 8, 11, 19, 22, 31, 35, 40, 45, 48, 49, 50};
        int target = 48;
        int index = binarySearch(array, target);
        System.out.println(Arrays.toString(array));
        System.out.println(String.format("目标数字%d的下标为：%d", target, index));

        int l = 0;
        int r = Integer.MAX_VALUE - 1;
        // 目标值在中间右边
//        int res = (r/2+r)/2;
        int res = (r / 2 + r) >>> 1;
        System.out.println("res:" + res);
    }

    private static int binarySearch(int[] array, int target) {
        int l = 0, r = array.length, m;
        while (l < r) {
            // 警惕整数溢出
            m = l + (r - l) / 2;
            // 无符号的右移一位
//            m = (l + r) >>> 1;
            if (array[m] == target) {
                return m;
            } else if (array[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
