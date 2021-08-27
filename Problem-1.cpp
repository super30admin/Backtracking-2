/*
Time Complexity = Exponential
Space Complexity = Exponential
*/
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> path;
        helper(nums, 0, path);
        return result;
    }
    void helper(vector<int>& nums, int index, vector<int> path)
    {
        //base
        if(index==nums.size())
        {
            result.push_back(path);
            return;
        }
            
        //logic
        //do not choose
        helper(nums, index+1, path);
        
        //choose
        path.push_back(nums[index]);
        helper(nums, index+1, path);
    }
};

/*
Time Complexity = Exponential
Space Complexity = Exponential
*/
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> path;
        helper(nums, 0, path);
        return result;
    }
    void helper(vector<int>& nums, int index, vector<int> &path)
    {
        //base
        if(index==nums.size())
        {
            result.push_back(path);
            return;
        }
            
        //logic
        //do not choose
        helper(nums, index+1, path);
        
        //choose
        //action
        path.push_back(nums[index]);
        //recurse
        helper(nums, index+1, path);
        //backtrack
        path.pop_back();
    }
};

/*
Time Complexity = Exponential
Space Complexity = Exponential
*/
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> path;
        helper(nums, 0, path);
        return result;
    }
    void helper(vector<int>& nums, int index, vector<int> path)
    {
        //base
            result.push_back(path);
            
        //logic
        for(int i = index; i<nums.size();i++)
        {
            vector<int> copy(path);
            copy.push_back(nums[i]);
            helper(nums, i+1, copy);
        }
    }
};

/*
Time Complexity = Exponential
Space Complexity = Exponential
*/
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> path;
        helper(nums, 0, path);
        return result;
    }
    void helper(vector<int>& nums, int index, vector<int> &path)
    {
        //base
            result.push_back(path);
            
        //logic
        for(int i = index; i<nums.size();i++)
        {
            //action
            path.push_back(nums[i]);
            //recurse
            helper(nums, i+1, path);
            //backtrack
            path.pop_back();
        }
    }
};

/*
Time Complexity = Exponential
Space Complexity = Exponential
*/
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int>temp;
        result.push_back(temp);
        for(int num : nums)
        {
            int size = result.size();
            for(int i=0;i<size;i++)
            {
                vector<int>temp(result[i]);
                temp.push_back(num);
                result.push_back(temp);
            }
        }
        return result;
    }
};
