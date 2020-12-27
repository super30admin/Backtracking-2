//Time - O(n*2^n)
//Space - O(n)

class Solution {
public:
    vector<vector<string>> ret;
    vector<vector<string>> partition(string s) {
        vector<vector<bool>> dp (s.size(), vector<bool>(s.size(),false));
        vector<string> pal;
        for(int i=0;i<s.size();i++){
            dp[i][i] = true;
        }
        
        findPalindromes(0,s,pal,dp);
        return ret;
    }
    
    
    void findPalindromes(int start, string s,vector<string> pal, vector<vector<bool>>& dp){
        if(start >= s.size()) ret.push_back(pal);
        
        for(int i=start;i<s.size();i++){
            if(s[start] == s[i] && (i-start<=2 || dp[start+1][i-1])){
                dp[start][i] = true;
                pal.push_back(s.substr(start,i-start+1));
                findPalindromes(i+1,s,pal,dp);
                pal.pop_back();
            }
        }
    }
};