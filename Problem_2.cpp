// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Palindrome Partitioning
// Approach: Backtracking
// TC: O(N * 2^N)
// SC: O(N)

class Solution
{
public:
    vector<vector<string>> result;

    vector<vector<string>> partition(string s)
    {
        if (s.empty())
        {
            return result;
        }
        vector<string> path;
        backtrack(s, 0, path);
        return result;
    }

    void backtrack(string &s, int start, vector<string> &path)
    {

        // Base case
        if (start == s.length())
        {
            result.push_back(path);
            return;
        }

        // Recursive case
        for (int i = start; i < s.length(); i++)
        {
            if (isPalindrome(s, start, i))
            {
                path.push_back(s.substr(start, i - start + 1));
                backtrack(s, i + 1, path);
                path.pop_back();
            }
        }
    }

    bool isPalindrome(string &s, int l, int r)
    {
        while (l < r)
        {
            if (s[l] != s[r])
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
};
