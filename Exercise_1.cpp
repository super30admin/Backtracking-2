/* 
    Time Complexity                              :  O(N!) since at every step the choice reduces by 1 
                                                    as no duplicates are allowed
    Space Complexity                             :  O(N) - size of the Nums array since the recursion stack
                                                    will go maximum to the number of elements in the NUms array.
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/subsets/

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        sz = nums.size();
        vector<int> lv;
        lv.clear();
        // subs3(nums, 0, lv);
        // return ans;
        
        return subs4(nums);
    }
    
private:
    vector<vector<int>> ans;
    int sz;
    
    // DP
    vector<vector<int>> subs4(vector<int>& nums) {
        
        vector<vector<vector<int>>> dp(sz+1);
        dp[0] = vector<vector<int>>(1,vector<int>());
        
        for(int i=1;i<=sz;i++) {
            vector<vector<int>> vec = dp[i-1];
            int n = nums[i-1];
            dp[i] = dp[i-1];
            for(auto v : vec) {
                v.push_back(n);
                dp[i].push_back(v);
                }
            }
        return dp[sz];
    }
    
    // backtracking
    void subs(vector<int>& nums, int ci, vector<int>& lv) {
        ans.push_back(lv);
        
        for(int i=ci;i<sz;i++) {
            lv.push_back(nums[i]);
            subs(nums,i+1,lv);
            lv.pop_back();
        }
    }
    
    // recursion
    void subs2(vector<int>& nums, int ci, vector<int> lv) {
        if(ci == sz) {
            ans.push_back(lv);
            return;
        }
        
        subs(nums, ci+1, lv);
        lv.push_back(nums[ci]);
        subs(nums,ci+1,lv);
    }
    
    // for loop based recursion
    void subs3(vector<int>& nums, int ci, vector<int> lv) {
        ans.push_back(lv);
        for(int i=ci; i<sz; i++) {
            vector<int> tv(begin(lv),end(lv));
            tv.push_back(nums[i]);
            subs(nums, i+1, tv);
        }
    }
    
    
    
};