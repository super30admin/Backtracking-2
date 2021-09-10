//Time Complexity - O(exponential)
//Space Complexity - O(nums.size())
class Solution {
public:
    vector<vector<int>>result;
    void helper(vector<int>&nums, int idx, vector<int>&v){
        result.push_back(v);
        for(int i=idx;i<nums.size();i++){
            v.push_back(nums[i]);
            helper(nums,i+1,v);
            v.pop_back();
        }
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int>v;
        helper(nums,0,v);
        return result;
    }
};