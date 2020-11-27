//
// Created by shazm on 8/6/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> retVec;
        if(s == ""){return retVec;}
        vector<string> path;
        dfs(retVec,path,s,0);
        return retVec;
    }
private:
    bool checkIfPalindrome(string s){
        int left = 0; int right = s.size()-1;
        while(left<right){
            if(s[left]!=s[right]){
                return false;
            }
            left++; right--;
        }
        return true;
    }
    void dfs(vector<vector<string>>& retVec, vector<string>& path, string s, int index){
        if(index >= s.size()){
            retVec.push_back(path);
            return;
        }
        string temp;
        for(int x = index+1; x <= s.size(); x++){
            temp = "";
            for(int i = index; i<x; i++){
                temp += s[i];
            }
            if(checkIfPalindrome(temp)){
                path.push_back(temp);
                dfs(retVec,path,s,x);
                path.pop_back();
            }
        }
    }
};