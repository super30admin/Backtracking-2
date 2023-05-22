// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we use a for-loop based recurrsion to select the substrings. we check if that substring is a palindrome 
// and we proceed furthur only if it is a palindrome else we check other possibilities untill we reach end of the string.
// if we reach the end, that means, we got an answer so we add it to the result and return.
// and keep repeating the process which the for loop will take care.


class Solution {
public:
    vector<vector<string>>result;
    vector<vector<string>> partition(string s) {
        if(s.empty() || s.size()==0) return {};
        vector<string>path;
        backtrack(s,0,path);
        return result;
    }
    void backtrack(string &s,int index,vector<string>&path)
    {
        if(index == s.size())
        {
            result.push_back(path);
            return;
        }
        
        for(int i = index;i< s.size();i++)
        {
            string curr = s.substr(index,i-index+1);
            if(isPalindrome(curr))
            {
                path.push_back(curr);
                backtrack(s,i+1,path);
                path.pop_back();
            }
        }
    }
    bool isPalindrome(string &str)
    {
        int n = str.size();
        int lo = 0,hi = n-1;
        while(lo<hi)
        {
            if(str[lo]!=str[hi]) return false;
            lo++;hi--;
        }
        return true;
    }
};