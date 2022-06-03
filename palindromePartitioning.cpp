FOR LOOP BACTRACKING
TC = O(n 2^n)
SC = O(n)

class Solution {
public:
    vector<vector<string>> result;
    vector<vector<string>> partition(string s) {
        recursion(s,0,{});
        return result;
    }
    
    void recursion(string s, int pivot, vector<string> path){
        //base
        if(pivot==s.length()){
            result.push_back(vector<string>(path));
            return;
        }
        //logic
        for(int i=pivot;i<s.length();i++){
            string sub = s.substr(pivot,i - pivot + 1);
            if(isPalindrome(sub)){
                path.push_back(sub);
                recursion(s,i+1,path);
                path.pop_back();
            }
        }
    }
    
    bool isPalindrome(string s){
        int len = s.length();
        int start = 0;
        int end = len -1;
        while(start<end){
            if(s[start]!=s[end]) return false;
            start++; end--;
        }
        return true;
    }
};

FOR LOOP RECURSION
TC = O(n 2^n)
SC = O(n*n)
  
class Solution {
public:
    vector<vector<string>> result;
    vector<vector<string>> partition(string s) {
        recursion(s,0,{});
        return result;
    }
    
    void recursion(string s, int pivot, vector<string> path){
        //base
        if(pivot==s.length()){
            result.push_back(path);
            return;
        }
        //logic
        for(int i=pivot;i<s.length();i++){
            string sub = s.substr(pivot,i - pivot + 1);
            if(isPalindrome(sub)){
                vector<string> temp(path);
                temp.push_back(sub);
                recursion(s,i+1,temp);
            }
        }
    }
    
    bool isPalindrome(string s){
        int len = s.length();
        int start = 0;
        int end = len -1;
        while(start<end){
            if(s[start]!=s[end]) return false;
            start++; end--;
        }
        return true;
    }
};
