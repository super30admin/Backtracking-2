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
        string temp = "";
        for(int x = s.size()-1; x>=0; x--){
            temp+=s[x];
        }
        if(s == temp){
            return true;
        }
        return false;
    }
    void dfs(vector<vector<string>>& retVec, vector<string>& path, string s, int index){
        if(index >= s.size()){
            retVec.push_back(path);
            return;
        }
        for(int x = index+1; x <= s.size(); x++){
            string temp = s.substr(index,x);
            if(checkIfPalindrome(temp)){
                path.push_back(temp);
                dfs(retVec,path,s,x);
                path.pop_back();
            }
        }
    }
};