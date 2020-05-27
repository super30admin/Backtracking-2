//Time Complexity - O(2^n * n)
//Space Complexity - O(2^n) and O(n)
//Ran successfuly on leetcode

class Solution {
public:
    vector<vector<int>>result;
    vector<vector<int>> subsets(vector<int>&nums) {
        if(nums.empty())
            return {};
        vector<int>temp;
        backtrack(nums,temp,0);
        return result;        
    }
    void backtrack(vector<int>&nums,vector<int>&temp,int index)
    {
        //base
        //logic i.e. iterate with the pivot
        result.push_back(temp);
        for(int i=index;i<nums.size();i++)
        {
            //action
            temp.push_back(nums[i]);
            //recurse
            backtrack(nums,temp,i+1);
            //backtrack
            temp.pop_back();
        }
    }
    /*vector<vector<int>>result;
    vector<vector<int>> subsets(vector<int>&nums) {
        if(nums.empty())
            return {};
        vector<int>temp;
        recurse(nums,temp,0);
        return result;        
    }
    void recurse(vector<int>&nums,vector<int>temp,int index)
    {
        //base
        if(index==nums.size())
        {
            result.push_back(temp);
            return;
        }
        //dont choose
        recurse(nums,temp,index+1);
        //choose
        temp.push_back(nums[index]);
        recurse(nums,temp,index+1);
    }*/
};