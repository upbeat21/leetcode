public class evaluateRPN {
	public List<String> opList = Arrays.asList("+", "-", "*", "/");
    public int evalRPN(String[] tokens) {
		List<Integer> queue = new ArrayList<Integer>();
		int result;
        for(String s : tokens) {
			if(!isOp(s)) {
				queue.add(Integer.parseInt(s));
			} else {
				int a = queue.remove(queue.size()-1);
				int b = queue.remove(queue.size()-1);
				queue.add(calculate(a, b, s));
			}
		}
		return queue.get(0);
    }
	public boolean isOp(String s) {
		if(opList.contains(s)) return true;
		return false;
	}
	public int calculate(int a, int b, String s) {
		if(s.equals("+")) return b + a;
		else if(s.equals("-")) return b - a;
		else if(s.equals("*")) return b * a;
		return b / a;
	}
}