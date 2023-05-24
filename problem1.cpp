// Time Complexity : O(2^n)
// Space Complexity : O(n) for recurrsive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// pick or dont pick type recurrsive backtracking approach

class Solution {
public:
    vector<vector<int>>result;
    vector<vector<int>> subsets(vector<int>& nums) {
        if(nums.empty() || nums.size()==0) return {};
        vector<int>curr;
        dfs(nums,curr,0);
        return result;
    }
    void dfs(vector<int>& nums,vector<int>&curr,int index )
    {
        if(index==nums.size()){
            result.push_back(curr);
            return;
        }
        
        dfs(nums,curr,index+1);
        
        curr.push_back(nums[index]);
        dfs(nums,curr,index+1);
        curr.pop_back();
    }
};

//For loop based recurrsive backtracking approach

class Solution {
public:
    vector<vector<int>>result;
    vector<vector<int>> subsets(vector<int>& nums) {
        if(nums.empty() || nums.size()==0) return {};
        vector<int>curr;
        dfs(nums,curr,0);
        return result;
    }
    void dfs(vector<int>&nums, vector<int>&curr,int index)
    {
        result.push_back(curr);
        for(int i = index;i<nums.size();i++)
        {
            curr.push_back(nums[i]);
            dfs(nums,curr,i+1);
            curr.pop_back();
        }
    }
};