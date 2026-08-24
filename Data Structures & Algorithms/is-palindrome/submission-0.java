class Solution {
    public boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while(i < j)
        {
            // Skip non-alphanumeric from left
            while(i < j && !Character.isLetterOrDigit(s.charAt(i)))
            {
                i++;
            }

            // Skip non-alphanumeric from right
            while(i < j && !Character.isLetterOrDigit(s.charAt(j)))
            {
                j--;
            }

            char l = Character.toLowerCase(s.charAt(i));
            char r = Character.toLowerCase(s.charAt(j));

            if(l != r)
            {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
