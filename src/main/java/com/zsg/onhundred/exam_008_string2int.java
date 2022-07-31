package com.zsg.onhundred;

import static java.lang.Character.isDigit;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.zsg.onhundred
 * @Author: 张世罡
 * @CreateTime: 2022-07-31 00:08
 * @Description: 008 string to integer
 * input: '42'  '   -42' '4193 with words' 'words and 987'
 * output: 42   -42      4193              0
 * input: '-91283472332'
 * output: -2147483648 数字超出32位有符号整数范围，因此返回INT_MIN(-2^31)
 * 溢出可能的操作：乘法、加法
 * time:O(n)
 * space:O(1)
 * <p>
 * 下面这个视频思路清晰，代码优雅
 * https://www.bilibili.com/video/BV1mE411Z7jh
 */
public class exam_008_string2int {

    public static void main(String[] args) {
        // 测试用例
        // 1. 正数的情况：正常、溢出
        assert 42 == atoi("42") : "正数正常";
        assert Integer.MAX_VALUE == atoi("91283472332") : "正数溢出";
        // 2. 负数的情况：正常、溢出
        assert -42 == atoi("-42") : "负数正常";
        assert Integer.MIN_VALUE == atoi("-91283472332") : "负数溢出";
        // 3. 有其它字符的情况
        assert 42 == atoi("  42") : "前面空格";
        assert 4193 == atoi("4193 with words") : "其它字符在后";
        assert 0 == atoi("words and 987") : "其它字符在前";
        System.out.println("运行成功");
    }

    private static int atoi(String s) {
        if (s == null || (s = s.strip()).length() == 0) {
            return 0;
        }
        int result = 0;
        int sign = 1;
        int index = 0;
        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }
        long num = 0;
        for (; index < s.length(); index++) {
            if (s.charAt(index) < '0' || s.charAt(index) > '9') {
                break;
            }
            num = num * 10 + (s.charAt(index)) - '0';
            if (num > Integer.MAX_VALUE) {
                break;
            }
        }
        if (num * sign > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (num * sign < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return sign * (int) num;
        }
    }

}
