//Time Complexity : O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    bool isPalindrome(string str, int i, int j){
        while(i<=j){
            if(str[i]!=str[j]){
                return false;
            }
            i++;j--;
        }
        return true;
    }
    
    void backtrack(string s,vector<string>& list, vector<vector<string>>& res, int start ){
        if(start==s.size()){
            res.push_back(list);
            return;
        }
        
        for(int i=start; i<s.size(); i++){
            if(isPalindrome(s, start, i)){
                //action 
                list.push_back(s.substr(start, i-start+1));
                
                //backtrack
                backtrack(s, list, res, i+1);
                
                //recurse
                list.pop_back();
            }
  
        }
    }
    
    vector<vector<string>> partition(string s) {
        vector<vector<string>> res;
        vector<string> list;

        if(s.size()==0) return res;
        //backtrack(s, list, res, 0);
        res = recur_partition(s);
        return res;
    }
};