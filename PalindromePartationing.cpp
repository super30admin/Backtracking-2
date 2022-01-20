//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;

class Solution {
public:
    vector<vector<string> > result;
    vector<vector<bool> > dp;
    vector<vector<string> > partition(string s) {
        vector<vector<bool> > dp1(s.size(),vector<bool>(s.size(),false));
        dp=dp1;
        
        for(int i=dp.size()-1;i>=0;i--)
        {
            for(int j=dp[0].size()-1;j>=0;j--)
            {
                if(i==j)
                {
                    dp[i][j]=true;
                }
                else if(j>i && s[i]==s[j] && isPalindrome(i+1,j-1))
                {
                    dp[i][j]=true;
                }
            }
        }
        
        vector<string> sVec;
        helper(s,0,sVec);
        
        return result;
    }
    
    bool isPalindrome(int i,int j)
    {
        if(i>j)
        {
            return true;
        }
        return dp[i][j];
    }
    void helper(string s,int index,vector<string> path)
    {
        //base
        if(index==s.size())
        {
            result.push_back(path);
            return;
        }
        
        //logic
        
        for(int i=index;i<s.size();i++)
        {
            if(dp[index][i])
            {
                path.push_back(s.substr(index,i-index+1));
                helper(s,i+1,path);
                path.pop_back();
            }
        }
    }
};