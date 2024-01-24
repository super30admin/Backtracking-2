// Time Complexity : O(2^n) where n - s length

// Space Complexity : O(N) - recursion stack space

// Did this code successfully run on Leetcode : YES

// Appoarch: Recursion + Backtracking - for loop based recursion

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<string>> result;
    bool isPalin(string s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s[start] != s[end]) return false;
            start++;
            end--;
        }
        return true;
    }
    void helper(string s,vector<string>& path,int pivot){
        if(pivot == s.length()){
            result.push_back(path);
            return;
        }
        for(int i=pivot;i<s.length();i++){
            string sub = s.substr(pivot,i-pivot+1); 
            if(isPalin(sub)){
                path.push_back(sub);
                helper(s,path,i+1);
                path.pop_back();
            }
        }
    }
    vector<vector<string>> partition(string s) {
        vector<string> path;
        helper(s,path,0);
        return result;
    }
};