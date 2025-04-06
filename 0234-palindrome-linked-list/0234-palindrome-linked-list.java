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

 /*
Approach:
1. This solution converts the linked list into an ArrayList to use index-based access.
2. Then, we apply the two pointer technique to check whether the list is a palindrome.
3. If values from the front and back match all the way through, its a palindrome
4. This approach trades off space for simplicity (O(n) space)


 */


 /*
Steps:
1. Create an Arraylist to store the values of the LinkedList
2. Traverse the linked list and store each node's value in the list
3. Use two-pointer approach to compare front and back
4. Important use .equals() for comparing Integer objects
5. If Mismatch is found -> not a palindrome
6. All matched -> the linked list is a palindrome

 */

// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         List<Integer> vals = new ArrayList<>();
//         ListNode currentNode = head;

//         while (currentNode != null) {
//             vals.add(currentNode.val);
//             currentNode = currentNode.next;
//         }

//         int front = 0;
//         int back = vals.size() -1;

//         while(front<back){

//             if(!vals.get(front).equals(vals.get(back))) {
//                 return false;
//             }

//             front++;
//             back--;
//         }

//         return true;
        
//     }
// }

/*
Time Complexity:O(n)
O(n) to traverse the linked list and store values in an ArrayList
O(n) to compare values using the two-pointer technique.
Total = O(n)

Space Complexity: O(n):
O(n) additional space is used to store node values in ArrayList.
No modifications are made to the original linkedlist.

*/

/*
Approach #2:

-This solution uses a recursive approach to compare nodes from front and back simultaneously.
-It uses a class level pointer 'frontPointer' that starts from head and moves forward.
-The recursion drives to the end of the list (backward traversal), and as the recursion stack unwinds,
it compares the current node (from back) with the 'frontPointer' (from front).
-If all values match during unwinding, the list is a palindrome.

-This approach is elegant and avoids modifying the list or using extra data structures like ArrayList.

*/

/*
Steps:
1. Class-level pointer that moves forward during the recursion unwinding
2. Recursive function to check if the list is a palindrome
3. Base case: If we have reached the end of the list , return true
4. Recursive call to go deeper into the list
5. If a missmatch has already occured, propagate false
6. Check if the current node value matches frontPointer's value
7. Values don't match -> not a palindrome
8. Move frontPointer forward for the next comparison during unwinding
9. All matched-> its palindrome
10. Public method that initializes the front pointer and starts recursion

*/

class Solution{
    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode){

        if (currentNode != null){

            if(!recursivelyCheck(currentNode.next)){
                return false;
            }

            if (currentNode.val != frontPointer.val){
                return false;
            }

            frontPointer = frontPointer.next;

        }

        return true;
    }

    public boolean isPalindrome(ListNode head){
        frontPointer = head;
        return recursivelyCheck(head);
    }
}

/*
Time Complexity: O(n)
-Each node is visited exactly once during the recursion (depth = n)
-Total time is linear in the number of nodes.

Space Complexity: O(n)
-Due to recursion the call stack grows up to the length of the list (n).
-No additional data structure are used.
*/