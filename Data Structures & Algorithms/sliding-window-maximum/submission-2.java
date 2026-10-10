//import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int[] res = new int[n - k + 1];
        int idx = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        for (int high = 0; high < n; high++) {

            // 1. If window size exceeds k, increase low
            if (high - low + 1 > k) {
                low++;
            }

            // 2. Remove indices outside the window
            while (!dq.isEmpty() && dq.peekFirst() < low) {
                dq.pollFirst();
            }

            // 3. Remove smaller elements from the back
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] < nums[high]) {
                dq.pollLast();
            }

            // 4. Include high
            dq.offerLast(high);

            // 5. Store maximum when window size is k
            if (high - low + 1 == k) {
                res[idx++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}