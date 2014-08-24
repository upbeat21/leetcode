/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(node.label, copyNode);
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.pop();
            UndirectedGraphNode curCopy = map.get(curNode.label);
            for(UndirectedGraphNode nei : curNode.neighbors) {
                if(map.containsKey(nei.label)) {
                    curCopy.neighbors.add(map.get(nei.label));
                } else {
                    UndirectedGraphNode copyNei = new UndirectedGraphNode(nei.label);
                    curCopy.neighbors.add(copyNei);
                    map.put(nei.label, copyNei);
                    queue.add(nei);
                }
            }
        }
        return copyNode;
    }
}
