// Time Complexity : O(2^n * n) --> O(2^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result = {{}};
        //for each list in result add the element in every iteration
        for(int i = 0; i < nums.size(); i++){
            int size = result.size();
            for(int j = 0; j < size; j++){
                vector<int> li(result[j]);
                li.push_back(nums[i]);
                result.push_back(li);
            }
        }
        return result;
    }
};