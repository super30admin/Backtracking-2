class Solution {
public:
    vector<vector<int>> answer;
    void backtrack(vector<int> temp, vector<int>& nums, int index) {
        answer.push_back(temp);
        
        if (index == nums.size()) {
            return;
        }

        for (int i=index;i<nums.size();i++) {
            temp.push_back(nums[i]);
            backtrack(temp, nums, i+1);
            temp.pop_back();
        }
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> temp;
        backtrack(temp, nums, 0);
        return answer;
    }
};
