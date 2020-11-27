//
// Created by shazm on 8/6/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> retVec;
        if(nums.empty()){return retVec;}
        vector<int> path;
        dfs(nums,retVec,path,0);
        return retVec;
    }
private:
    void dfs(vector<int> nums, vector<vector<int>>& retVec, vector<int>& path, int index){
        if(index >= nums.size()){
            retVec.push_back(path);
            return;
        }

        path.push_back(nums[index]);
        dfs(nums,retVec,path,index+1);
        path.pop_back();
        dfs(nums,retVec,path,index+1);
    }
};