/*

// Time Complexity : O(2^(N-1))
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Generating substrings


// Your code here along with comments explaining your approach
*this is for generating substring.
Take pivot. Run a loop from pivot to length of the string. This will generate all the different substrings form 
initial character of the pivot to the length of the string. As soon as that substring is generated then run the same function
from the index which +1 greater than the last index of the substring. This will in return created other nested substrings.

*For palindrome 
if the substring satisfies then push it into the solution and then again run the function to generate and check substrings
when end of the string is reached push the solution into the result of the accumulated strings.

*/

#include<iostream>
#include<vector>
#include<queue>

using namespace std;

class Solution {
    bool palindrome(string& s){
        int n = s.length()-1;
        for(int i{};i<s.length()/2;++i){
            if(s.at(i)!=s.at(n-i)) return false;
        }
        return true;
    }
    vector<vector<string>> res;
    void helper(string& s,int pivot,vector<string>& sol){
        if(pivot == s.length()){
            vector<string> sol_push(sol);
            res.push_back(sol_push);
            return;
        }
        for(int i{pivot};i<s.length();++i){
            string sub = s.substr(pivot,i+1-pivot);
            if(palindrome(sub)){
                sol.push_back(sub);
                helper(s,i+1,sol);
                sol.pop_back();
            }
            
        }
    }
public:
    vector<vector<string>> partition(string s) {
        vector<string> sol;
        helper(s,0,sol);
        return res;
    }
};

/*

//it will send the next substring instead of the pivot
so the length of the substring is maintained.


void helper(string s,vector<string>& sol){
    for(int i{};i<s.length();++i){
        string sub = s.substr(i,i+1)
        if(palindrome(sub)){
            sol.push_back(sub);
            helper(s.substr(i+1),sol)
        }
    }
}


*/

