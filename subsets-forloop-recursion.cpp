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
        // vector<int> path;
        helper(nums, 0, {}, result);
        return result;
    }
    void helper(vector<int>& nums, int pivot, vector<int>&& path, vector<vector<int>>& result){
        //base
        if(nums.size() == 0) return;
        // if(pivot == nums.size()) return;

        //logic
        result.push_back(path);
        for(int i = pivot; i < nums.size(); i++){
            //action
            // without back tracking
            // vector<int> li(path);
            // li.push_back(nums[i]);
            path.push_back(nums[i]);
            //recurse
            helper(nums, i + 1, move(path), result);
            //backtrack
            path.pop_back();
        }
    }
};