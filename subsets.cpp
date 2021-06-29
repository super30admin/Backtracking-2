// Time Complexity : O(2^n)
// Space Complexity :  O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
private:
    // Return Vector
    vector<vector<int>> powerset;
    
    // Recursive function to find the subsets
    void subset_rec(vector<int> &nums, int idx, vector<int> set)
    {
        if(idx == nums.size())
            return;
        
        set.push_back(nums[idx]);
        
        powerset.push_back(set);
        
        for(int j = idx+1; j < nums.size(); j++)
            subset_rec(nums, j, set);
    }
    
    
public:
    // Primary Function
    vector<vector<int>> subsets(vector<int>& nums) {
        
        vector<int> empty_set;
        powerset.push_back(empty_set);
        
        for(int i = 0; i < nums.size(); i++)
            subset_rec(nums, i, empty_set);
        
        return powerset;
    }
};