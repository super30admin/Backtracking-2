/*

Intuition: We have to exhaust all possible combinations. 
Find the palindrome partitioning with single char, double char and so on..

//////////////////////////////////////////////
Time and space complexity is same for both patterns
Time Complexity: O(2^N) *N 
Space Complexity: O(H), H = Height of the tree
//////////////////////////////////////////////
*/

class Solution {
public:
    vector<vector<string>> result;
    vector<vector<string>> partition(string s) {
        if ( s.size()==0) return result;
        vector<string> path;
        helper(s, 0, path);
        return result;
        
    }
    void helper(string s, int index, vector<string> path){
    
        if( index == s.size()){
            result.push_back(path);
            return;
        }
        for( int i =index; i < s.size(); i++){
            
            if(isPalindrome(s, index, i)){
                string substring = s.substr(index, i+1-index);
                path.push_back(substring) ;
                helper(s, i+1, path);
                path.pop_back();
            }
        
        }
    }
    bool isPalindrome(string a, int low, int high){
        if ( low == high) return true;
        while( low < high){
            
            if(a[low] != a[high]){
                return false;
            }
            
            low ++;
            high--;
        
        }
        return true;
    
    
    }
};