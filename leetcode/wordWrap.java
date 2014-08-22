import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static List<String> wordWrap(List<String> strs, int n) {
        List<String> list = new ArrayList<String>();
        if(strs == null || strs.size() == 0) return list;
        //lc[i][j] the cose to put words i to j in one line / lc[0][0] = 0 / INF if not enough space
        int[][] lc = new int[strs.size()+1][strs.size()+1];
        lc[0][0] = 0;
        //c[k] the optimal cost to wrap k words / c[k] = Min(c[j] + lc[j+1][k]) 1<=j<=k-1
        int[] c = new int[strs.size()+1];
        c[0] = 0;
        //p[k] = j the last line is from j to k
        int[] p = new int[strs.size()+1];
        for(int i=1;i<=strs.size();i++) {
            lc[i][i] = n - strs.get(i-1).length();
            for(int j=i+1;j<=strs.size();j++) {
                lc[i][j] = lc[i][j-1] - 1 - strs.get(j-1).length();
                if(lc[i][j] < 0) lc[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=1;i<=strs.size();i++) {
            int min = Integer.MAX_VALUE;   
            for(int j=0;j<=i-1;j++) {
                if(min > c[j] + lc[j+1][i]) {
                    min = c[j] + lc[j+1][i];
                    p[i] = j+1;
                }
            }
        }
        int k = strs.size();
        while(k > 0) {
            String s = "";
            for(int i=p[k];i<=k;i++) {
                s += strs.get(i-1) + " ";
            }
            s = s.trim();
            list.add(s);
            k = p[k] - 1;
        }
        Collections.reverse(list);
        return list;
    }
    public static List<String> convert(String s) {
    	s = s.trim();
    	return Arrays.asList(s.split("\\s+"));
    }
    public static void main(String[] args) {
    	String str = "aaa bb cc ddddd";
    	List<String> strs = convert(str);
    	int n = 5;
    	List<String> wrap = wordWrap(strs, n);
    	for(String s : wrap) System.out.println(s);
    }
}
