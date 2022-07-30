package com.zsg.onhundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.zsg.onhundred
 * @Author: 张世罡
 * @CreateTime: 2022-07-30 22:58
 * @Description: 006 zigzag conversion
 */
public class exam_006_zigzag_conversion {
    public static void main(String[] args) {
        String source = "PAYPALISHIRING";
        String target = convert(source, 4);
        System.out.println(target);
        System.out.println("PAHNAPLSIIGYIR".equals(target));// 3
        System.out.println("PAYPALISHIRING".equals(target));// 4
    }

    public static String convert(String s, int rows) {
        if (s == null || s.length() == 0 || rows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            list.add(new StringBuilder());
        }
        boolean down = true;// true下 false 上
        int currRow = 1;
        for (int i = 0; i < s.length(); i++) {
            // 赋值
            list.get(currRow - 1).append(s.charAt(i));
            // 行号变化
            currRow = down ? currRow++ : currRow--;
            // 方向变化
            if (currRow == rows || currRow == 1) {
                down = !down;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : list) {
            result.append(builder);
        }
        return result.toString();
    }
}
