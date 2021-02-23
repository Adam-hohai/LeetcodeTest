package hhuc.cenhelm;

import java.util.ArrayList;
import java.util.List;

/**
 * 54 螺旋矩阵 中等题
 * 思路： 设置上下左右边界，每遍历一边就缩小边界
 */

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        while (true){
            for (int i = left; i <= right; i++) res.add(matrix[up][i]);
            if (++up > down) break;
            for (int i = up; i <= down; i++) res.add(matrix[i][right]);
            if (--right < left) break;
            for (int i = right; i >= left; i--) res.add(matrix[down][i]);
            if (--down < up) break;
            for (int i = down; i >= up; i--) res.add(matrix[i][left]);
            if (++left > right) break;
        }
        return res;
    }
}
