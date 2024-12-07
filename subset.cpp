// for the given array we can find all the combinations with choose and no choose scenario
// 0 1 recursion
// if we start from no choose 

// we can have empty set and along all the possible combinations

class Solution {
    vector<vector<int>>result;
private:
    void helper(vector<int>& nums, int start, vector<int>&list)
    {
        //base case
        if(start >= nums.size() || list.size() == nums.size())
        {
            result.push_back(list);
            return;
        }

        // no choose scenario
        helper(nums, start+1,list);

        //chose
        list.push_back(nums[start]);
        helper(nums, start+1 ,list);

        // we can back track
        list.pop_back();

    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int>list;
        helper(nums,0,list);
        return result;
    }
};
//Time complexity O(2^n)
//space complexity O(N)