package hhuc.cenhelm;

/**
 * 26 删除排序数组中的重复项 简单题
 */

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int j = 0;//记录出现重复数字的个数
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) ++j;
            else {
                nums[i - j + 1] = nums[i + 1];
            }
        }
        return nums.length - j;
    }
}
