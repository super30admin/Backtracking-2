//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;


class Solution {
public:
    vector<vector<int> > result;
    vector<vector<int> > subsets(vector<int>& nums) {
        vector<int> path;
        
        helper(nums,0,path);
        return result;
    }
    
    void helper(vector<int>& nums,int index,vector<int> path)
    {
        
        //logic
        result.push_back(path);
        for(int i=index;i<nums.size();i++)
        {
            path.push_back(nums[i]);
            helper(nums,i+1,path);
            path.pop_back();
        }
    }
};