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
    public ListNode mergeKLists(ListNode[] lists) {

        int size = lists.length;
        if(size <= 0) return null;
        ListNode temp = lists[0];
        
        for(int i=1 ; i<size ; i++){
            temp = merge2Lists(temp, lists[i]);
        }

        return temp;
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while((l1 != null) && (l2 != null)){
            if(l1.val > l2.val){
                curr.next = l2;
                curr = l2;
                l2 = l2.next;
            }
            else{
                curr.next = l1;
                curr = l1;
                l1 = l1.next;
            }
        }

        if(l1 != null) curr.next = l1;
        else curr.next = l2;
        
        return dummy.next;
    }
}