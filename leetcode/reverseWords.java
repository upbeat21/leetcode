public class Solution {
    public String reverseWords(String s) {
       if(s == null || s == "") return s;
       s = s.trim();
       String[] a = s.split("\\s+");
       StringBuilder sb = new StringBuilder();
       for(int i=a.length-1;i>=0;i--) {
           sb.append(a[i]);
           sb.append(" ");
       }
       if(sb.length() >= 1)    sb.setLength(sb.length()-1);
       return sb.toString();
    }
}
