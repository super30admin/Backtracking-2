// Time Complexity : O(2^n) where n = size of i/p
// Space Complexity : O(n) where n = size of i/p
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* Perform exhaustive search. Store the current path to results and call the recursive method on all the remaining elements of i/p vector.
 * Pass the path vector by adding current element to path vector and remove the element from path vector after call to helper method returns.
 */

class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        if (nums.size() == 0)
            return result;

        vector<int> path;
        helper(nums, 0, path);

        return result;
    }

    void helper(vector<int>& nums, int index, vector<int>& path)
    {
        result.push_back(path);    
        
        for (int i = index; i < nums.size(); i++)
        {
            path.push_back(nums[i]);
            helper(nums, i + 1, path);
            path.pop_back();
        }
    }
};