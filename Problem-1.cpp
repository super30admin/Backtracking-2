// https://leetcode.com/problems/subsets/description/
// Time Complexity : O(2^n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public:
        void helper(vector<int>& nums, int idx, vector<vector<int>> &ans, vector<int> &path){
            if(idx == nums.size()){
                ans.push_back(path);
                return;
            }
            path.push_back(nums[idx]);
            helper(nums, idx+1, ans, path);
            path.pop_back();
    
            helper(nums, idx+1, ans, path);
        }
        vector<vector<int>> subsets(vector<int>& nums) {
            vector<vector<int>> ans;
            vector<int> path;
            helper(nums, 0, ans, path);
            return ans;
        }
    };


// for loop based recursion

class Solution {
    public:
        void helper(vector<int>& nums, int pivot, vector<vector<int>> &ans, vector<int> &path){
            ans.push_back(path);
            for(int i=pivot; i<nums.size(); i++){
                path.push_back(nums[i]);
                helper(nums, i+1, ans, path);
                path.pop_back();
            }
            
        }
        vector<vector<int>> subsets(vector<int>& nums) {
            vector<vector<int>> ans;
            vector<int> path;
            helper(nums, 0, ans, path);
            return ans;
        }
    };

// Nested for loop

class Solution {
    public:
        vector<vector<int>> subsets(vector<int>& nums) {
            vector<vector<int>> ans = {{}};
            for(int i=0; i<nums.size(); i++){
                int s = ans.size();
                for(int j=0; j<s; j++){
                    vector<int> res = ans[j];
                    res.push_back(nums[i]);
                    ans.push_back(res);
                }
            }
            return ans;
        }
    };