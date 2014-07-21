public class Solution {
    public String countAndSay(int n) {
		String s = "1";
		for(int i=1;i<n;i++) {
			StringBuilder sb = new StringBuilder();
			int num = -1;
			int times = -1;
			for(int j=0;j<s.length();j++) {
				int curr = Integer.parseInt(s.substring(j, j+1));
				if(curr == num) {
					times++;
				} else {
					if(num != -1) {
						sb.append(times);
						sb.append(num);
					}
					num = curr;
					times = 1;
				}
			}
			sb.append(times);
			sb.append(num);
			s = sb.toString();
		}
		return s;
    }
}
