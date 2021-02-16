package hhuc.cenhelm;

/**
 * 15 三数之和 中等题
 * 我自己思路：先从小到大排序，先定下第一个数，剩下的数设一个first一个end，加起来过大就end--,过小就first++
 * 遇到问题：超出时间限制
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;//只能对list排序
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++){
            int solid = nums[i];//固定一个数
            int first = i+1;
            int end = nums.length-1;
            while (first < end){
                if (nums[first] + nums[end] == -solid){
                    List<Integer> list = new ArrayList<>();
                    list.add(solid);
                    list.add(nums[first]);
                    list.add(nums[end]);
                    lists.add(list);
                }else if (nums[first] + nums[end] > -solid){
                    --end;
                }else ++first;
            }
        }
        return lists;
    }
}
