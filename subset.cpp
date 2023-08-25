class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        int n = nums.size();

        vector<int> path;
        vector<vector<int> > ans;


        backtrack(nums,0,path,ans);    
        return ans;
    
    }

    void backtrack(vector<int>& nums,int idx,vector<int> &path,  vector<vector<int> > &ans){


        

        if(idx == nums.size()){
            ans.push_back(path);
            return;
        }
        backtrack(nums,idx+1,path,ans);
        path.push_back(nums[idx]);
        backtrack(nums,idx+1,path,ans);
        path.pop_back();

    }
};