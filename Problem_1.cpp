// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Subsets
// Approach: Backtracking
// TC: O(2^N)
// SC: O(N)

class Solution
{
public:
    vector<vector<int>> result;

    vector<vector<int>> subsets(vector<int> &nums)
    {
        if (nums.empty())
        {
            return result;
        }
        vector<int> path;
        recurse(nums, 0, path);
        return result;
    }

    void recurse(vector<int> &nums, int index, vector<int> &path)
    {
        // Add current subset to result
        result.push_back(path);

        for (int i = index; i < nums.size(); i++)
        {
            path.push_back(nums[i]);
            recurse(nums, i + 1, path);
            path.pop_back();
        }
    }
};
