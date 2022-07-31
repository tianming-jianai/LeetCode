package com.zsg.onhundred;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.zsg.onhundred
 * @Author: yjzsg
 * @CreateTime: 2022/7/24 12:00
 * @Description: 004 media of two sorted arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log(m+n))
 * Example1: nums1 = {1,3} nums2 = {2} median = 2.0
 * Example2: nums1 = {1,3} nums2 = {2,4} median = 2.5
 */
class exam_004_mediansortedtwoarrays {
    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2, 4};
        double res = findMedianSortedArrays2(a, b);
        System.out.println("Median：" + res);
    }

    /**
     * TODO 1. 利用归并思想直接找到中位数，没有合并两个数组
     * time:O((m+n)/2)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        double left = 0, right = 0;//保存这两个正序数组的中间两个数 
        int point1 = 0, point2 = 0;
        //只需遍历 len/2+1 次
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (point1 < nums1.length && (point2 >= nums2.length || nums1[point1] < nums2[point2])) {
                right = nums1[point1++];
            } else {
                right = nums2[point2++];
            }
        }
        if (len % 2 == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }


    /**
     * 二分查找
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = nums1.length + nums2.length;
        double median = 0.0;
        if (len % 2 == 0) {
            int indexLeft = len / 2 - 1, indexRight = len / 2;//中间两个数的下标
            median = (getKthNum(nums1, nums2, indexLeft + 1) + getKthNum(nums1, nums2, indexRight + 1)) / 2.0;
        } else {
            int index = len / 2;//中间一个数的下标
            median = getKthNum(nums1, nums2, index + 1);
        }
        return median;
    }

    //求第k小数
    public static int getKthNum(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int left1 = 0, left2 = 0;//数组nums1,nums2的左边界
        while (true) {
            //只有数组nums2有元素
            if (left1 == len1)
                return nums2[left2 + k - 1];
            //只有数组nums2有元素
            if (left2 == len2)
                return nums1[left1 + k - 1];
            //找到第k小数
            if (k == 1)
                return Math.min(nums1[left1], nums2[left2]);
            //数组nums1和nums2均有元素
            int mid = k / 2;
            int newLeft1 = Math.min(left1 + mid, len1) - 1;//数组nums1的新左边界，其中min()保证不越界
            int newLeft2 = Math.min(left2 + mid, len2) - 1;//数组nums2的新左边界，其中min()保证不越界
            if (nums1[newLeft1] <= nums2[newLeft2]) {
                k -= (newLeft1 - left1 + 1);//根据边界之差来确定排除元素的个数
                left1 = newLeft1 + 1;
            } else {
                k -= (newLeft2 - left2 + 1);//根据边界之差来确定排除元素的个数
                left2 = newLeft2 + 1;
            }
            //k -= mid;//更新k值（有问题：mid可能大于数组中的剩余元素个数）
        }
    }
}