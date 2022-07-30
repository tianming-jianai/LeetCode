package com.zsg.onhundred;

import static java.lang.Integer.reverse;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.zsg.onhundred
 * @Author: 张世罡
 * @CreateTime: 2022-07-30 23:40
 * @Description: 007 reverse integer
 */
public class exam_007_reverse_integer {
    public static void main(String[] args) {
        System.out.println("MIN：" + Integer.MIN_VALUE);
        System.out.println("MAX：" + Integer.MAX_VALUE);
//        int target = 12;
        int target = 128;
//        int target = Integer.MAX_VALUE;
        int result = reverse2(target);
        System.out.println(result);
        System.out.println(821 == result);
        // 数据溢出的解决办法。
        // 我们已经知道，在整型中，能够保存的数值范围最大的是long型；在浮点型中，能够保存的数值范围最大的是double型。
        // 所以在遇到数据溢出问题时，我们可以先把能够保存的数值范围少的类型转换为多的类型，再进行运算。
    }

    private static int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                throw new RuntimeException("数字溢出异常");
            }
        }
        return (int) res;
    }
}
