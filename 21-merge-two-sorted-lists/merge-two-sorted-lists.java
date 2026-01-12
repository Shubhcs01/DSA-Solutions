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

     public ListNode mergeTwoLists(ListNode node1, ListNode node2){
    
      if(node1 == null) return node2==null? null: node2;
      if(node2 == null) return node1==null? null: node1;
      
      ListNode temp1 = null, temp2 = null;
      ListNode ans = null, ansHead = null;
      
      if(node1.val < node2.val){
        ans = new ListNode(node1.val,null);
        temp1 = node1.next;
        temp2 = node2;
      } else {
        ans = new ListNode(node2.val,null);
        temp2 = node2.next;
        temp1=node1;
      }
      
      ansHead = ans;
      
      while(temp1 != null && temp2 != null){
        if(temp1.val < temp2.val){
          ans.next = new ListNode(temp1.val,null);
          temp1 = temp1.next;
        } else {
          ans.next =  new ListNode(temp2.val,null);;
          temp2 = temp2.next;
        }
        
        ans = ans.next;
      }
      
      if(temp1 != null){
        ans.next = temp1;
      }
      
      if(temp2 != null){
        ans.next = temp2;
      }
      
      return ansHead;
    }
}