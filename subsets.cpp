//time complexity:O(n*2^n)
//space complexity:O(n*2^n)
//executed on leetcode: yes
//approach:using backtracking
//any issues faced? no

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>>res;
        vector<int>curr;
        dfs(nums,res,0,curr);
        return res;
    }
    void dfs(vector<int>& nums, vector<vector<int>>&res, int index, vector<int>& curr)
    {
        res.push_back(curr);
        for(int i=index; i<nums.size(); i++)
        {
            curr.push_back(nums[i]);
            dfs(nums,res,i+1,curr);
            curr.pop_back();
        }
    }
};