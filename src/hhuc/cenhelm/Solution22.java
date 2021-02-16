package hhuc.cenhelm;

import java.util.ArrayList;
import java.util.List;

/**
 * 22 括号生成 中等题
 * 思路：递归，只要保证"("的个数始终大于"）"
 */

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, "", 0, 0, n);
        return list;
    }

    public void generate(List<String> list, String ans, int count1, int count2, int n){
        if (count1 > n || count2 > n) return;
        if (count1 == n && count2 == n) list.add(ans);
        if (count1 > count2) {
            generate(list, ans + "(", count1+1, count2, n);
            generate(list, ans + ")", count1, count2+1, n);
        }
    }
}
