// For-loop based recursion
// Time COmplexity - O(n*2^n)
// Space Complexity - O(n)
// Problems Faced - No!
// It runs on leetcode!

class Solution {
    private:
    bool isPalindrome(string s){
        int start = 0;
        int end = s.length() - 1;
        while(start <= end){
            if(s[start] != s[end])
                return false;
            start++; end--;
        }
        return true;
    }
    
    void helper(string s, vector<vector<string>>& partitions, vector<string> palindrome, int index){
        // base
        if(index == s.length()){
            partitions.push_back(palindrome);
            return;
        }
        // logic
        for(int i = index; i < s.length(); i++){
            string subS = s.substr(index, i - index + 1);
            if(isPalindrome(subS)){
                // action
                palindrome.push_back(subS);
                
                // recurse
                helper(s, partitions, palindrome, i+1);
                
                // backtrack
                palindrome.pop_back();
            }
        }
    }
    
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> partitions;
        vector<string> palindrome;
        helper(s, partitions, palindrome, 0);
        return partitions;
    }
};