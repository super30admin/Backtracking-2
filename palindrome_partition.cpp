//Time Complexity - O(2^n * n^2)
//Space Complexity - O(n)
//Ran successfuly on leetcode

class Solution {
public:
    vector<vector<string>>result;
    vector<vector<string>>partition(string s) {
        if(s.empty())
            return {};
        vector<string>temp;
        backtrack(s,temp,0);
        return result;
    }
    void backtrack(string s,vector<string>temp,int index)
    {
        //base case
        if(index==s.size())
        {
            result.push_back(temp);
            return;
        }
        for(int i=index;i<s.size();i++)
        {
            if(ispalindrome(s,index,i))
            {
                //action
                temp.push_back(s.substr(index,i-index+1));
                //recurse
                backtrack(s,temp,i+1);
                //backtrack
                temp.pop_back();
            }
        }
    }
    bool ispalindrome(string s,int l,int h) 
    { 
        //Keep comparing characters while they are same
        if(l==h)
            return true;
        while (h>l) 
        { 
            if(s[l++]!=s[h--])
                return false;
        }
        return true;
    } 
};