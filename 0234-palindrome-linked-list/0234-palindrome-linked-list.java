

// import com.sun.org.apache.xalan.internal.xsltc.dom.CurrentNodeListFilter;

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
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;

        ListNode firstHalfEnd=endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result=true;
        while(result && p2!=null){
            if(p1.val != p2.val){
                result =false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return result;
    }


    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode nextTemp = curr.next;
            curr.next =prev;
            prev=curr;
            curr=nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head){
        ListNode fast =head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}