//Time Complexity : O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    void backtrack(vector<int>& nums, vector<int> list, vector<vector<int>> &res, int idx){
        
        res.push_back(list);

        for(int i=idx; i<nums.size();i++){
            //action
            list.push_back(nums[i]);
            //recurse
            backtrack(nums, list, res, i+1);
            //backtrack
            list.pop_back();
        }

    }
    
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> list;
        if(nums.size()==0) return res;
        backtrack(nums, list, res, 0);
        return res;
    }
};