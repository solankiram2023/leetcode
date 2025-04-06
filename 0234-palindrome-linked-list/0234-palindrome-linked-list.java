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

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        ListNode currentNode = head;

        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        int front = 0;
        int back = vals.size() -1;

        while(front<back){

            if(!vals.get(front).equals(vals.get(back))) {
                return false;
            }

            front++;
            back--;
        }

        return true;
        
    }
}