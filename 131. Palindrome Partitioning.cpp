// Time Complexity : exponential
// Space Complexity :exponential

//backtrack
class Solution {
public:
    vector<vector<string>> result;
    vector<vector<string>> partition(string s) {
        if(s.empty() || s.length()==0)
            return result;
        vector<string> path;
        recurse(s, 0, path);
        return result;
    }
    void recurse(string s, int index, vector<string> path){
        //base
        if(s.length() == index){
            result.push_back(path);
            return;
        }
        //logic
        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                //action
                path.push_back(s.substr(index,i-index+1));
                //recruse
                recurse(s, i+1, path);
                //backtrack
                path.pop_back();
            }
        }
    }
    
    bool isPalindrome(string s, int l, int r){
        while(l<r){
            if(s[l] != s[r])
                return false;
            l++;
            r--;
        }
        return true;
    }
};

//backtract without index.
class Solution {
public:
    vector<vector<string>> result;
    vector<vector<string>> partition(string s) {
        if(s.empty() || s.length()==0)
            return result;
        vector<string> path;
        recurse(s, path);
        return result;
    }
    void recurse(string s, vector<string> path){
        //base
        if(s.length() == 0){
            result.push_back(path);
            return;
        }
        //logic
        for(int i=0; i<s.length(); i++){
            if(isPalindrome(s, 0, i)){
                //action
                path.push_back(s.substr(0,i+1));
                //recurse
                recurse(s.substr(i+1), path);
                //backtrack
                path.pop_back();
            }
        }
    }
    
    bool isPalindrome(string s, int l, int r){
        while(l<r){
            if(s[l] != s[r])
                return false;
            l++;
            r--;
        }
        return true;
    }
};

//recursion
class Solution {
public:
    vector<vector<string>> result;
    vector<vector<string>> partition(string s) {
        if(s.empty() || s.length()==0)
            return result;
        vector<string> path;
        recurse(s, 0, path);
        return result;
    }
    void recurse(string s, int index, vector<string> path){
        //base
        if(s.length() == 0){
            result.push_back(path);
            return;
        }
        //logic
        for(int i=0; i<s.length(); i++){
            if(isPalindrome(s, 0, i)){
                vector<string> copy(path);
                copy.push_back(s.substr(0,i+1));
                recurse(s.substr(i+1), i+1, copy);
            }
        }
    }
    
    bool isPalindrome(string s, int l, int r){
        while(l<r){
            if(s[l] != s[r])
                return false;
            l++;
            r--;
        }
        return true;
    }
};
