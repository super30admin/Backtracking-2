// Time Complexity : O(n*n*2^n)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// start at index 0, break string into substrings at each index
// only if the substring is a palindrome, make a recursive call to process the rest of the string
// backtrack after the recursive call to explore different length substrings
// push the partitions into the result when we reach the end of the string
 
class Solution {
private:
    bool isPal(string str) {
        int left = 0;
        int right = str.length()-1;
        while(left < right) {
            if(str[left] != str[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    void helper(string s, int idx, vector<string>& part, vector<vector<string>>& res) {
        if(idx == s.length()) {
            res.push_back(part);
            return;
        }
        for(int i=idx; i<s.length(); i++) {
            string sub = s.substr(idx, i-idx+1);
            if(isPal(sub)) {
                part.push_back(sub);
                helper(s, i+1, part, res);
                part.pop_back();
            }
        }
    }
public:
    vector<vector<string>> partition(string s) {
        vector<string> part;
        vector<vector<string>> res;
        helper(s, 0, part, res);
        return res;    
    }
};