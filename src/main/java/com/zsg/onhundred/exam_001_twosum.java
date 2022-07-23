package com.zsg.onhundred;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.zsg.onhundred
 * @Author: 张世罡
 * @CreateTime: 2022-07-23 23:18
 * @Description:
 * two sum with duplicate number
 */
public class exam_001_twosum {
    public static void main(String[] args) {
        int[] source = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(source, target);
        boolean equals = Arrays.equals(result, new int[]{0, 1});
        System.out.println("两数相加等于目标数:" + equals);
    }

    /**
     * time:O(n)
     * space:O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length < 2) {
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                result[0] = map.get(diff);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}

/*
Follow up 众多
1. two sum with duplicate number
2. 返回有多少种组合满足要求，输出全部内容

LeetCode 前400题相似题目
类别：sum
167 two sum II - input array is sorted
15 3sum
16 3sum closest
159 3sum smaller
18 4sum
 */
