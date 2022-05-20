// Time Complexity : O(2^n) where n = size of i/p
// Space Complexity : O(n*n) where n = size of i/p
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* Perform exhaustive search. Create partitions at each possible index and check if current partioned string is palindrome,
 * if it's palindrome then call the same recursive method to create partions of other half of substring.  
 */

class Solution {
public:
    vector<vector<string>> result;
    vector<vector<bool>> dp;
    int n;
    
    vector<vector<string>> partition(string s) {
        if (s.empty())
            return result;
        
        vector<string> path;
        n = s.length();
        palindrome(s);
        
        helper(s, 0, path);
        return result;
    }
    
    void helper(string& s, int index, vector<string>& path)
    {
        if (index == s.length())
        {
            result.push_back(path);
            return;
        }
        
        for (int i = index; i < s.length(); i++)
        {
            string part = s.substr(index, (i - index + 1));
            if (dp[index][i])
            {
                path.push_back(part);
                helper(s, i + 1, path);
                path.pop_back();
            }
        }
    }
    
    void palindrome(string& s)
    {
        for (int i = 0; i < n; i++)
        {
            vector<bool> temp;
            for (int j = 0; j < n; j++)
            {
                if (j <= i)
                {
                    temp.push_back(true);
                }
                else
                {
                    temp.push_back(false);
                }
            }
            dp.push_back(temp);
        }
        
        for (int i = 1; i < n; i++)
        {
            for (int start = 0; (start + i) < n; start++)
            {
                int end = start + i;
                dp[start][end] = s[start] == s[end] && dp[start + 1][end - 1];
            }
        }
    }
};