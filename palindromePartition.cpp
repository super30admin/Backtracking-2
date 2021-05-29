// Time Complexity :O(n*2^n) where n is the size of the string  
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    vector<vector<string>> result;
public:
    vector<vector<string>> partition(string s) {
        vector<string> path;
        backtrack(s, 0,path);
        return result;
    }
    void backtrack(string s, int index, vector<string> path){
        //base
        if(index == s.length()){
            result.push_back(path);
            return;
        } 
        //logic
        for(int i = index; i< s.length(); i++){
            if(isPalindrome(s,index,i)){
                string str = s.substr(index,i-index+1);
                path.push_back(str);
                backtrack(s,i+1, path);
                path.pop_back();
            }
        }
    }
    bool isPalindrome(string s, int l, int r){
        //cout<<r<<endl;
        while(l<=r){
            if(s[l] != s[r]) return false;
            l++;
            r--;
        }
        return true;
    }
};