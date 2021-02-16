package hhuc.cenhelm;

/**
 * 罗马数字转数字 简单题
 * 我好像发现一件事，if条件就算通过了，依旧会去验证else条件是否通过（虽然else肯定通不过），所以有可能会因为数据类型报错
 */

public class Solution13 {
    public int romanToInt(String s){
        String[] arrS = s.split("");
        int index = 1;
        int sum = 0;
        while(index < arrS.length){
            if(arrS[index].equals("V") && arrS[index-1].equals("I")){
                arrS[index-1] = "4";
                arrS[index] = "0";
                index += 2;
                continue;
            }
            if(arrS[index].equals("X") && arrS[index-1].equals("I")){
                arrS[index-1] = "9";
                arrS[index] = "0";
                index += 2;
                continue;
            }
            if(arrS[index].equals("L") && arrS[index-1].equals("X")){
                arrS[index-1] = "40";
                arrS[index] = "0";
                index += 2;
                continue;
            }
            if(arrS[index].equals("C") && arrS[index-1].equals("X")){
                arrS[index-1] = "90";
                arrS[index] = "0";
                index += 2;
                continue;
            }
            if(arrS[index].equals("D") && arrS[index-1].equals("C")){
                arrS[index-1] = "400";
                arrS[index] = "0";
                index += 2;
                continue;
            }
            if(arrS[index].equals("M") && arrS[index-1].equals("C")){
                arrS[index-1] = "900";
                arrS[index] = "0";
                index += 2;
            }
            else ++index;
        }
        for (String str : arrS){
            if(str.equals("I")) sum += 1;
            if(str.equals("V")) sum += 5;
            if(str.equals("X")) sum += 10;
            if(str.equals("L")) sum += 50;
            if(str.equals("C")) sum += 100;
            if(str.equals("D")) sum += 500;
            if(str.equals("M")) sum += 1000;
            else{//不加捕获异常leetcode调试通不过，不知道为什么
                try{
                    sum += Integer.parseInt(str);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        return sum;
    }
}
