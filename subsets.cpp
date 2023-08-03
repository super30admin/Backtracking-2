class Solution {
    vector<vector<int>> result;

public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> m;

        helper(nums,0,m);
        return result;

        
    }

    void helper(vector<int> &nums, int i, vector<int> path){

        if(i==nums.size()){
            vector<int> p = path;
            result.push_back(p);
            return;
        }


        //choose
        
        path.push_back(nums[i]);
        helper(nums,i+1,path);
        path.pop_back();
        helper(nums,i+1,path);


    }
};