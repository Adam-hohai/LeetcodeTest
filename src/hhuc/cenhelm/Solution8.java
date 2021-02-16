package hhuc.cenhelm;

/**
 * 字符串转化整数
 */

public class Solution8 {
    public int myAtoi(String s) {
        String[] arrS = s.split("");
        int firstS = 0;//读取的第一个数字字符位置，相当于一个滑动窗口
        int endS = 0;//读取的最后一个数字字符的位置
        int flag = 1;//正负标记
        int sum = 0;//用于返回的结果
        try {//s=" "时会越界
            while (arrS[firstS].equals(" ")) {//过滤空格
                firstS++;
            }
        } catch (Exception e) {
            return 0;
        }
        if (arrS[firstS].equals("+")) firstS++;
        else if (arrS[firstS].equals("-")) {
            flag = -1;
            firstS++;
        } else if (arrS[firstS].compareTo("0") >= 0 && arrS[firstS].compareTo("9") <= 0) ;
        else return 0;//开头字母的直接返回0
        try {
            while (arrS[firstS].equals("0")) firstS++;//过滤0
        } catch (Exception e) {
            return 0; //s="+"时会越界
        }

        endS = firstS;
        while (endS < arrS.length) {
            if (arrS[endS].compareTo("0") >= 0 && arrS[endS].compareTo("9") <= 0) endS++;
            else {
                break;
            }
        }
        endS--;
        if (endS - firstS == 0) return 0;
        else {
            for (int i = firstS; i <= endS; i++) {
                int temp = sum;
                sum = sum * 10 + Integer.parseInt(arrS[i]);
                if (sum / 10 != temp && flag == 1) return (int) Math.pow(2, 31) - 1;
                if (sum / 10 != temp && flag == -1) return (int) -Math.pow(2, 31);
            }
            return sum * flag;
        }
    }
}
