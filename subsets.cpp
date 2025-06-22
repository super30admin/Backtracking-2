// Time Complexity (TC):O(2^n * n)
// 2^n subsets are generated for an array of size n.
// Each subset takes up to O(n) time to construct (due to copying path into res).

// Space Complexity (SC):
// O(n) (auxiliary) + O(2^n * n) (output)
// O(n) space is used in the recursion stack and path.
// The result res holds all 2^n subsets, each of size up to n.



class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> path={};
        helper(nums,0,res,path);
        return res;
    }
    void helper(vector<int>& nums,int pivot,vector<vector<int>> &res, vector<int>& path){
        
        res.push_back(path);
            
        for(int i = pivot; i< nums.size();++i){
            path.emplace_back(nums[i]);
            helper(nums,i+1,res,path);
            path.pop_back();
        }
    }
};
