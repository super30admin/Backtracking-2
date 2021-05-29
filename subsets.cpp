// Time Complexity :O(n*2^n) where n is the size of the vector
// Space Complexity : O(n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<vector<int>> ans;
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> subSet;
        generateSubset(0,subSet,nums);
        return ans;   
    }
    void generateSubset(int index,vector<int>&subSet,vector<int>&nums){
        ans.push_back(subSet);
        for(int i = index;i<nums.size();i++){
            subSet.push_back(nums[i]);
            generateSubset(i+1,subSet,nums);
            subSet.pop_back();
        }
    }
};