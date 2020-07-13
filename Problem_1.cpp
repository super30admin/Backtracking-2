class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> tmp;
        backtrack(nums,tmp,result, 0);
        return result;
    }
    void backtrack(vector<int>& nums, vector<int>temp ,vector<vector<int>>& result,int index){
        vector<int>v2(temp);
        result.push_back(v2);
        for(int i = index; i<nums.size();i++){
            temp.push_back(nums[i]);
            backtrack(nums,temp,result,i+1);
            temp.pop_back();
        }
    }
};