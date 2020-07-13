class Solution {
private:
    
    bool isPalindrome(string& s, int left, int right){
        while(left<right){
            if(s[left++] != s[right--]) return false;
        }
        return true;
    }
    
    
    void partition(string& s,vector<string>& temp,vector<vector<string>>& result,int index){
        if(index == s.length()) result.push_back(temp);
        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s,index,i)){
                temp.push_back(s.substr(index,i-index+1));
                partition(s,temp,result,i+1);
                temp.pop_back();
            }    
        }
    }

public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> result;
        vector<string> temp;
        partition(s,temp,result,0);
        return result;
    }
};