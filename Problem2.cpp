// Time Complexity : O(2 ^ n)
// Space Complexity : O(N)
class Solution {
public:
    vector<vector<string>> res;
    bool palindrome(string s){
        string temp = s;
        reverse(s.begin(), s.end());
        if(temp == s){
            return true;
        }
        return false;
    }
    void helper(string s, int pivot, vector<string> path ){
        if(pivot == s.size()){
            res.push_back(path);
        }

        for(int i=pivot; i< s.size(); i++){
            string sub = s.substr(pivot, i-pivot+1);
            if(palindrome(sub)){
                //action
                path.push_back(sub);
                //recurse
                helper(s, i+1, path);
                //backtrack
                path.pop_back();
            }
        }
    }
    vector<vector<string>> partition(string s) {
        vector<string> path;
        helper(s, 0, path);
        return res;
    }
};