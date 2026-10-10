


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int low = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        // Store frequency of characters in s1
        for (char ch : s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int matched = 0;
        HashMap<Character, Integer> window = new HashMap<>();

        for (int high = 0; high < s2.length(); high++) {
            char ch = s2.charAt(high);

            // 1. Include high
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // 2. Keep window size fixed at k
            if (high - low + 1 > k) {
                char leftChar = s2.charAt(low);
                window.put(leftChar, window.get(leftChar) - 1);

                if (window.get(leftChar) == 0) {
                    window.remove(leftChar);
                }

                low++;
            }

            // 3. Check valid window
            if (high - low + 1 == k && window.equals(map)) {
                return true;
            }
        }

        return false;
    }
}

