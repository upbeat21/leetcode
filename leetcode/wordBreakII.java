public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> list = new ArrayList<String>();
        if(s == null) return list;
        boolean[] a = new boolean[s.length()+1];
        a[0] = true;
        for(int i=1;i<=s.length();i++) {
            for(int j=0;j<i;j++) {
                if(a[j] && dict.contains(s.substring(j, i))) a[i] = true;
            }
        }
        if(!a[s.length()]) return list;
        helper(list, s, dict, "", 0);
        return list;
    }
    public void helper(List<String> list, String s, Set<String> dict, String t, int start) {
        if(start == s.length()) {
            t = t.trim();
            list.add(t);
            return;
        }
        String p = "";
        for(int i=start;i<s.length();i++) {
            p += s.charAt(i);
            if(dict.contains(p)) {
                helper(list, s , dict, t+" "+p, i+1);
            }
        }
    }
}
