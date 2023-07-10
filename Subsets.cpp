//Time Complexity: O(2^n)
//Space Complexity: O(2^n)
class Solution {
public:
    vector<vector<int>> result; 
    vector<vector<int>> subsets(vector<int>& nums) {    
        vector<int> res; 
        createSubsets(nums, 0, res);
        return result;        
    }

    void createSubsets(vector<int>& nums, int index, vector<int>& res) {
            if(index == nums.size()) {
                result.push_back(res);
                return; 
            }

            createSubsets(nums, index+1, res);
            res.push_back(nums[index]);
            createSubsets(nums, index+1, res);
            res.pop_back(); 
    }
};