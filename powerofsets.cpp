// Time Complexity : O(2^N) N- number of elements in given array
// Space Complexity :recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Code in C++


class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> temp;
        //Edge case
        if(nums.size()==0)
            return{};
        
        backprop(nums,result,temp,0);
        return result; 
    }


private:
void backprop(vector<int>& nums,vector<vector<int>> &result,vector<int> &temp,int index)
{
    //base case
    
    if(index>nums.size())
        return;
    
    //Logic
    result.push_back(temp);//add running list into result after every element removal 
    for(int i=index;i<nums.size();i++)//run through entire  list
    {
        temp.push_back(nums[i]);//push every element into running list
        backprop(nums,result,temp,i+1);
        temp.pop_back();
    }
}
    
};