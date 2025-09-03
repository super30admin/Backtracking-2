#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use a rescursive fucntion helper to put each number into a vector and push that 
vector into the result matrix and return the result
*/
class Solution{
public:
    vector<vector<int>> result;
    vector<vector<int>> subset(vector<int>& nums){
        vector<int> path;
        helper(nums, 0, path);
        return result;
    }
private:
    void helper(vector<int>& nums, int pivot, vector<int>& path){
        result.push_back(path);
        for(int i=pivot; i<nums.size(); i++){
            path.push_back(nums[i]);
            helper(nums, i+1, path);
            path.pop_back();
        }
    }
};
