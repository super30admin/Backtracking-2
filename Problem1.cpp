// Time Complexity : O(2 ^ n)
// Space Complexity : O(N)
class Solution {
public:
    vector<vector<int>> res;
    void helper(vector<int>& nums, int pivot,vector<int> path ){
        res.push_back(path);
        for(int i=pivot; i<nums.size(); i++){
            path.push_back(nums[i]);
            helper(nums, i+1, path);
            path.pop_back();
        }
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> path;
        helper(nums, 0, path);
        return res;
    }
};