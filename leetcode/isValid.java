public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if(stack.isEmpty()) return false;
                char t = stack.pop();
                if(t != '(') return false;
            } else if(c == ']') {
                if(stack.isEmpty()) return false;
                char t = stack.pop();
                if(t != '[') return false;
            } else if(c == '}') {
                if(stack.isEmpty()) return false;
                char t = stack.pop();
                if(t != '{') return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
