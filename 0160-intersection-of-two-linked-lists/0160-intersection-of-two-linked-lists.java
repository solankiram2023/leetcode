/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 /**
 Approach:
 This a brute force solution to find the intersection node of 2 single linked list


 We interate through every node in list A('headA') and, for each node,
 iterate through every node in list B('headB') to check if the two nodes are same (ie. they reference to the same memory location )

 If such node is found, that node is the intersection point and we return it,
 If no intersection is found after comparison we return null.

 Steps:
 1. Traverse list A node by Node
 2. For each node in A, start from the beginning of list B.
 3. Traverse list B to compare with the current node of A.
 4. If both nodes point to the same reference, we found the intersection.
 5. If no intersection is found return null.

  */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //Traverse list A node by node
        while(headA != null){
            //For each node in A, start from the beginning of list B.
            ListNode pB = headB;

            while (pB != null){
                if (headA == pB) return headA;

                pB=pB.next;
            }

            headA=headA.next;
        }

        return null;
    }
}

/*
Time Complexity: O(m*n):
 Where m=length of listA, n = length of listB
 For exxh node in list A, we traverse the entire list B.

 Space Complexity : O(1)
 No extra space is used; only pointer variables are reused.

 */