package hhuc.cenhelm;

/**
 * 42 接雨水 困难题
 * 思路：递归 先找到最大的，然后找到左边的最大后边的最大，递归下去
 */

public class Solution42 {
    public static void main(String[] args) {
        int[] height = new int[]{0,2,0};
        int a = new Solution42().trap(height);
    }

    public int trap(int[] height) {
        int[] flag = new int[height.length];//标记最大值的位置，初始全0
        findMax(0, height.length, height, flag);
        int sum = 0;

        int max = 0, max_index = 0;
        for (int i = 0; i < height.length; i++) {
            if (flag[i] == 1) {
                if (max <= height[i]) sum = sum + max * (i - max_index - 1);
                else sum = sum + height[i] * (i - max_index - 1);
                for (int j = max_index + 1; j < i; j++) {
                    sum = sum - height[j];
                }
                max = height[i];
                max_index = i;
            }
        }

        return sum;
    }

    public void findMax(int first, int end, int[] height, int[] flag) {
        int max = 0;
        int max_index = 0;
        if (first == end) return;
        for (int i = first; i < end; i++) {
            if (height[i] >= max) {
                max = height[i];
                max_index = i;
            }
        }
        flag[max_index] = 1;
        if (first == 0) findMax(0, max_index, height, flag);
        if (end == height.length) findMax(max_index + 1, end, height, flag);
    }
}
