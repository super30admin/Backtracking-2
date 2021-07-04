// Time Complexity :O(N x 2^N)
// Space Complexity : O(N) Call stack size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Subsets 

#include<vector>
#include<iostream>
using namespace std;
class Solution {
    vector<vector<int>>result;
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        if(nums.empty())
            return {};
        
        vector<int> temp;
        // call recursion 
        backtrack(nums, 0, temp);
        
        return result;
    }
    
    void backtrack(vector<int> nums, int index, vector<int>& temp){
        
        //base
        if(nums.size() == index){
            result.push_back(temp);
            return;
        }
        //not choose
        backtrack(nums, index + 1, temp);
        
        //choose
        temp.push_back(nums[index]);
        backtrack(nums, index + 1, temp);
        
        //backtrack the action
        temp.pop_back();
        
    }
};