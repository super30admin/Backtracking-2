class Solution {
     vector<vector<int>> result;
public:
    vector<vector<int>> subsets(vector<int>& nums) 
    {
       vector<int> temp;
       helper(nums, temp , 0);

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
        
        helper(nums,path  , i+1);
        path.pop_back();
        
        //dont choose
        helper(nums, path, i+1 );

    }
};