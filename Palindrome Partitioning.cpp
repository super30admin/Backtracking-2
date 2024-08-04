//for loop based recursion
//time: O(n(2^n))
//space: O(n)
class Solution {

public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> result;
        vector<string> path;
        helper(s, result, path, 0, "");
        return result;
    }

private:
    void helper(string s, vector<vector<string>>& result, vector<string>& path, int idx, string curr) {
        //base
        if(idx == s.length()) {
            result.push_back(path);
            return;
        }
        
        //logic
        //string curr = "";
        for (int i = idx; i < s.size(); i++) {
            
            curr += s[i];
            //cout<<curr<<endl;
            if (isPalindrome(curr)) {
                path.push_back(curr);
                helper(s, result, path, i + 1, "");
                path.pop_back();
            }
        }
    }

    bool isPalindrome(string str) {
        int i = 0, j = str.length()-1;
        while(i < j) {
            if(str[i] != str[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
};

//0-1 recursion
/*
class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> result;
        vector<string> path;
        helper(s, result, path, 0, "");
        return result;
    }
private:
    void helper(string s, vector<vector<string>>& result, vector<string>& path, int idx, string str) {
        //base
        if(idx == s.length()-1) { // this is weirdly coded
            str += s[idx];
            if(isPalindrome(str)) {
                path.push_back(str);
                
                result.push_back(path);
                path.pop_back();
                
            }
            
            return;
        }
        
        //logic
        str += s[idx];
        if(isPalindrome(str)) {
            path.push_back(str);
            helper(s, result, path, idx+1, "");
            path.pop_back();
        }
        helper(s, result, path, idx+1, str);
    }

    bool isPalindrome(string str) {
        int i = 0, j = str.length()-1;
        while(i < j) {
            if(str[i] != str[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
};
*/