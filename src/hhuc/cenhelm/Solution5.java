package hhuc.cenhelm;

/**
 * 最长回文串
 * 这题没解决，存在空指针问题
 */

public class Solution5 {
    int Max = 1;
    String[] maxArr;

    public String longestPalindrome(String s) {
        for (int i = 1; i < s.length() - 1; i++) {
            maxArr = division(s, i);
        }
        StringBuilder maxStr = new StringBuilder();
        for (int i = 0; i < maxArr.length; i++) {
            maxStr.append(maxArr[i]);
        }
        return maxStr.toString();
    }

    //以某个字符为中心，向外扩散
    public String[] division(String s, int mid) {
        String[] arr = s.split("");
        int left = mid - 1;
        int right = mid + 1;
        int max = 1;
        while (left >= 0 && right <= s.length() - 1) {
            if (arr[left] == arr[right]) {
                max += 2;
                left--;
                right++;
            } else break;
        }
        if (max > Max) {
            Max = max;
            int zer = mid - max / 2;
            maxArr = new String[max];
            for (int i = 0; i < max; i++) {
                maxArr[i] = arr[i + zer];

            }
        }
        return maxArr;
    }
}

