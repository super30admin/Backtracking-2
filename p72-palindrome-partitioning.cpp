// Using BackTracking
// Time complexity is O(2^n) exponential time complexity where n is length of the string
// Space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    vector<vector<string>> res;
    bool isPalindrome(string str, int left, int right) { 
  
        while (right > left) 
        { 
            if (str[left++] != str[right--]) 
            {
                return false; 
            } 
        } 
        return true; 
    } 
    
    void helper(string s, vector<string>& temp, int index) {
        // base
        if(index == s.size()) {
            res.push_back(temp);
            return;
        }
        // logic
        
        for(int i = index; i < s.size(); i++) {
            // action
            if(isPalindrome(s, index, i)) {
                temp.push_back(s.substr(index, i-index+1));
                // recurse
                helper(s, temp, i+1);
                // backtrack
                temp.pop_back();
            }
        }
    }
    
    vector<vector<string>> partition(string s) {
        if(s.size() == 0) return {};
        vector<string> temp;
        helper(s, temp, 0);
        return res;
    }
};
