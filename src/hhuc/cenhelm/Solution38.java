package hhuc.cenhelm;

/**
 * 38 外观数列 简单题
 */

public class Solution38 {
    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        System.out.println(solution38.countAndSay(3));
    }

    public String countAndSay(int n) {
        if(n == 1) return "1";
        String s = "11";
        for (int i = 0; i < n - 2; i++){
            s = convert(s);
        }
        return s;
    }

    public String convert(String s){
        String[] arr = s.split("");
        StringBuilder ans = new StringBuilder();
        int first = 0, end = 0;
        for (int i = 1; i < arr.length; i++){
            //String s1 = arr[i];
            if (!arr[i].equals(arr[i - 1])){
                end = i;
                ans.append(end - first);
                ans.append(arr[first]);
                first = end;
            }
            if(i == arr.length - 1){
                ans.append(arr.length - first);
                ans.append(arr[arr.length - 1]);
            }
        }
        return  ans.toString();
    }
}
