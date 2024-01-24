// Time Complexity : O(2^n) where n - nums size

// Space Complexity : O(N) - recursion stack space

// Did this code successfully run on Leetcode : YES

// Appoarch: Recursion + Backtracking - for loop based recursion

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:

void helper(vector<int> nums, int pivot, vector<int>& path, vector<vector<int>>& res){
        res.push_back(path);
        for(int i=pivot;i<nums.size();i++){
            path.push_back(nums[i]);
            helper(nums,i+1,path,res);
            path.pop_back();
        }
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> path;
        helper(nums,0,path,res);
        return res;
    }
};