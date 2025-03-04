// Time Complexity: O(2^n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

//Approach: 
//1. For loop based recursion
//2. For each element, we have 2 choices - either include it in the subset or not include it.
//3. We will make a choice and recurse on the next element.
//4. We will backtrack and remove the element from the subset and make the other choice.
//5. We will keep doing this until we reach the end of the array.

class Solution {
    vector<vector<int>> result; 
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        helper(nums, 0, vector<int>());
        return result; 
    }
private: 
    void helper(vector<int>& nums, int pivot, vector<int> path){
        // base case
        result.push_back(path);
        //logic
        //action
        for(int i = pivot; i < nums.size(); i++){
            path.push_back(nums[i]);
            //recurse
            helper(nums, i+1, path);
            //backtrack
            path.pop_back();
        }
        
    }
};