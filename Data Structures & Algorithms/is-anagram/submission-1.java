

class Solution {
    public boolean isAnagram(String s, String t) {
        // 1. Fix: Corrected syntax for map declaration and changed key to Character
        Map<Character, Integer> map = new HashMap<>();
        
        // 2. Fix: Added parenthesis () to s.length and t.length
        if (s.length() != t.length()) {
            return false;
        }
        
        // Loop through both strings simultaneously
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Add 1 for the character found in string 's'
            map.put(charS, map.getOrDefault(charS, 0) + 1);
            
            // Subtract 1 for the character found in string 't'
            map.put(charT, map.getOrDefault(charT, 0) - 1);
        }

        // Check if all character balances are exactly 0
        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
