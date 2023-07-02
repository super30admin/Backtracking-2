// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        helper(nums, 0, {}, result);
        return result;
    }
    void helper(vector<int>& nums, int idx, vector<int>&& path, vector<vector<int>>& result){
        //base
        if(nums.size() == 0) return;
        if(idx == nums.size()){
            result.push_back(path); 
            return;   
        }
        //logic
        //not choose
        helper(nums, idx + 1, move(path), result);

        //choose
        //action
        path.push_back(nums[idx]);
        //recurse
        helper(nums, idx + 1, move(path), result);
        //backtrack
        path.pop_back();
    }
};