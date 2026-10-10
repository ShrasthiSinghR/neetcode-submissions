


class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int low = 0, res = Integer.MAX_VALUE;
        int start = 0, formed = 0;
        int required = map.size();

        HashMap<Character, Integer> window = new HashMap<>();

        for (int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);

            // 1. Include high
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (map.containsKey(ch)
                    && window.get(ch).intValue()
                    == map.get(ch).intValue()) {
                formed++;
            }

            // 2. Shrink while window is valid
            while (formed == required) {
                int len = high - low + 1;

                if (len < res) {
                    res = len;
                    start = low;
                }

                char leftChar = s.charAt(low);
                window.put(leftChar, window.get(leftChar) - 1);

                if (map.containsKey(leftChar)
                        && window.get(leftChar)
                        < map.get(leftChar)) {
                    formed--;
                }

                low++;
            }
        }

        return res == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + res);
    }
}
