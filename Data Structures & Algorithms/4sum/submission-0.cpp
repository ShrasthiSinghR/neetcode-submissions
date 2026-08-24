class Solution {
public:

    vector<vector<int>> fourSum(vector<int>& nums, int target) {

        sort(nums.begin(), nums.end());

        vector<vector<int>> res;

        int n = nums.size();

        for (int f = 0; f < n - 3; f++) {

            // Skip duplicate first numbers
            if (f > 0 && nums[f] == nums[f - 1])
                continue;

            for (int s = f + 1; s < n - 2; s++) {

                // Skip duplicate second numbers
                if (s > f + 1 && nums[s] == nums[s - 1])
                    continue;

                int i = s + 1;
                int j = n - 1;

                while (i < j) {

                    long long sum = (long long)nums[f]
                                  + nums[s]
                                  + nums[i]
                                  + nums[j];

                    if (sum < target) {
                        i++;
                    }
                    else if (sum > target) {
                        j--;
                    }
                    else {

                        res.push_back({
                            nums[f],
                            nums[s],
                            nums[i],
                            nums[j]
                        });

                        i++;
                        j--;

                        // Skip duplicate i
                        while (i < j && nums[i] == nums[i - 1])
                            i++;

                        // Skip duplicate j
                        while (i < j && nums[j] == nums[j + 1])
                            j--;
                    }
                }
            }
        }

        return res;
    }
};