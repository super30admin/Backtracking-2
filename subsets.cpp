class Solution {
     vector<vector<int>> result;
public:
    vector<vector<int>> subsets(vector<int>& nums) 
    {
       
       helper(nums,  vector<int> path, 0);

       return result; 
    }

    private:
    void helper(vector<int>& nums,vector<int> path, int i )
    {
        //base
        if( i == nums.size())
        {
            result.push_back(path);
            return;
        }      

        //choose
        path.push_back(nums[i]);
        helper(nums,  vector<int> path, i+1);
        path.remove(path.size() - 1);
        
        //dont choose
        helper(nums, vector<int> path, i+1 );

    }
};