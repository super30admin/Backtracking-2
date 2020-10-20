//time complexity:O(n*2^n)
//space complexity:O(n*2^n)
//executed on leetcode: yes
//approach:using backtracking
//any issues faced? yes

class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>>res;
        vector<string>curr;
        dfs(s,res,curr,0);
        return res;
    }
    void dfs(string& s, vector<vector<string>>&res, vector<string>&curr, int index)
    {
        if(index >= s.size())
        {
            res.push_back(curr);
        }
        for(int i=index; i<s.size(); i++)
        {
            if(ispalindrome(s,index,i))
            {
                curr.push_back(s.substr(index,i-index+1));
                dfs(s,res,curr,i+1);
                curr.pop_back();
            }

        }
    }
    bool ispalindrome(string& s, int l, int r)
    {
        while(l<r)
        {
            if(s[l]!=s[r])
            {
                return false; 
            }
            l++;
            r--;
        }
        return true;
    }
};