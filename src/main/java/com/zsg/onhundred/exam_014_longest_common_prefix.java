package com.zsg.onhundred;

import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.zsg.onhundred
 * @Author: yjzsg
 * @CreateTime: 2022/8/2 12:23
 * @Description:
 */
public class exam_014_longest_common_prefix {
    public static void main(String[] args) {
//        String[] source = {"flower", "flow", "flight"};
//        String[] source = {"dog","racecar","car"};
//        String[] source = {"ab", "a"};
        String[] source = {"a", "b"};
        String result = longestCommonPrefix(source);
        System.out.println(result);
    }

    /**
     * TODO: 1. 横向扫描 - 复杂度分析
     * time:O(mn) 其中m是字符串数组中的字符串的平均长度，n是字符串的数量。最坏情况下，字符串数组中每个字符串的每个字符都会被比较依次
     * space:O(1) 我们只需要使用常熟级别的额外空间
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        // MyResolve
        // 1. 比较相邻元素的最长子串，选择最小的保存下来
        // 2. 依次比较每个元素，
        //     如果是len == 0直接退出
        //     如果比较到最后一位，则返回子串
        String prefix = strs[0];
        for (String s : Arrays.copyOfRange(strs, 1, strs.length)) {
            if (s.length() < prefix.length()) {
                String temp = prefix;
                prefix = s;
                s = temp;
            }
            if("".equals(prefix)){
                return "";
            }
            for (int i = 1; i <= prefix.length(); i++) {
                if (!s.startsWith(prefix.substring(0, i))) {
                    prefix = s.substring(0, i - 1);
                    break;
                }
            }
            if ("".equals(prefix)) {
                break;
            }
        }
        return prefix;
    }
}
