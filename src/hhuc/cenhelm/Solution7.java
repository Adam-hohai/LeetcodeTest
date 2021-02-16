package hhuc.cenhelm;

/**
 * 数字反转
 * 这题还没解决，int溢出后捕获不了异常
 * 已解决，将快要溢出的前一个少一位的数和溢出后的数除以十进行比较，不相等就返回0
 */

public class Solution7 {
    public int reverse(int x) {
        if(x == -2147483648) return 0;//取反后会溢出，单独拿出来
        if (x == 0 || x < -Math.pow(2, 31) || x > Math.pow(2, 31) - 1) {
            return 0;
        } else {
            boolean flag = true;
            if (x < 0) {
                flag = false;
                x = -x;
            }
            while (x % 10 == 0) {
                x = x / 10;
            }
            String strX = String.valueOf(x);
            String[] arrX = strX.split("");
            int[] arrX2 = new int[arrX.length];
            for (int i = 0; i < arrX.length; i++) {
                arrX2[i] = Integer.parseInt(arrX[arrX.length - 1 - i]);
            }
            int sum = 0;
//            try {//其实这步理论上是有可能有异常的，因为数字反转后可能会溢出，但是Java机制溢出的话是不会报异常的，所以这里压根捕获不到，暂时没找到解决办法
//                for (int i : arrX2) {
//                    sum = sum * 10 + i;
//                }
//                return flag ? sum : -sum;
//            }catch (Exception e) {
//                return 0;
//            }
            for (int i : arrX2) {
                int temp = sum;
                sum = sum * 10 + i;
                if (sum / 10 != temp) return 0;
            }
            return flag ? sum : -sum;

        }
    }
}
