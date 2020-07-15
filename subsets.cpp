// Time Complexity :O(n*2^n)  // copying plus traversal
// Space Complexity : O(n*2^n) // new array created at each level
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//1. Recursive approach is called by either choosing or not choosing that element.
//2. New elements vector is passed at each level
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        //edge case
        vector<int>elements;
        result.push_back(elements);
        if(nums.size()==0){
            return result;
        }
        //recursion
        helper(nums, elements, 0);
        return result;
    }
    //recursive 1
    void helper(vector<int>& nums, vector<int> elements, int index){
        //return condition
        if(index==nums.size()){
            return;
        }
        //choose
        elements.push_back(nums[index]);
        result.push_back(elements);
        helper(nums, elements, index+1);
        //don'tchoose
        elements.pop_back();
        helper(nums, elements, index+1);
    }
    //recursive-2
    void helper(vector<int>& nums, vector<int> elements, int index){
        //return condition
        if(index==nums.size()){
            return;
        }
        //don'tchoose
        helper(nums, elements, index+1);
        //choose
        elements.push_back(nums[index]);
        result.push_back(elements);
        helper(nums, elements, index+1);
    }
};
//Backtracing
// Time Complexity :O(n*2^n)
// Space Complexity : O(n) //stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//1. Recursive approach is called by going through all the elements
//2. No New elements vector is passed at each level

class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        //edge case
        vector<int>elements;
        result.push_back(elements);
        if(nums.size()==0){
            return result;
        }
        //recursion
        backtrack(nums, elements, 0);
        return result;
    }
    
    void backtrack(vector<int>& nums, vector<int> &elements, int index){
        //return condition
        //already taken care in for loop
        
        //logic
        for(int i = index; i<nums.size(); i++){
            //action
            elements.push_back(nums[i]);
            result.push_back(elements);
            //recursion
            backtrack(nums, elements, i+1);
            //backtrack
            elements.pop_back();
        }
    }
};

