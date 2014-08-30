/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode fake = new RandomListNode(-1);
        RandomListNode curr = fake;
        RandomListNode loop = head;
        while(loop != null) {
            RandomListNode node = new RandomListNode(loop.label);
            curr.next = node;
            map.put(loop, node);
            curr = curr.next;
            loop = loop.next;
        }
        loop = head;
        curr = fake;
        while(loop != null) {
            RandomListNode randomNode = loop.random;
            RandomListNode randomNode2 = map.get(randomNode);
            curr.next.random = randomNode2;
            curr = curr.next;
            loop = loop.next;
        }
        return fake.next;
    }
}
