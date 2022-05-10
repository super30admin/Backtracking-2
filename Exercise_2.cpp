/* 
    Time Complexity                              :  O(N * 2^N) since for every character 
                                                    in the string there are 2 choices
    Space Complexity                             :  O(N) - size of the recursion stack
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/palindrome-partitioning/

class Solution {
private: 
    vector<vector<string>> ans;
    bool isPal(string s) {
        int l=0;
        int r=s.size()-1;
        while(l <= r) {
            if(s[l] != s[r]) return false;
            l++;
            r--;
        }
        
        return true;
    }
public:
    vector<vector<string>> partition(string s) {
        if(s.size() == 0) return ans;
        
        part(s,0,vector<string>());
        return ans;
    }
    
    void part(string s, int index, vector<string> lv) {
       if(index == s.size()) {
           ans.push_back(lv);
           return;
       }
        
        int len = 1;
        for(int i=index;i<s.size();i++) {
            string str = s.substr(index,len++);
            if(isPal(str)) {
                lv.push_back(str);
                part(s,i+1,lv);
                lv.pop_back();
            }
        }
    }
};