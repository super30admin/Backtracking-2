// Time Complexity : O(n*2^n)
// Space Complexity : O(h) = O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Start at idx 0 and at every recursive call, add the path to the result
// Start the for loop from the pivot and add the element at idx to path and recurse
// After the recursive call, backtrack the last element added 

class Solution {
private:
    void helper(vector<int>& nums, int idx, vector<int>& path, vector<vector<int>>& res) {
        res.push_back(path);
        for(int i=idx; i<nums.size(); i++) {
            path.push_back(nums[i]);
            helper(nums, i+1, path, res);
            path.pop_back();
        }
    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> path;
        vector<vector<int>> res;
        helper(nums, 0, path, res);
        return res;
    }
};