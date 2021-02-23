package hhuc.cenhelm;

import java.util.ArrayList;
import java.util.List;

/**
 * 46 全排列 中等题
 * 思路：栈 递归 递归时两个选择：直接入栈 或直接出栈，然而这个思路时错的，有死角
 * 思路2：递归 ， 扫描过的元素设置为1，没扫描过的为0
 * 思路3：回溯法 回溯法精髓：回到过去。先改变状态，然后调用自身，然后回到过去状态，所以这里的状态调整非常重要
 * 回溯法需要先画一棵树理解，可以用栈实现，也可以用list实现
 */

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> re = new ArrayList<>();
        int[] used = new int[nums.length];
        dfs(res, re, used, nums);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> re, int[] used, int[] nums){
        if (re.size() == nums.length) {
            res.add(new ArrayList<>(re));//这一步相当重要，不能直接add（re），因为re不停的在变换，结果无法集中，必须new一个新的list来保存
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (used[i] != 0) continue;
            else {
                re.add(nums[i]);
                used[i] = 1;
                dfs(res, re, used, nums);
                re.remove(re.size() - 1);
                used[i] = 0;
            }
        }

    }
}
