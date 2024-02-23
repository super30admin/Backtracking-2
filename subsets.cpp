// TC = O(2 ^ N)
// SC = O(2 ^ N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// class Solution {
// public:
//     // non recursive
//     // TC = O(2^N)
//     // SC = O(2^N)
//     vector<vector<int>> subsets(vector<int>& nums) {
//         vector<vector<int>> result;
//         result.push_back(vector<int>());
//         for(int i = 0; i < nums.size(); i++) {
//             int size = result.size();
//             for(int j = 0; j < size; j++) {
//                 vector<int> temp(result[j]);
//                 temp.push_back(nums[i]);
//                 result.push_back(temp);
//             }
//         }
//         return result;
//     }
// };

// recursive backtrack
    // TC = O(2^N)
    // SC = O(2^N)
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> path;
        helper(nums, 0, path);
        return result;
    }
    void helper(vector<int>& nums, int index, vector<int>& path) {
        // base
        if(index == nums.size()) {
            result.push_back(vector<int>(path));
            return;
        }
        // recurse
        // no choose
        helper(nums, index + 1, path);
        // choose
        path.push_back(nums[index]); // action
        helper(nums, index + 1, path); // recurse
        path.resize(path.size() - 1); // backtrack
    }
};