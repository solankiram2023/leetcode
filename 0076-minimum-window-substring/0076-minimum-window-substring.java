class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        
        Map<Character, Integer> tHashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = tHashMap.getOrDefault(t.charAt(i), 0);
            tHashMap.put(t.charAt(i), count + 1);
        }

        
        int required = tHashMap.size();

       
        int l = 0, r = 0;

    
        int formed = 0;

   
        Map<Character, Integer> sHashMap = new HashMap<
            Character,
            Integer
        >();

  
        int[] ans = { -1, 0, 0 };

        while (r < s.length()) {

            char c = s.charAt(r);
            int count = sHashMap.getOrDefault(c, 0);
            sHashMap.put(c, count + 1);

     
            if (
                tHashMap.containsKey(c) &&
                sHashMap.get(c).intValue() == tHashMap.get(c).intValue()
            ) {
                formed++;
            }

          
            while (l <= r && formed == required) {
                c = s.charAt(l);

                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

            
                sHashMap.put(c, sHashMap.get(c) - 1);
                if (
                    tHashMap.containsKey(c) &&
                    sHashMap.get(c).intValue() < tHashMap.get(c).intValue()
                ) {
                    formed--;
                }

            
                l++;
            }


            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}