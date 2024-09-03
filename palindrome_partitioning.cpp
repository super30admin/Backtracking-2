// time : O(2^N) N is length of string 
// space : O(N) N is length of string

class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> result; 
        vector<string> path;
        helper(s, 0, path, result);
        return result;
    }

    void helper(string s, int start, vector<string>& path, vector<vector<string>>& result)
    {
        if(start >= s.size())
        {
            result.push_back(path);
            return;
        }

        for(int i = start; i < s.size(); i++)
        {
            if(isPalindrome(s, start, i) == true)
            {
                path.push_back(s.substr(start, i-start+1));
                helper(s, i+1, path, result);
                path.pop_back();
            }
        }
    }

private: 
    bool isPalindrome(string s, int l, int r)
    {
        if(l == r) return true;
        while(l<=r)
        {
            if(s[l] != s[r])return false;
            l++;
            r--;
        }

        return true;
    }
};