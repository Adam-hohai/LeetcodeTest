package hhuc.cenhelm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 49 字母异位词 中等题
 */

public class Solution49 {
    public static void main(String[] arg){
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = new Solution49().groupAnagrams(strs);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] strs2 = new String[strs.length];//排过序的strs
        int[] used = new int[strs.length];//状态数组
        for (int i = 0; i < strs.length; i++){
            String[] str = strs[i].split("");
            Arrays.sort(str);
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : str){
                stringBuilder.append(s);
            }
            strs2[i] = stringBuilder.toString();
        }
        List<List<String>>  lists = new ArrayList<>();
        for (int i = 0; i < strs2.length; i++) {
            if (used[i] == 0){
                List<String> list = new ArrayList<>();
                for (int j = 0; j < strs2.length; j++) {

                    if (strs2[i].equals(strs2[j])) {
                        used[j] = 1;
                        list.add(strs[j]);
                    }
                }
                lists.add(list);
            }
        }
        return lists;
    }
}
