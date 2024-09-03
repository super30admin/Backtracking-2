// time : 2^N where N is number of elements in array 
// space : o(N) where N is number of elements in array 

// for loop recursion: 
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> path;
        
        helper(nums, 0, path, result);

        return result;

    }

    void helper(vector<int>& nums, int start, vector<int> path, vector<vector<int>>& result)
    {
        result.push_back(path);
        for(int index = start; index < nums.size(); index++)
        {
            path.push_back(nums[index]);
            helper(nums, index+1, path, result);
            path.pop_back();
        }

    }
};


// for loop :
// time : N*O(2^N) (number of elements we iterate on in result array increase exponentially 2->4->8 so on)
// space : N*O(2^N) (number of elements we iterate on in result array increase exponentially 2->4->8 so on)
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> path;
        result.push_back({});
        for(int i = 0 ; i < nums.size(); i++)
        {
            int result_size = result.size();
            for (int j = 0 ; j < result_size; j++)
            {
                path = result[j];
                path.push_back(nums[i]);
                result.push_back(path);
            }
        }
        return result;

    }
    
};