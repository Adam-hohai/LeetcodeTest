package hhuc.cenhelm;

/**
 * 34 在排序数组中查找元素的第一个和最后一个位置 中等题
 * 思路：二分法，二分后左边尽量往左找，右边尽量往右找
 */

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = binarySearch(nums, target, true);
        arr[1] = binarySearch(nums, target, false);
        return arr;
    }

    /**
     * 二分
     * @param nums 已知数组
     * @param target 要搜索的数
     * @param left_or_right 找第一个时为true， 找最后一个时为false
     * @return 数的下标
     */
    public int binarySearch(int[] nums, int target, boolean left_or_right){
        int res = -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = (left + right)/2;
            if (target > nums[mid]) left = mid + 1;
            else if (target < nums[mid]) right = mid - 1;
            else {
                res = mid;
                if (left_or_right) right = mid - 1;
                else left = mid + 1;
            }
        }
        return res;
    }
}
