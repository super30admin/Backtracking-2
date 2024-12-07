// we can build the combination of the given the string such that we can choose or no chose the char 
// adding that char to the string we can check wther that is the pallindrome or not and add that to the
// result list
class Solution {
    vector<vector<string>>result;
private:
    bool isPallindrome(string s)
    {
        int start = 0;
        int end = s.size()-1;
        
        while(start < end)
        {
            if(s[start] != s[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
private:
    void helper(string s, int start,vector<string>&list)
    {
        //base condition
        if(start == s.size())
        {
            result.push_back(list);
            return;
        }
        string substring ="";
        //logic
        for(int i = start ; i < s.size();i++)
        {
            substring += s[i];
            if(isPallindrome(substring))
            {
                list.push_back(substring);
                helper(s,i+1,list);
                list.pop_back();
            }
        }
    }
public:
    vector<vector<string>> partition(string s) {
        vector<string>list;
        
        helper(s,0,list);
        return result;
    }
};