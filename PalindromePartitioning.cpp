#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> ans;
        vector<string> path;
        helper(s, 0, path, ans);
        return ans;
    }

    void helper(string& s, int pivot, vector<string>& path, vector<vector<string>>& ans) {
        if (pivot == s.length()) {
            ans.push_back(path);
            return;
        }

        for (int i = pivot; i < s.length(); i++) {
            string curr = s.substr(pivot, i - pivot + 1);
            if (isPalindrome(curr, 0, curr.length() - 1)) {
                path.push_back(curr);
                helper(s, i + 1, path, ans);
                path.pop_back();
            }
        }
    }

    bool isPalindrome(string& s, int l, int r) {
        while (l < r) {
            if (s[l] != s[r])
                return false;
            l++;
            r--;
        }
        return true;
    }
};
