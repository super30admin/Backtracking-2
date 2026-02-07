class Solution {
public:
    vector<vector<string>> answer;
    void backtrack(vector<string> temp, int start, string s) {

        if (start >= s.length()) {
            answer.push_back(temp);
        }

        auto isPalindrome = [=] (string substring) -> bool {
            int start = 0;
            int end = substring.length()-1;
            while (start < end) {
                if (substring[start++] != substring[end--]) {
                    return false;
                }
            }
            return true;
        };

        for (int i=start;i<s.length();i++) {
            string str = s.substr(start, i-start+1); // substr(index, length) --> creates substring from index+1 of size length 
            if (isPalindrome(str)) {
                temp.push_back(str);
                backtrack(temp, i+1, s);
                temp.pop_back();
            }
        }
    }
    vector<vector<string>> partition(string s) {
        vector<string> temp;
        backtrack(temp, 0, s);
        return answer;
    }
};
