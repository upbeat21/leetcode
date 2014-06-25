public class Solution {
    public int lengthOfLongestSubstring(String s) {
       if(s == null || s.length() == 0) return 0;
       Set<Character> set = new HashSet<Character>();
       int max = 0;
       int i = 0, j = 0;
       while(i<s.length() && j<s.length()) {
           char c = s.charAt(j);
           if(set.contains(c)) {
               max = Math.max(max, j-i);
               set.remove(s.charAt(i));
               i++;
           } else {
               set.add(c);
               max = Math.max(max, j-i+1);
               j++;
           }
       }
       return max;
    }
}
