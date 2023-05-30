// TC:O(N*2^N) N is for copying ecah subset into result vector
// SC:O(N)
// 
// In this I choose/not choose recursion to generate all possible subsets
// By traversing along the array we have a choice of choose or not choose an element


class Solution {
public:
    vector<vector<int>>results;
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int>ans;
        rec(nums,0,ans);
        return results;   
    }

    void rec(vector<int>& nums,int idx,vector<int>&ans)
    {

        // base
        if(idx>=nums.size())
        {
            results.push_back(ans);
            return;
        }

       

        // logic

        // not choose
        rec(nums,idx+1,ans);
        
        // choose

        // ACTION
        ans.push_back(nums[idx]);
        // RECURSE
        rec(nums,idx+1,ans);
        // BACKTRACK
        ans.pop_back();
    }
};