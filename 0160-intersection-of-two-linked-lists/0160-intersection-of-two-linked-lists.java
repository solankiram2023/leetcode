// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) {
//  *         val = x;
//  *         next = null;
//  *     }
//  * }
//  */

//  /**
//  Approach:
//  This a brute force solution to find the intersection node of 2 single linked list


//  We interate through every node in list A('headA') and, for each node,
//  iterate through every node in list B('headB') to check if the two nodes are same (ie. they reference to the same memory location )

//  If such node is found, that node is the intersection point and we return it,
//  If no intersection is found after comparison we return null.

//  Steps:
//  1. Traverse list A node by Node
//  2. For each node in A, start from the beginning of list B.
//  3. Traverse list B to compare with the current node of A.
//  4. If both nodes point to the same reference, we found the intersection.
//  5. If no intersection is found return null.

//   */
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         //Traverse list A node by node
//         while(headA != null){
//             //For each node in A, start from the beginning of list B.
//             ListNode pB = headB;

//             while (pB != null){
//                 if (headA == pB) return headA;

//                 pB=pB.next;
//             }

//             headA=headA.next;
//         }

//         return null;
//     }
// }

// /*
// Time Complexity: O(m*n):
//  Where m=length of listA, n = length of listB
//  For exxh node in list A, we traverse the entire list B.

//  Space Complexity : O(1)
//  No extra space is used; only pointer variables are reused.

//  */
/*
Approach#2: Hashset

This solution uses a HashSet to detect the intersection node of 2 singly linked lists.

1. Traverse the entire second list (headB) and store each node reference in a HasHSet.
2. Then traverse the first list (headA), and for each node, check if it exists in the HashSet.
If a node from list A is found in the HashSet, it means both lists intersect at that node.
3. If we reach the end of the list A without finding a match, return null(no intersection)

Steps:
1. Create a HashSet to store all nodes of list B.
2. Traverse list B and add each node to the HashSet.
3. store the reference to the current node.
4. Traverse list A to find the first node that appears in the hashSet.
5. If the current node of List A is in the HashSet, we found the intersection
6. return the intersection node
7. if no intersection is found return null.


*/


// public class Solution{
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB){
//         Set<ListNode> nodesInB = new HashSet<ListNode>();

//         while(headB != null){
//             nodesInB.add(headB);
//             headB = headB.next;
//         }

//         while(headA != null){
//             if(nodesInB.contains(headA)){
//                 return headA;

//             }
//             headA = headA.next;   
//         }

//         return null;
//     }
// }

/**
Time Complexity: O(m+n):
- O(n) to traverse list B and store the nodes in the HashSet
- O(m) to traverse listA and check for Intersection.

Space Complexity:0(n):

-O(n) additional space is used to store nodes of list B in the HashSet
Where n = length of list B, and m = length of list A.


 */


 /*Approach: Most Optimized Approach


 1. Use two pointers, 'pA' and 'pB', starting at the heads of List A and List B respectively.
 2. Traverse both the lists. When a pointer reaches the end of one list, redirect to the head of the other list.
 3. If the 2 lists intersect, the ponters will meet at the intersection node after at most 2 passes.
 4. If the 2 nodes do not intersect, both pointers will eventually be null at the same time, and the loop exits.

 Why this works:
-By switching heads, each pointer traverses the same total distance: lengthA + lengthB
-This evens out the difference in length between the 2 lists without explicitly calculating lengths.



STEPS:

1. Initialize two pointers at the heads of the two lists.
2. Loop until both pointers are equal (either at intersection node or both null)
3. If pA reaches the end of list A, redirect it to head of list B.
4. Otherwise, move to the next node
5. If pB reaches to the end of list B, redirect it to the head of list A.
6. Otherwise move to the next node.
7. return the intersection node or null if no intersection exists.


 */


 public class Solution{

    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode pA = headA;
        ListNode pB = headB;

        while(pA != pB){

            pA = (pA == null) ? headB : pA.next;

            pB = (pB == null) ? headA : pB.next;        
        }
        return pA;
     }
 }

 /**
 Time Complexity:- O(m+n):
 1. Where m = length of list A, and n = length of list B.
 2. Each pointer traverses at most m+n nodes.


 Space Complexity: O(1):
 No extra space is used; only two pointers are maintained.
 
  */