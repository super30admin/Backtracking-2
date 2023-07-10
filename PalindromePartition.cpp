//Time Complexity: O(2^n)
//Space Complexity: O(n)
class Solution {
public:
    vector<vector<string>> result; 
    vector<vector<string>> partition(string s) {
        string curr = ""; 
        for(int i = 0; i < s.size(); i++) {
            curr = s.substr(0, i + 1);
            if(palindrome(curr)) {
                vector<string> res; 
                res.push_back(curr); 
                helper(s, i+1, res);  
            }
        }
        return result;                     
    }

    void helper(string s, int pivot, vector<string>& res) {
        if(pivot == s.size()) {
            result.push_back(res);
            return; 
        }
        for(int i = pivot; i < s.size(); i++) {
            string curr = s.substr(pivot, i - pivot + 1); 
            if(palindrome(curr)) {
                res.push_back(curr); 
                helper(s, i+1, res); 
                res.pop_back(); 
            }
        }    
    }

    bool palindrome(string s) {
        int i = 0; 
        int j = s.size()-1; 
        while(i < j) {
            if(s[i] != s[j]) return false; 
            i++; 
            j--; 
        }
        return true; 
    }
};