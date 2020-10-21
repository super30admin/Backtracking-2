class Solution {
public:
    void dfs(vector<vector<int>>& subset,int index,vector<int>& nums,vector<int>& curr) {
        subset.push_back(curr);//subset.push_back(curr);
        for (int i=index;i<nums.size();i++) {
            curr.push_back(nums[i]);
            dfs(subset,i+1,nums,curr);
            curr.pop_back();
        }
    }
     vector<vector<int>> subsets(vector<int>& nums) {

        vector<vector<int>> subset;
        vector<int> curr;
        dfs(subset, 0, nums, curr);
        return subset;
    }
};