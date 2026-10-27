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
    public void reorderList(ListNode head) {
        ArrayList<ListNode> address = new ArrayList<>();

        ListNode temp = head;
        while(temp != null){
            address.add(temp);
            temp = temp.next;
        }

        int high = address.size()-1;
        int low = 1;

        temp = head;
        while(low < high){
            temp.next = address.get(high);
            temp = temp.next;
            high--;
            
            if(low < high){
                temp.next = address.get(low);
                temp = temp.next;
                low++;
            }
        }

        temp.next = address.get(high);
        temp = temp.next;
        temp.next = null;

        return;
    }
}