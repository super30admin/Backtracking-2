#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>>ans;
        vector<int>path;
        helper(nums,0,path,ans);
        return ans;
    }
    void helper(vector<int>&nums,int idx,vector<int>path,vector<vector<int>>&result){
        if(idx ==  nums.size())
        {
            result.push_back(path);
            return;
        }
        helper(nums,idx+1,path,result);
        path.push_back(nums[idx]);
        helper(nums,idx+1,path,result);
        path.pop_back();
    }
};