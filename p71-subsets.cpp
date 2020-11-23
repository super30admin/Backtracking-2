// Using BackTracking
// Time complexity is O(4^n) exponential time complexity where n is length of the string
// Space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
public:
    vector<vector<int>> res;
    void helper(vector<int>& nums, vector<int>& temp, int index) {
        //base
        if(index == nums.size()) return;
        
        //logic
        for(int i = index; i < nums.size(); i++) {
            //action
            temp.push_back(nums[i]);
            res.push_back(temp);
            //recurse
            helper(nums, temp, i+1);
            //backtrack
            temp.pop_back();
        }
    }
    
    vector<vector<int>> subsets(vector<int>& nums) {
        if(nums.size() == 0) return {};
        vector<int> temp;
        res.push_back({});
        helper(nums, temp, 0);
        return res;
    }
};

// Using Recursion
class Solution {
public:
    vector<vector<int>> res;
    void helper(vector<int>& nums, vector<int> temp, int index) {
        //base
        if(index == nums.size()) {
            res.push_back(temp);
            return;
        }
        //logic
        //Don't choose
        helper(nums, temp, index+1);
        //Choose
        temp.push_back(nums[index]);
        helper(nums, temp, index+1);
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        if(nums.size() == 0) return {};
        vector<int> temp;
        helper(nums, temp, 0);
        return res;
    }
};
