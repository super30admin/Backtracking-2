//Time Complexity - O(exponential)
//Space Complexity - O(len(s))
class Solution {
public:
    vector<vector<string>>result;
    bool isPalindrome(string s, int l, int r){
        while(l<r){
            if(s[l]!=s[r])
                return false;
            l++;
            r--;
        }
        return true;
    }
    void helper(string s, int idx, vector<string>&v){
        
        if(s.size()==0){
            result.push_back(v);
            return;
        }
        for(int i=0;i<s.size();i++){
            if(isPalindrome(s,0,i)){
                v.push_back(s.substr(0,i+1));
                helper(s.substr(i+1),i+1,v);
                v.pop_back(); 
            }
        }
    }
    vector<vector<string>> partition(string s) {
        vector<string>v;
        helper(s,0,v);
        return result;
    }
};