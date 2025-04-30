/*
Approach:
We are given two strings S and T.
S defines a custom order of characters (no repititions).
We need to sort the characters in T such that their relative ordering follows the one in S.
characters in T that are not in S can appear anywhere in the result.


Steps:
1. Count the frequency of each character in T using a HashMap.
2. For every character in S, append it to the result as many as it appears in T.
This ensures the correct custom order.
3. Finally, append any remaining characters from T (those not in S) in any order.


Coding Steps:
1. StringBuilder is used to effectively build the result string.
2. HashMap to store the frequency of each character in T.
3. Step1: Build frequency map for character in T.
4. For each character ch in T, increment its count in the map.
5. Step2: Append character from S to result according to their frequency in T.
6. Get the frequency of character ch (if it's in T)
7. Append ch 'count' times to the result
8. Remove the character from the map after adding it to result
so it won't be considered again
9. Append the character as many times as its frequency
10. Return the final sorted string

*/



// class Solution {
//     public String customSortString(String order, String s) {

//         int[] arr= new int[26];
//         for(int i=0;i<s.length; i++){
//             arr[s.charAt(i) - 'a']++;

//         }
//         char letter = 'a';
//         int length=0;
//         StringBuilder result = new StringBuilder();
//         for(int i=0; i<order.length;i++) {
//             if(arr[order.charAt(i) - 'a'] > 0) {
//                 letter = order.charAt(i);
//                 length = arr[order.charAt(i) - 'a'];
//                 for(int j=0; j<length; j++){
//                     result.append(letter);
//                     arr[letter - 'a']--;
//                 }
//             }
//         }
//        for(int i=0;i< 26;i++){
//         if(arr[i] > 0){
//             for(int j=0; j<arr[i];j++){
//                 result.append((char)(i+'a'));
//             }
//         }
//        } 
//        return result.toString();
//     }
// }

class Solution{
    public String customSortString(String S, String T){
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : T.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(char ch : S.toCharArray()){
            int count = map.getOrDefault(ch, 0);

            while(count-- > 0){
                sb.append(ch);
            }
            map.remove(ch);

        }
        for(Map.Entry<Character, Integer>entry : map.entrySet()){
            char ch = entry.getKey();
            int count = entry.getValue();

            while(count-- > 0){
                sb.append(ch);
            }
        }
        return sb.toString();

    }
}
