/*

Approach:
-Use two pointers, 'start' and 'end', to represent the current window of unique characters.
-Expand the 'end' pointer and add characters to a HashSet until a duplicate character is found.
-When a duplicate is found increment 'start' and remove characters from the set until the duplicate is removed.
-At each step, update the maximum length of the substring found so far.
 

Steps:-
1. Sliding window pointers
2. HashSet to store unique characters in the current window
3. To keep track of the lowest substring
4. Iterate through the string using the end pointer
5. Get the character at the end position
6. If Character is already in Set, remove characters from the start
untill we can safely add the current character
7. Remove from the set 
8. Shrink the window from the start
9.  Add the current character to the set(no duplicate now)
10.Move the end pointer to expand the window
11. Return length of the longest string


*/

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int start =0, end=0;
        Set<Character> set = new HashSet<>();
        int maxLen=0;

        while(end<s.length()){
            Character ch = s.charAt(end);

            while(set.contains(ch)){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(ch);
            maxLen = Math.max(maxLen, end-start+1);
            end++;


        }
        return maxLen;
    }
}
        
