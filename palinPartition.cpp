#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use recursive function to solve this problem, in between we put each substring 
into the path vector if it is a palindrom and the for loop based recursion takes care of all 
the cases, we finally return the result
*/
class Solution{
public:
    vector<vector<string>> result;
    vector<vector<string>> partition(string s){
        vector<string> path;
        helper(s, 0, path);
        return result;

    }
private:
    void helper(string& s, int pivot, vector<string>& path){
        if(pivot == s.length()){
            result.push_back(path);
            return;
        }
        for(int i=pivot; i<s.length(); i++){
            string subStr = s.substr(pivot, i-pivot+1);
            if(isPalindrome(subStr)){
                path.push_back(subStr);
                helper(s, i+1, path);
                path.pop_back();
            }
        }
    }
    bool isPalindrome(string& s){
        int left = 0, right = s.length()-1;
        while(left < right){
            if(s[left++] != s[right--]) return false;
        }
        return true;
    }
};
