// Time Complexity: O(2^n * n) where n is the number of elements in the input array
// Space Complexity: O(n^2) where n is the stack space
// Were you able to solve the problem? Yes
// Did you face any challenges while solving the problem? No

class Solution {
public:
    vector<vector<string>> result;
    vector<vector<string>> partition(string s) {

        if(s.size() == 0){
            return {};
        }

        recurse(s, {});
        
        return result;
    }
private:

    void recurse(string s){

        // base case
        // if we reach the end of the string, we have a valid partition
        if(s.size() == 0) {
            result.push_back(path);
            return; 
        }

        // core logic
        for(int i = 0; i < s.size(); i++) {
            // check if the substring from 0 and i+1 length is a palindrome
            string subStr = s.substr(0, i + 1);

            // if it is a palindrome, we can add it to the path and recurse on the remaining string
            if(isPalindrome(subStr)) {
                //action
                path.push_back(subStr);
                //recurse
                recurse(s.substr(i + 1), path);
                //backtrack
                path.pop_back();
            }
        }


    }

    bool isPalindrome(string s) {
        // using two pointers to check if the string is a palindrome
        int left = 0, right = s.length() - 1;
        while(left < right) {
            // we check the characters at the left and right pointers
            // if they are not equal, it is not a palindrome
            // if they are equal, we move the pointers towards the center
            if(s[left] != s[right])
                return false;
            left++; right--;
        }
        return true;
    }
};