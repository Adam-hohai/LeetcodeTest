package hhuc.cenhelm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17 电话号码的数字组合 中等题
 * 由于无法确定循环次数，所以只能用递归
 */

public class Solution17 {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        String stemp = "";
        List<String> list = new ArrayList<>();
        if (digits.equals("")) return list;
        list = getString(map, 0, stemp, list, digits);
        return list;
    }

    /**
     * 递归叠加
     * @param map 哈希键值对
     * @param i 递归次数为字符串长度
     * @param stemp 叠加的字符串
     * @param list 字符数组
     * @param digits 字符串
     * @return 字符数组
     */
    private List<String> getString(Map<Character, String> map, int i, String stemp, List<String> list, String digits){

        if (i < digits.length()-1){
            for(int j = 0; j < map.get(digits.charAt(i)).length(); j++){
                list = getString(map, i+1, stemp+map.get(digits.charAt(i)).charAt(j), list, digits);
            }
            ++i;
        }else {
            for(int j = 0; j < map.get(digits.charAt(i)).length(); j++){
                list.add(stemp+map.get(digits.charAt(i)).charAt(j));
            }
        }

        return list;
    }
}
