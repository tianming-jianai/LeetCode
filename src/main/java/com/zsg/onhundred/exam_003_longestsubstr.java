package com.zsg.onhundred;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.zsg.onhundred
 * @Author: 张世罡
 * @CreateTime: 2022-07-24 09:42
 * @Description: 003 longest substring without repeating character
 */
public class exam_003_longestsubstr {

    public static void main(String[] args) {
        int res1 = lengthOfLongestSubstring("abcabcbb");
        System.out.println("结果1：" + res1);
        int res2 = lengthOfLongestSubstring("abbc");
        System.out.println("结果2：" + res2);
        int res3 = lengthOfLongestSubstring("abcdefcgh");
        System.out.println("结果3：" + res3);

    }

    /**
     * Examples:
     * 'abcabcbb' -> 'abc' -> 3
     * 'bbbbb' -> 'b' -> 1
     * 'pwwkew' -> 'wke' -> 3
     * time:O(n)
     * space:O(n)
     * 经典不衰
     *
     * @param s 字符串
     * @return 最长不重复子串个数
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)) + 1, j);
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}
