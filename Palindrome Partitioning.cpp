//Time Complexity- O(n*2^n)
//Space Complexity- O(n)

class Solution {
public:
    vector<vector<string>> partition(string s) {
        
        vector<vector<string>> ans;
        vector<string> temp;
        helper(ans,temp,s);
        return ans;
    }
    
    void helper(vector<vector<string>> &ans,vector<string> temp,string s){
        
        if(s.size()==0){
            ans.push_back(temp);
            return;
        }
        
        for(int i=0;i<s.size();i++){
            if(isPalindrome(s,0,i+1)){
                temp.push_back(s.substr(0,i+1));
                helper(ans,temp,s.substr(i+1,s.size()));
                temp.pop_back();
            }
        }
    }
    
    bool isPalindrome(string s,int start,int end){
        
        end--;
        while(start<=end){
            if(s[start]!=s[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
};