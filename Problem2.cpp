// Time Complexity :O(N x 2^N)
// Space Complexity : O(N) Call stack size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Palindrome Partitioning 

#include<vector>
#include<iostream>
using namespace std;

class Solution {
    vector<vector<string>> result;
public:
    vector<vector<string>> partition(string s) {
        if(s.empty())
            return {};
        
        vector<string> temp;
        backtrack(s, temp);
        return result;
    }
    
    void backtrack(string s, vector<string> &temp){
        //base case 
        if(s.size() == 0){
            result.push_back(temp);
            return;
        }
        
        for(int i = 0; i < s.size(); i++){
            if(isPalindrome(s, 0, i)){  // first and last index
                temp.push_back(s.substr(0, i+1));
                backtrack(s.substr(i+1), temp);
                temp.pop_back();    //backtrack
            }
        }
        
    }
    
    bool isPalindrome(string s, int l, int r){
        while(l < r){
            if(s[l] != s[r])
                return false;
            
            l++;
            r--;
        }
        return true;
    }
};
