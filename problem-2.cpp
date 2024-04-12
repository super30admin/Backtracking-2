// 131. Palindrome Partitioning
// Time Complexity : O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<string> path;
        vector<vector<string>> result;
        substrfor(0, s, path, "",result);
        return result;
    }
    void substr(int ind, string s, vector<string>& path, string str, vector<vector<string>>& result){
        if(ind == s.size())
        {
            result.push_back(path);
            return;
        }
        str += s[ind];
        if(is_palindrome(str))
        {
            path.push_back(str);
            substr(ind+1, s, path, "", result);
            path.pop_back(); 
        }
        if(ind < s.size()-1)
            substr(ind+1, s, path, str, result);  
        return;
    }
    void substrfor(int ind, string s, vector<string>& path, string str, vector<vector<string>>& result){
        if(ind == s.size())
        {
            result.push_back(path);
            return;
        }
        for(int i = ind; i < s.size(); i++)
        {
            str += s[i];
            if(is_palindrome(str))
            {
                path.push_back(str);
                substrfor(i+1, s, path, "", result);
                path.pop_back(); 
            }
        }
        return;
    }
    bool is_palindrome(string s)
    {
        int i = 0,j = s.size() - 1;
        while(i<j)
        {
            if(s[i] != s[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
};

