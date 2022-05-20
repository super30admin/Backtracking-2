// Time Complexity : O(2^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* Insert empty vector as a first element in results vector.
 * Iterate over each elements of i/p vector by performing following operations.
 *      Iterate over the results vector and create a new result elements by appending current i/p vector element to each result vectors.
 */

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        
        if (nums.size() == 0)
            return result;
        
        vector<int> path;
        result.push_back(path);
        
        for (int i = 0; i < nums.size(); i++)
        {
            int size = result.size();
            
            for (int j = 0; j < size; j++)
            {
                path = result[j];
                path.push_back(nums[i]);
                result.push_back(path);
            }
        }
    
        return result;
    }
    
};