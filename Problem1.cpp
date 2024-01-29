class Solution {
public:
void helper(vector<vector<int>> &res, vector<int> &temp, const vector<int> &nums, int idx) {
        res.push_back(temp);
        for (int i = idx; i < nums.size(); ++i) {
            temp.push_back(nums[i]);
            helper(res, temp, nums, i + 1);
            temp.pop_back();
        }
    }
    vector<vector<int>> subsets(vector<int>& nums) {
         vector<vector<int>> res;
        vector<int> temp;
        helper(res, temp, nums, 0);
        return res;
    }
};