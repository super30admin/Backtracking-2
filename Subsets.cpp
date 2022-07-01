//Time Complexity- O(2^n)
//Space Complexity- O(n)

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        
        vector<int> temp;
        vector<vector<int>> ans;
        helper(nums,temp,ans);
        
        return ans;
    }
    
    void helper(vector<int> nums,vector<int> temp,vector<vector<int>> &ans){
        if(nums.size()==0){
            ans.push_back(temp);
            return;
        }
        vector<int> op1=temp;
        vector<int> op2=temp;
        op1.push_back(nums[0]);
        nums.erase(nums.begin()+0);
        helper(nums,op1,ans);
        helper(nums,op2,ans);
    }
};