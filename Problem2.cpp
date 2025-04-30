// Time Complexity : O(2^n)  
// Space Complexity : O(2^n)  
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach:
// 1. Traverse each element and for each element include and exclude partition before that element(choose partition or don't).
// 2. For further subset recursively select remaining element combination. 
// 3. If we choose partition check if substring from previous partition till that element is palindrome or not.Add if palindrome to running vector.

class Solution {
public:
    vector<vector<string>> ans;

    bool ckpalindrome(string t) {
        int end= (t.size()-1);
        int start=0;
        while (start < end) {
            if (t[start] != t[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    void allpart(string s,int it,vector<string>& tt){
        if(it==s.size()){
            ans.push_back(tt);
            return;
        }
        for(int i=it;i<s.size();i++){
            string t=s.substr(it,i-it+1);
            if(ckpalindrome(t)){
                tt.push_back(t);
                allpart(s,i+1,tt);
                tt.pop_back();
            }
        }
    } 
    vector<vector<string>> partition(string s) {
        vector<string> tt;
        allpart(s,0,tt);
        return ans;
    }
};