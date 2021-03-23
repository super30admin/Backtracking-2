//TC: O(n*2^n)
//SC: O(n) since the temp array could hold potentially the whole string (if the whole string is a palindrome)

class Solution {
public:
    
    vector<vector<string>> ans;
    
    //check if a substring is a palindrome or not
    bool isPalin(string &s, int low, int high) {
        while (low < high) {
            if (s[low++] != s[high--]) return false;
        }
        return true;
    }
    
    
    void backtrack(string s, int start, vector<string> &combs){
        
        //if we reach the end of a particular partition, then add the combination to the answer
        if(start >= s.length()){
            ans.push_back(combs);
        }
        
        
        //increment the end pointer. End becomes the start for every new recursion call(for the second partition after the first one goes from start to end.)
        for(int end = start; end<s.length(); end++){
            
            if(isPalin(s, start, end)){
                //if start->end is palin, then add this substr to the combs list and check for second partition which starts from end+1 to end
                combs.push_back(s.substr(start, end-start+1));
                backtrack(s, end+1, combs);
                //after we're done with a partition, pop the last value out.
                combs.pop_back();
            }
            
        }
        
        return;
        
        
    }
    
    vector<vector<string>> partition(string s) {
        
        vector<string> combs;
        backtrack(s, 0, combs);
        return ans;
        
    }
};