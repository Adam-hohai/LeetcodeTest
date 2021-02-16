package hhuc.cenhelm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 14 最长公共前缀 简单题
 * String数组转化为字符串用StringBuilder类
 */

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int min = strs[0].length();//数组里字符串的最小长度

        for (String s : strs) {
            min = Math.min(min, s.length());
        }
        String[] str2 = new String[min];
        L:
        for (int i = 0; i < min; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) break L;
            }
            str2[i] = String.valueOf(c);
        }
        StringBuilder str3 = new StringBuilder();
        for (String s : str2) {
            if (s != null) str3.append(s);
        }

        return str3.toString();
    }
}
