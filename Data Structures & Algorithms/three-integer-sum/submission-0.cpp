class Solution {
public:
    void twoSumHelper(int f,vector<int>& nums,vector<vector<int>>&res ) 
    {
        int i=f+1;
        int j=nums.size()-1;
        while(i<j)
        {
            int sum=nums[f]+nums[i]+nums[j];
            if(sum>0)
            {
                j--;
            }
            else if(sum<0)
            {
                i++;
            }
            else{
                res.push_back({nums[f], nums[i], nums[j]});

                i++;
                j--;

                // Skip duplicate left values
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }

                // Skip duplicate right values
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }

            }
        }
    }
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<vector<int>>res;

        for(int f=0;f<nums.size();f++)
        {
            if(nums[f]>0)
            {
                break;
            }
            if(f==0 || nums[f]!=nums[f-1])
            {
                twoSumHelper(f,nums,res);
            }
        }
        return res;

        

        
    }
};
