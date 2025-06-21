//The find function uses recursion and backtracking by deciding at each index whether to include nums[index] in the current subset (ds) or skip it, exploring both branches. When the index reaches the end (index >= n), the current subset is pushed into the result list, and the recursion unwinds.
//Time complexity: O(2^n)
//Space complexity: O(n)

class Solution {
public:

    void find(int index, int &n, vector<vector<int>>&ans, vector<int> &ds, vector<int>&nums)
    {
        if(index>=n){
            ans.push_back(ds);
            return;
        }
        ds.push_back(nums[index]);
        find(index+1,n,ans,ds,nums);
        ds.pop_back();
        find(index+1,n,ans,ds,nums);
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> ds;
        int index=0;
        int n=nums.size();
        find(index,n,ans,ds,nums);
        return ans;
    }
};