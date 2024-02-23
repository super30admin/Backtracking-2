// TC = O(N * 2 ^ N), N for checking the palindromability of s at each level,- we r making decision, choose a, aa, aab, aaba
// SC = O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// for loop based recursion
class Solution {
public:
    vector<vector<string>> result;
    vector<vector<string>> partition(string s) {
        vector<string> path(0);
        helper(s, 0, path);
        return result;
    }
    void helper(string s, int index, vector<string>& path) {
        // base
        if(index == s.size()) {
            result.push_back(vector<string>(path));
            return;
        }
        // logic
        for(int i = index; i < s.size(); i++) {
            string sub = s.substr(index, i + 1 - index);
            if(isPalindrome(sub)) {
                path.push_back(sub); // action
                helper(s, i + 1, path); // recurse
                path.erase(path.end() - 1); // backtrack
            }
        }
    }
    bool isPalindrome(string s) {
        int start = 0, end = s.size() - 1;
        while(start < end) {
            if(s.at(start++) != s.at(end--)) return false;
        }
        return true;
    }
};