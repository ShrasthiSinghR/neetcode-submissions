


class Solution {
    public int characterReplacement(String s, int k) {
        int low = 0, res = 0, maxFreq = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);

            // 1. Include high
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            // 2. Shrink while condition is invalid
            while ((high - low + 1) - maxFreq > k) {
                char leftChar = s.charAt(low);
                map.put(leftChar, map.get(leftChar) - 1);
                low++;
            }

            // 3. Update result
            res = Math.max(res, high - low + 1);
        }

        return res;
    }
}

