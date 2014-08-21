public class Solution {
	public List<String> wordWrap(List<String> strs, int n) {
		List<String> list = new ArrayList<String>();
		if(strs == null || strs.size() == 0) return list;
		//lc[i][j] line cost to put i to j words in a line / lc[0][0] = 0 / INF if length longer than n
		int[][] lc = new int[strs.size()+1][strs.size()+1];
		lc[0][0] = 0;
		//c[k] for k words the minimum cost / c[0] = 0 / c[k] = Min(c[j-1] + lc[j][k]) 1<=j<=k-1
		int[] c = new int[n+1];
		c[0] = 0;
		//p[k] for k words in the best solution the last line words from p[k] to k
		int[] p = new int[n+1];
		p[0] = 0;
		for(int i=1;i<=strs.size();i++) {
			lc[i][i] = n - strs.get(i).length();
			for(int j=i+1;j=<strs.size();j++) {
				lc[i][j] = n - lc[i][j-1] - 1;
				if(lc[i][j] < 0) lc[i][j] = Interger.MAX_VALUE;
			}
		}
		for(int i=1;i<=n;i++) {
			int min = Integer.MAX_VALUE;
			for(int j=0;j<=i-1;j++) {
				if(min < c[j] + lc[j+1][i]) {
					min = c[j] + lc[j+1][i];
					p[i] = j+1;
				}
			}
		}
		int k = n;
		while(k > 0) {
			String s = "";
			for(int i=p[k];i<=k;i++) {
				s += " " + strs.get(i);
			}
			list.add(s);
			k = p[k] - 1;
		}
	}
}
