//Time  - O(n*2^n)
//Space - O(n)

class Solution {
public:
    vector<vector<int>> ans;
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> temp;
        findSubsets(temp,nums,0);
        return ans;
    }
    
    void findSubsets(vector<int>& temp, vector<int>& nums, int k){
        
        ans.push_back(temp);
        
        for(int i=k;i<nums.size();i++){
            temp.push_back(nums[i]);
            findSubsets(temp,nums,i+1);
            temp.pop_back();
        }
    }
};