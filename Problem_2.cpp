/**
 * Time complexity:
 * O(n*2^n) as we are using choose and not choose method which gives us 2^n
 * and we are checking plaindrome too which is giving us n.
 * 
 */

/**
 * Space Complexity:
 * O(n) the size of the recursion stack
 * 
 */

/**
 * Approach:
 * "Bakctrackig"
 * We are going with fro loop recursion but here for the rest of the string after the
 * pivot we have to check if it is a palindrome or not. If it is, we add it to the path
 * and finally add path to our result. 
 * 
 * It is similar to other backtracking questions, the only difference is that here 
 * at every node we are checking whether the substring is a palindrome or not.
 * 
 */

//The code ran perfectly on leetcode











class Solution {
    vector<vector<string>> result;
public:
    vector<vector<string>> partition(string s) {
        //if(s.size()== 0) return {};
        helper(s, 0, {});
        return result;
        
    }
    
    private:
    
    void helper(string s, int index, vector<string> path){
        //base
        if(index == s.size()){
            result.push_back(path);
            return;
        }
        //logic
        for(int i = index; i<s.size(); i++){
            string subStr = s.substr(index, i-index+1);
            if(isPalindrome(subStr)){
                //action
                path.push_back(subStr);
                helper(s, i+1, path);
                //backtrack
                path.pop_back();
            }
        }
    }
    bool isPalindrome(string s){
        int start = 0;
        int end = s.size() -1;
        while(start<end){
            if(s[start] != s[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
};