package hhuc.cenhelm;

/**
 * 盛最多的水 中等题 算法题
 * 遇到问题，时间复杂度为O(n^2)时超出内存限制
 * 对O(n)的算法写一下自己的理解，一开始两个指针一个指向开头一个指向结尾，
 * 此时容器的底是最大的，接下来随着指针向内移动，会造成容器的底变小，在这种情况下想要让容器盛水变多，就只有在容器的高上下功夫。
 * 那我们该如何决策哪个指针移动呢？我们能够发现不管是左指针向右移动一位，还是右指针向左移动一位，容器的底都是一样的，都比原来减少了 1。
 * 这种情况下我们想要让指针移动后的容器面积增大，就要使移动后的容器的高尽量大，所以我们选择指针所指的高较小的那个指针进行移动，
 * 这样我们就保留了容器较高的那条边，放弃了较小的那条边，以获得有更高的边的机会。
 */

public class Solution11 {
    public int maxArea(int[] height) {
//        int[] s = new int[(height.length-1)*height.length/2];
//        int max = 0;
//        for (int i = 0; i < height.length; i++){
//            for (int j = i+1; j < height.length; j++){
//                s[i+j-1] = Math.min(height[i],height[j])*(j-i);
//            }
//        }
//        for (int num : s){
//            if(num > max) max = num;
//        }
//        return max;
        int left = 0;
        int right = height.length-1;
        int ans = 0;
        while (left < right){
            ans = Math.max(ans, (right-left)*Math.min(height[left],height[right]));
            if(height[left] < height[right]) ++left;
            else ++right;
        }
        return ans;
    }
}
