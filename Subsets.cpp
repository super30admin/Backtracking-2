// Apporach 1 : DFS without backtracking
// Time Complexity : 2^n * n
//                   ..... 2^n because of making two choices at each element
//                   ..... * n for copying elements in new vector in each call
// Space Complexity : O(n * n)
//                   ...... O(n) for copying all elements everytime
//                   ...... O(n) for call stack
//
// Apporach 2 : DFS with backtracking
// Time Complexity : 2^n
//                   ..... 2^n because of making two choices at each element
// Space Complexity : O(n)
//                   ...... O(n) for call stack
//
// Apporach 3 : Using for loop with backtracking
// Time Complexity : 2^n
//                   ..... 2^n because of making two choices at each element
// Space Complexity : O(n)
//                   ...... O(n) for call stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
/*
Leetcode : https://leetcode.com/problems/subsets/description/
Given an integer array nums of unique elements, return all possible subsets.
The solution set must not contain duplicate subsets. Return the solution in any order.
*/


/**
 * Approach 1 : without backtracking
 * 
 * Here copy of path vector is getting created for each recursive call.
 * This is also called as deep copy. This is not efficient method in terms of space utilization 
 * as its creating copy evrytime.
 * 
*/

class Solution {
    vector<vector<int>>result;
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int>path;
        dfs(nums, 0, path);

        return result;
    }

    void dfs (vector<int>& nums, int idx, vector<int>path){
        if(idx == nums.size()){
            result.push_back(path);
            return;
        }
        
        // do not select 
        dfs(nums, idx+1, path);
        // select
        path.push_back(nums[idx]);
        dfs(nums, idx+1, path);

    }
};


/**
 * Approach 2 : with backtracking
 * 
 * This will save space as we are creating copy only when result is found.
 * 
*/

class Solution {
    vector<vector<int>>result;
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int>path;
        dfs(nums, 0, path);

        return result;
    }

    void dfs (vector<int>& nums, int idx, vector<int>&path){
        if(idx == nums.size()){
            vector<int>storage(path.begin(), path.end());
            result.push_back(path);
            return;
        }
        
        // do not select 
        dfs(nums, idx+1, path);
        // select
        path.push_back(nums[idx]);
        dfs(nums, idx+1, path);
        //back tracking
        path.pop_back();
    }
};



/**
 * Approach 3 : Using for loop with backtracking
 * 
 * This will save space as we are creating copy only when result is found.
 * 
*/


class Solution {
    vector<vector<int>>result;
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int>path;
        dfs(nums, 0, path);

        return result;
    }

    void dfs (vector<int>& nums, int pivot, vector<int>&path){

        vector<int>storage(path.begin(), path.end());
        result.push_back(path);

        for(int k = pivot; k < nums.size(); k++){

            path.push_back(nums[k]);
            dfs(nums, k+1, path);
            //back tracking
            path.pop_back();
        }
    }
};