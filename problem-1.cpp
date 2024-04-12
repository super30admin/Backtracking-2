// 78. Subsets
// Time Complexity : O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
public:
    void subsets(int i,vector<int> &nums,vector<int> &ds,vector<vector<int>> &ans){
        if(i==nums.size())
        {
            ans.push_back(ds);
            return;
        }
        ds.push_back(nums[i]);
        subsets(i+1,nums,ds,ans);
        ds.pop_back();
        subsets(i+1,nums,ds,ans);
    }
    void subsetsfor(int ind,vector<int> &nums,vector<int> &ds,vector<vector<int>> &ans){
        if(ind == nums.size())
        {
            ans.push_back(ds);
            return;
        }
        for(int i = ind; i < nums.size(); i++)
        {
            ds.push_back(nums[i]);
            subsets(i+1,nums,ds,ans);
            ds.pop_back();
        }
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> ds = {};
        ans.push_back(ds);
        subsetsfor(0,nums,ds,ans);
        return ans;
    }
};
