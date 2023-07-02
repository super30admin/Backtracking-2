// Time Complexity : O(2^n * n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> result;
        // vector<string> path;
        helper(s, 0, {}, result);
        return result;
    }
private:
    void helper(string s, int pivot, vector<string>&& path, vector<vector<string>>& result){
        //base
        // if(s.size() == 0) return;
        if(pivot == s.size()){
            result.push_back(path);
            return;
        }
        //logic
    
        for(int i = pivot; i < s.size(); i++){
            //action
            string sub = s.substr(pivot, i - pivot + 1);
            //resurse
            if(isPalindrome(sub)){
                //action
                //without bactracking
                // vector<string> li(path);
                // li.push_back(sub);
                path.push_back(sub);
                //recurse
                helper(s, i + 1, move(path), result);
                //backtrack
                path.pop_back();
            }
        }
    }

    //check palindrome
    bool isPalindrome(string s){
        int start = 0;
        int end = s.size() - 1;
        while(start < end){
            if(s[start] != s[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
};

