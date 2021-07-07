// Recursive solution

// Time Complexity : O(2^n); 
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Call recursive function starting with index = 0 of nums 
// 2. At every index, we first call the recursive function without including the index and then by including it
// 3. The base condition is when the index is equal to array size, then place the subset in the result and return 

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> subset;
        if(!nums.size())
            return result;
        helper(nums, subset, result, 0);
        return result;
    }
    
    void helper(vector<int> nums, vector<int> subset, vector<vector<int>>& result, int index){
        // base
        if(index==nums.size()){
            result.emplace_back(subset);
            return;
        }
        //logic
        // don't choose element at index
        helper(nums, subset, result, index+1);
        // choose element at index
        subset.emplace_back(nums[index]);
        helper(nums, subset, result, index+1);
    }            
};


// Backtracking solution
// Time Complexity : O(2^n); 
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Iterate through nums array from index to end and place element at index in subset (subset passed as reference)
// 2. Call backtrack function for next index and once function returns remove last added element from array

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> subset;
        result.emplace_back(subset);
        if(!nums.size())
            return result;
        backtrack(nums, subset, result, 0);
        return result;
    }
    
    void backtrack(vector<int> nums, vector<int>& subset, vector<vector<int>>& result, int index){
        // base
            // no base condition as index is already checked in the for loop
                
        //logic
        for(int i=index;i<nums.size();i++){
        //action
            subset.emplace_back(nums[i]); 
            result.emplace_back(subset);
        //recurse
            backtrack(nums, subset, result, i+1);
        //backtrack
            subset.pop_back();
            
        }            
    }
};