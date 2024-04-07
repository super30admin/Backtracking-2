// Apporach 1 : DFS without backtracking
// Time Complexity : 2^n
//                   ..... 2^n because of making two choices at each element
// Space Complexity : O(n)
//                   ...... O(n) for call stack
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
/*
Leetcode : https://leetcode.com/problems/palindrome-partitioning/description/
Given a string s, partition s such that every substring of the partition is a palindrome. 
Return all possible palindrome partitioning of s.
*/



class Solution {
    vector<vector<string>>result;
public:
    vector<vector<string>> partition(string s) {
        vector<string>path;
        dfs(s, 0, path);
        return result;
    }

    void dfs(string s, int pivot, vector<string>&path){

        if(pivot == s.size()){
            vector<string>storage(path.begin(), path.end());
            result.push_back(storage);
            return;
        }


        for(int i = pivot; i<s.size(); i++){
            // substr (start_idx, number_of_characters)
            string temp = s.substr(pivot, i-pivot+1);
            if(isPalindrome(temp)){
                path.push_back(temp);
                dfs(s, i+1, path);
                path.pop_back();
            }
        }
    }


    bool isPalindrome(string s){
        int start = 0;
        int end = s.size()-1;

        while(start < end){
            if(s[start] != s[end]) return false;
            start++;
            end--;
        }
        return true;
    }
};