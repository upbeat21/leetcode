public class Solution {
    public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] r = new int[2];
		for(int i=0;i<numbers.length;i++) {
			if(map.containsKey(numbers[i])) {
				r[0] = map.get(numbers[i]) + 1;
				r[1] = i + 1;
			} else {
				map.put(target - numbers[i], i);
			}
		}
		return r;
    }
}
