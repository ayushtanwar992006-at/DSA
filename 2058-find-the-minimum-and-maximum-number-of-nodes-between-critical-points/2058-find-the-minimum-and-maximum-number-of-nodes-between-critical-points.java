/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = {-1, -1};

        if(head == null) return result;
        int prevData = head.val;
        int idx = 1;
        ArrayList<Integer> criticalPointIndex = new ArrayList<>();

        ListNode curr = head.next;
        while(curr.next != null){
            int nextData = (curr.next).val;

            if(((curr.val > prevData) && (curr.val > nextData)) || ((curr.val < prevData) && (curr.val < nextData))){
                criticalPointIndex.add(idx);
            }

            prevData = curr.val;
            idx++;
            curr = curr.next;
        }

        int minDistance = Integer.MAX_VALUE;
        for(int i=0 ; i<criticalPointIndex.size()-1 ; i++){
            int diff = criticalPointIndex.get(i+1) - criticalPointIndex.get(i);
            if(diff < minDistance){
                minDistance = diff;
            }
        }
        if(criticalPointIndex.size() >= 2){
            result[0] = minDistance;
            result[1] = criticalPointIndex.get(criticalPointIndex.size()-1) - criticalPointIndex.get(0);
        }

        return result;
    }
}