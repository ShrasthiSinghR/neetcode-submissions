class Solution {
    public int[] getConcatenation(int[] nums) {

        int n = 2 * nums.length;
        int[] ans = new int[n];

        int i = 0;
        int j = 0;

        while(i < n)
        {
            if(j == nums.length)
            {
                j = 0;
            }

            ans[i] = nums[j];

            i++;
            j++;
        }

        return ans;
    }
}