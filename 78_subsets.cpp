// Time Complexity : exponential n*2^n
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//without recursion
class Solution {
public:
    
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        if(nums.empty() || nums.size() == 0)
            return result;
        vector<int> x;
        result.push_back(x);
        for(int num : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                vector<int> temp(result[i]);
                temp.push_back(num);
                result.push_back(temp);
            }
        }
        return result;
    }
};

//loop and backtrack
    class Solution {
    public:
        vector<vector<int>> result;
        vector<vector<int>> subsets(vector<int>& nums) {
            if(nums.empty() || nums.size() == 0)
                return result;
            vector<int> path;
            recurse(nums, 0, path);
            return result;
        }
        void recurse(vector<int>& nums, int index, vector<int> path){
            //base
            if(index == nums.size()){
                result.push_back(path);
                return;
            }
            //logic
            
            //not choose
            recurse(nums, index+1, path);
            //choose
            //action
            path.push_back(nums[index]);
            //recurse
            recurse(nums, index+1, path);
            //backtrack
            path.pop_back();
        }
    };

//recursion
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        if(nums.empty() || nums.size() == 0)
            return result;
        vector<int> path;
        recurse(nums, 0, path);
        return result;
    }
    void recurse(vector<int>& nums, int index, vector<int> path){
        //base
        if(index == nums.size()){
            result.push_back(path);
            return;
        }
        //logic
        //not choose
        recurse(nums, index+1, path);
        //choose
        path.push_back(nums[index]);
        recurse(nums, index+1, path);
    }
};
