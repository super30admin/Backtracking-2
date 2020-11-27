//Time complexity: O(2^n) --> For n elements in input array, the subset is 2^n
//Space complexity: O(n) --> Ommitting the result array (which is O(n^2)) we create a temp array for checking the combination of inputs
//Accepted in Leetcode: Yes

//Approach:

/* 
1. Create a helper method which adds elements to the output array. 
2. Recursively traverse the array and backtrack at each exit point 
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution{
    
    public:
        vector<vector<int>>subsets(vector<int>&nums)
        {
            vector<vector<int>>result;
            vector<int>temp;

            setfinder(nums, result, temp, 0); 
            return result;
        } 

        void setfinder(vector<int>&nums, vector<vector<int>>&result, vector<int>&temp, int index)
        {
            result.push_back(temp); //add this first to handle empty set case

            int i = index;

            while(i <nums.size()) 
            {
                temp.push_back(nums[i]);
                setfinder(nums, result, temp, i+1); //recursively traverse till end of the input for every iteration
                temp.pop_back(); //remove the element from temp list on every iteration
                i++;
            }
        }
};