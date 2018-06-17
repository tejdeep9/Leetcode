//https://leetcode.com/problems/add-two-numbers/description/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null || l2 == null)
            return l1 != null?  l1 : l2;
        
        ListNode result = new ListNode(0);
        ListNode headNode = result;
        
        int carry = 0;
        while(l1 != null && l2 !=null) {
            int sum = l1.val+l2.val+carry;
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            result.next = newNode;
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;        
        }
        
        while(l1 != null) {
            int sum = l1.val+carry;
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            result.next = newNode;
            result = result.next;
            l1 = l1.next;    
        }
        
       while(l2 != null) {
            int sum = l2.val+carry;
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            result.next = newNode;
            result = result.next;
            l2 = l2.next;    
       }     
        
       if(carry == 1) {
            ListNode newNode = new ListNode(carry);
            result.next = newNode;
       }
        
       return headNode.next;
    }
}