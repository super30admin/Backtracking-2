// https://leetcode.com/problems/palindrome-partitioning/description/
// Time Complexity : O(n*2^n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// for loop based
class Solution {
    public:
        void helper(string s, int pivot, vector<vector<string>> &ans, vector<string> &path){
            if(pivot == s.length()){
                ans.push_back(path);
                return;
            }
            for(int i=pivot; i<s.length(); i++){
                string cur = s.substr(pivot, i-pivot+1);
                if(isPalindrome(cur, 0, cur.length()-1)){
                    path.push_back(cur);
                    helper(s, i+1, ans, path);
                    path.pop_back();
                }
            }
        }
        bool isPalindrome(string s, int start, int end){
            int i=start;
            int j=end;
            while(i<=j){
                if(s[i] != s[j]){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
        vector<vector<string>> partition(string s) {
            vector<vector<string>> ans;
            vector<string> path;
            helper(s, 0, ans, path);
            return ans;
        }
    };

// (0,1)
class Solution {
    public:
        void helper(string s, int pivot, int idx, int cnt, vector<vector<string>> &ans, vector<string> &path){
            if(idx == s.length()){
                if(cnt == s.length()){
                    ans.push_back(path);
                }
                return;
            }
            // 0
            helper(s, pivot, idx+1, cnt, ans, path);
    
            // 1
            string cur = s.substr(pivot, idx-pivot+1);
            int newCnt = cnt + cur.length();
            if(isPalindrome(cur, 0, cur.length()-1)){
                path.push_back(cur);
                helper(s, idx+1, idx+1, newCnt, ans, path);
                path.pop_back();
            }
            
        }
        bool isPalindrome(string s, int start, int end){
            int i=start;
            int j=end;
            while(i<=j){
                if(s[i] != s[j]){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
        vector<vector<string>> partition(string s) {
            vector<vector<string>> ans;
            vector<string> path;
            helper(s, 0, 0, 0, ans, path);
            return ans;
        }
    };