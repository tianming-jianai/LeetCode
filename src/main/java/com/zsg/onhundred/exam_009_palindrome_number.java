package com.zsg.onhundred;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.zsg.onhundred
 * @Author: yjzsg
 * @CreateTime: 2022/7/31 14:09
 * @Description: 009 palindrome number
 */
public class exam_009_palindrome_number {
    public static void main(String[] args) {
//        assert true == isPalindrome(-1) : "-1 不是回文";
//        assert true == isPalindrome(0) : "0 不是回文";
//        assert true == isPalindrome(1) : "1 不是回文";
//        assert true == isPalindrome(12) : "12 不是回文";
//        assert true == isPalindrome(121) : "121 不是回文";
        assert true == isPalindrome(120) : "120 不是回文";
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }
        int palind = 0;
        int temp = x;
        while (x != 0) {
            palind = palind * 10 + x % 10;
            x = x / 10;
        }
        // 回文数字与其本身相等
        if (palind == temp) {
            return true;
        } else {
            return false;
        }
    }
}
