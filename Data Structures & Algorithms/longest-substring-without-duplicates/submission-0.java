


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int low = 0, res = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int high = 0; high < n; high++) {
            char ch = s.charAt(high);

            // 1. Include high: check if duplicate exists
            if (map.containsKey(ch)) {
                low = Math.max(low, map.get(ch) + 1);
            }

            // 2. Update last index of character
            map.put(ch, high);

            // 3. Update answer
            res = Math.max(res, high - low + 1);
        }

        return res;
    }
}

