public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        helper(list, "", n, 0, 0);
        return list;
    }
    public void helper(List<String> list, String s, int n, int closed, int open) {
        if(closed == n) {

            list.add(s);
            return;
        }
        if(open < n) {
            helper(list, s + "(", n, closed, open + 1);
        }
        if(open > closed) {
            helper(list, s + ")", n, closed+1, open);
        } 
    }
}
