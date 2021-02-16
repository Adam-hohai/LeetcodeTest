package hhuc.cenhelm;

/**
 * 33 搜索旋转排序数组
 * 思路：主要是二分法，但是选哪一边要看数组第一个数和最后一个数
 */

public class Solution33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        if (nums.length == 1) {
            if (target == nums[0]) return 0;
            else return -1;
        } else {
            if (target < nums[0] && target > nums[nums.length - 1]) return -1;
        }
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else {
                if (nums[left] < nums[right]) {
                    if (target >= nums[left] && target <= nums[right]) {
                        if (target < nums[mid]) right = mid - 1;
                        else left = mid + 1;
                    } else return -1;

                } else {
                    if (target >= nums[left]) right = mid - 1;
                    else if (target <= nums[right]) left = mid + 1;
                }
            }
        }
        if (nums[mid] == target) return mid;
        else return -1;

    }
}
