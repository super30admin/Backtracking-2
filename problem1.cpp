// Time Complexity : O(n*(2^n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    
    void subfunc(int i, vector<int>& nums, vector<int>& temp, vector<vector<int>>& ans)
    {
        if (i==nums.size())
        {
            ans.push_back(temp);
        }
        else
        {
            temp.push_back(nums[i]);
            subfunc(i+1,nums,temp,ans);
            
            temp.pop_back();
            subfunc(i+1,nums,temp,ans);
        }
        
    }
        
    vector<vector<int>> subsets(vector<int>& nums) {
        
        vector<int> temp;
        vector<vector<int>> ans;
        subfunc(0,nums,temp,ans);
        return ans;
        
    }
};