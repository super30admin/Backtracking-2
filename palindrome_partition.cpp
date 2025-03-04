// Time Complexity: O(2^n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

//Approach:
//1. For loop based recursion
//2. For each element, we have 2 choices - either include it in the subset or not include it.
//3. We will make a choice and recurse on the next element.
//4. We will backtrack and remove the element from the subset and make the other choice.
//5. We will keep doing this until we reach the end of the array.

class Solution {
    vector<vector<string>> result; 
public:
    vector<vector<string>> partition(string s) {
        helper(s, 0, vector<string>());
        return result; 
    }
private: 
    void helper(string s, int pivot, vector<string> path){
        // base case
        if(pivot >= s.size()){
            result.push_back(path);
        }
        
        for(int i = pivot; i < s.size(); i++){
            if(isPalindrome(s, pivot, i)){
                path.push_back(s.substr(pivot, i - pivot + 1));
                helper(s, i+1, path);
                path.pop_back();
            }
        }
    }
    bool isPalindrome(string s, int start, int end){
        while(start < end){
            if(s[start] != s[end]){
                return false; 
            }
            start++;
            end--;
             
        }
        return true;
    }
};