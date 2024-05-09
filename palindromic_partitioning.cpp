//Time O(n* 2^n) where n is length of the string
//Space O(n)
//Leetcode : yes
//issue seen: none
class Solution {
public:
    bool is_palindrome(string& s) {
        int start = 0;
        int end = s.length() - 1;
        if (start == end)
            return true;

        while (start < end) {
            if (s[start++] != s[end--])
                return false;
        }
        return true;
    }

    void helper(string s, int i, vector<string>& slate, vector<vector<string>>& ans) {
        if (s.size() == i) {
            ans.push_back(slate);
            return;
        }
        for (int pick = i; pick < s.size(); pick++) {
            string temp = s.substr(i, pick-i+1);
            cout << temp << '\n';
            if (is_palindrome(temp)) {
                slate.push_back(temp);
                helper(s, pick + 1, slate, ans);
                slate.pop_back();
            }
        }
    }
    vector<vector<string>> partition(string s) {

        vector<vector<string>> ans;
        vector<string> slate;
        helper(s, 0, slate, ans);
        return ans;
    }
};
