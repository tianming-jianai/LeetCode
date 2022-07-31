package com.zsg.onhundred;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.zsg.onhundred
 * @Author: yjzsg
 * @CreateTime: 2022/7/31 16:14
 * @Description: 011 container with most water
 * 盛水最多的容器
 * 难度：中等
 * 相关知识点：数组、双指针
 * https://www.bilibili.com/video/BV1TK41157jH
 */
public class exam_011_container_with_most_water {
    public static void main(String[] args) {
        int[] source = {};
        int[] source1 = {0};
        int[] source2 = {1};
        int[] source3 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        assert 49 == maxArea(source3) : "最大盛水面积计算错误";
    }

    /**
     * TODO 2. 双指针法
     * 1）关键字左右两边
     * 2）模式识别：需要移动左右两头的问题可以考虑双指针
     * 3）难点：如何移动指针
     *  - 相同情况下两边距离越远越好
     *  - 区域受限于较短边
     * time:O(n)
     * space:O(1)
     * 面积：木桶原理
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int area = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return area;
    }

    /**
     * TODO 1. 暴力解法
     * 1）遍历左右边
     * 2）找出所有面积
     * 3）取最大
     * time:O(n^2)
     * space:O(1)
     *
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return area;
    }
}
