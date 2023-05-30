// TC:O(N*2^N)
// SC:O(N)

//Using for loop-based recursion and along the path  using a temp string to generate substring and checking 
// whether it is a palindrome or not ,if it is a palindrome , further calling the recursive function on the remaining
// substring and using backtracking 

// The given code implements a backtracking approach to generate all possible partitions of a given string s into 
// palindromic substrings. It uses a recursive function, rec, to generate the partitions by considering all 
// possible palindromic substrings starting from each index. The valid partitions are stored in the ans vector,
//  which is returned by the partition function. The code uses backtracking by adding each palindromic substring 
//  to the current path, recursing further, and then removing the added substring before exploring other possibilities.

class Solution {
public:
    vector<vector<string>>ans; 
    vector<vector<string>> partition(string s) 
    {  
        if(s.size()==0) 
        return ans;
        vector<string>path;
        rec(s,0,path); 
        return ans;
    }

    void rec(string s, int idx, vector<string>&path)
    {
        // base
        if(idx==s.size())
        {
            ans.push_back(path);
            return;
        }

        // logic
         string temp="";
        for(int i=idx;i<s.size();i++)
        {
    
            temp+=s[i]; 
            if(ispalindrome(temp))
            {
                // action
                path.push_back(temp);
                // recurse
                rec(s,i+1,path);
                // backtrack
                path.pop_back();
            }

        }
    }

    bool ispalindrome(string temp)
    {
        int i=0;
        int j=temp.size()-1;

        while(i<=j)
        {
            if(temp[i]!=temp[j])
            return false;
            i++;
            j--;
        }
        return true;
    }
};