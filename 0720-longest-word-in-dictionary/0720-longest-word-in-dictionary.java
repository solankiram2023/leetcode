/*
Approach:
1. Sort the array so that all shorter words and lexicographically smaller words come first.
2. Insert each word into a Trie.
3. while inserting, keep track of:
-How many charcters were added(newCount)
-Whether the prefix before the current character was a valid word (using isValid flag)
4. A word is considered buildable if:
 -Only one new character was added.
 -The prefix before that was already a valid word.
5. Track the longest such valid word encountered during the process.


Steps:
1. Step1: Sort words for lexicographical order and prefix availability
2. To store the final result (longest valid word)
3.Create Trie root node(dummy char)
4. Root is always valid (empty prefix)
5. Step 2: Try inserting each word into the Trie
6. If word is buildable from valid prefixes
7. Step 3: Update result if current word is longer than previous best
8. Return the longest valid word found
9. Create Tries insertion helper function that returns true if word is calidly constructed
10. Pointer to traverse the Trie
11. Stores the previous node
12. Count how many new characters are inserted.
13. If current character node already exists in Trie
14. Store current node as previous
15. Move to next node.
16. Create new node for this character
17. Increment new character counter
18. Mark the end of a word
19. A word is valid only if:
-Only one new character was added
-The prefix before it(prev) is valid
20. Mark this word as valid
21. Word is buildable
22. Word cannot be built from valid prefixes
23. Tries class definition
24. Character at this node
25. Array to hold children (a to z)
26. True if this node marks end of a valid word
27. True if word up to this node is validly constructed.
28. One slot for each lower case

*/






// class Solution {
//     public String longestWord(String[] words) {
//         Arrays.sort(words);
//         HashSet<String> builtWords = new HashSet();
//         String result = "";
//         for(String w : words){
//             if(w.length() == 1 || builtWords.contains(w.substring(0,w.length()-1))){
//                 if(w.length() > result.length()) result = w;
//                 builtWords.add(w);
//             }

//         }
//         return result;
//     }    
//}


class Solution{
    public String longestWord(String[] words){
        Arrays.sort(words);
        String retWord = "";
        TrieNode root = new TrieNode('-');
        root.isValid = true;

        for(String word: words){
            if(insert(root, word)) {
                if(word.length() > retWord.length()){
                    retWord = word;
                }
            }
        }

        return retWord;
    }


    public boolean insert(TrieNode root, String word){
        TrieNode temp = root;
        TrieNode prev = root;
        int newCount = 0;

        for(int i =0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(temp.arr[ch - 'a'] != null){
                prev = temp;
                temp = temp.arr[ch - 'a'];
            } else{
                newCount++;
                prev = temp;
                temp.arr[ch - 'a'] = new TrieNode(ch);
                temp = temp.arr[ch - 'a'];
            }
        }

        temp.isWord = true;

        if(newCount == 1 && prev.isValid){
            temp.isValid = true;
            return true;
        }
        return false;
    }
}

class TrieNode{
    char c;
    TrieNode[] arr;
    boolean isWord;
    boolean isValid;

    TrieNode(char c){
        this.c = c;
        arr = new TrieNode[26];
        isWord = false;
        isValid = false;
    }
}









    
