package hhuc.cenhelm;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        // 记录某一个字符上一次出现的位置
        int[] last = new int[128];//ASCII码一共从0-127
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);//将i处字符转化从ASCII码作为索引
            start = Math.max(start, last[index] + 1);//每当出现此前出现过的字符，窗口位置加一，否则不变
            res   = Math.max(res, i - start + 1);//始终为最长的不重复字符串的长度
            last[index] = i;//将此字符此次出现的位置保存，用作下次再次出现此字符时可以窗口加一
        }

        return res;
    }
}

/**
 * 0 1 2 3 4 5
 * a b c d a b
 *
 * start 0 0 0 0 1 2
 * res   1 2 3 4 4 4
 */
