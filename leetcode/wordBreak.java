public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null) return false;
        boolean[] helper = new boolean[s.length()+1];
        helper[0] = true;
        for(int i=1;i<=s.length();i++) {
            for(int j=0;j<i;j++) {
                String sub = s.substring(j, i);
                if(helper[j] && dict.contains(sub)) helper[i] = true;
            }
        }
        return helper[s.length()];
    }
}
