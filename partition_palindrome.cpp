// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//1. Before every recursion we are checking whether the string is palindrome or not.
//2. Action, recurse and backtrack is performed.
//3. When the end of the string is reached the corresponding result is added.

class Solution {
public:
    bool is_pal(string s, int l, int r){
        for(int i =l, k=r; i<=k; i++, k--){
            if(s[i]!=s[k]) return false;
        }
        return true;
    }
    vector<vector<string>> result;
    vector<vector<string>> partition(string s) {
        //edge case
        if(s.length()==0) return result;
        vector<string> partition_array;
        backtrack(s, partition_array, 0);
        return result;
    }
    
    void backtrack(string s,vector<string>& partition_array, int index){
        //return condition 
        if(index == s.length()){
           result.push_back(partition_array);
           return;
        }
        //logic
            for(int i=index; i<s.length(); i++){
                if(is_pal(s, index, i)){
                    //action
                    string temp = s.substr(index, (i+1-index));
                    partition_array.push_back(temp);
                    //recurse
                    backtrack(s, partition_array, i+1);
                    //backtrack
                    partition_array.pop_back();
                }
            }
        }
    

};
