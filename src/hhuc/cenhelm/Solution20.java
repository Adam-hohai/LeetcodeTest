package hhuc.cenhelm;

import java.util.Stack;

/**
 * 20 有效的括号 简单题
 * 考查 栈
 * 这里注意一下if的执行顺序，只要满足并执行了一个分支，就会直接跳出去，不会再判断下面的分支
 * 还有注意只要pop就会出栈，不管用来赋值还是什么
 */

public class Solution20 {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (String str : s.split("")){
            if(str.equals("(")) stack.push(")");
            else if (str.equals("[")) stack.push("]");
            else if (str.equals("{")) stack.push("}");
            else if (stack.isEmpty() || !str.equals(stack.pop())) return false;
        }
        return stack.isEmpty();
    }
}
