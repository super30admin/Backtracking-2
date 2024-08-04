//time: O(2^n)
//space: O(n)
class Solution {
    void helper(vector<int>& nums, vector<vector<int>>& result, vector<int>& path, int idx) {
        //base
        if(idx >= nums.size()) {
            result.push_back(path);
            return;
        }
        //logic
        path.push_back(nums[idx]);
        helper(nums, result, path, idx+1);
        path.pop_back();
        helper(nums, result, path, idx+1);
    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> path;
        helper(nums, result, path, 0);
        return result;
    }
};