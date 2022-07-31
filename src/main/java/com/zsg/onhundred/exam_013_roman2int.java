package com.zsg.onhundred;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.zsg.onhundred
 * @Author: yjzsg
 * @CreateTime: 2022/7/31 17:17
 * @Description: 013 roman to integer
 * 罗马数字转整数
 * 难度：简单
 * 相关知识点：数学、字符串
 * <p>
 * 测试：
 * - IV
 * - IX
 * - 测试多位数的情况
 * https://www.bilibili.com/video/BV1TK4y1R7td
 */
public class exam_013_roman2int {
    public static void main(String[] args) {
        System.out.println(romanToInt("III")); // 3
        System.out.println(romanToInt("IV")); // 4
        System.out.println(romanToInt("IX")); // 9
        System.out.println(romanToInt("LVIII")); // 58
        System.out.println(romanToInt("MCMXCIV")); // 1994
    }

    /**
     * time:O(n)
     * space:O(1)
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return getValue(s.charAt(0));
        }
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int a = getValue(s.charAt(i));
            int b = getValue(s.charAt(i + 1));
            result += a < b ? -1 * a : a;
        }
        return result + getValue(s.charAt(s.length() - 1));
    }

    public static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
