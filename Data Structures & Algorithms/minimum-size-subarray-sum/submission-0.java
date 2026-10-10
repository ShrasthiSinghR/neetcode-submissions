
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        for (int high = 0; high < nums.length; high++) {

            // 1. Include high
            sum += nums[high];

            // 2. Shrink while condition is valid
            while (sum >= target) {
                res = Math.min(res, high - low + 1);

                sum -= nums[low];
                low++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
