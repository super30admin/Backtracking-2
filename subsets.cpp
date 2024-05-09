// Time O(n*2^n)
// Space O(n)
// Leetcode : yes
// Issue seen: none

class Solution {
public:
    void helper(vector<int>& nums, int i, vector<int>& slate, vector<vector<int>>& ans) {
        if (i == nums.size()) {
            ans.push_back(slate);
            return;
        }
        // include the number
        slate.push_back(nums[i]);
        helper(nums, i + 1, slate, ans);
        slate.pop_back();

        // do not include the number
        helper(nums, i + 1, slate, ans);
    }

    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> slate;
        helper(nums, 0, slate, ans);
        return ans;
    }
};
