/*

// Time Complexity : n * 2^n
// Space Complexity : n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Generate the binary digits from 0 to n and use them as flags to use the nums present

*/

#include<iostream>
#include<vector>

using namespace std;

class Solution {
    vector<vector<int>> res;
    void dfs(vector<int>& nums,int x,int level,vector<int>& sol,int n){
        if(level > n){
            vector<int> sol_push{};
            for(int i{};i<n;++i){
                if(sol.at(i)==1) sol_push.push_back(nums.at(i));
            }
            res.push_back(sol_push);
            return;
        }
        // choose left child
        sol.push_back(0);
        dfs(nums,0,level+1,sol,n);
        sol.pop_back();
        sol.push_back(1);
        dfs(nums,1,level+1,sol,n);
        sol.pop_back();
    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        int n = nums.size();
        vector<int> sol;
        int level{1};
        dfs(nums,0,level,sol,n);
        return res;
    }
};

// another recursive solution

class Solution_2 {
    vector<vector<int>> res{};
    void help(vector<int>& nums,int level,vector<int>& sol){
        if(level == nums.size()){
            res.push_back(vector<int>(sol));
            return;
        }

        //not choose;
        help(nums,level+1,sol);
        //choose
        sol.push_back(nums.at(level));
        help(nums,level+1,sol);
        sol.pop_back();
    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> sol{};
        help(nums,0,sol);
        return res;
    }
};

//solution using for loop, here you are taking every node generated as the solution for the combination

class Solution_3 {
    vector<vector<int>> res;
    void helper(vector<int>& nums, int pivot,vector<int>& sol){
        // not choosing 
        res.push_back(vector<int> (sol));
        for(int i{pivot};i<nums.size();++i){
            sol.push_back(nums.at(i));
            helper(nums,i+1,sol);
            sol.pop_back();
        }
    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> sol{};
        helper(nums,0,sol);
        return res;
    }
};

// this for loop solution includes a repeated problem where left and right subtrees are equal.

class Solution_4 {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res{{}};
        for(int& n:nums){
            int sz = res.size();
            for(int i{};i<sz;++i){
                vector<int> sol_push(res.at(i));
                sol_push.push_back(n);
                res.push_back(sol_push);
            }
        }
        return res;
    }
};

