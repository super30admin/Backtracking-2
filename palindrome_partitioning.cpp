// Time Complexity : O(n)
// Space Complexity :  Not sure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
private:
    vector<vector<string>> ret_vect;

    // Function to check if string is palindrome or not    
    bool check_pal_string(string s)
    {
        if(s.size() == 1 || s.size() == 0)
            return true;
        
        int low = 0;
        int high = s.size()-1;
        
        while(low <= high)
        {
            if(s[low] != s[high])
                return false;
            
            low++; high--;
        }
        
        return true;
    }
    
    // Function to check if string vector has palindromes or not
    bool check_palindrome(vector<string> &str_vect)
    {
        if(str_vect.size() == 0)
            return true;
        
        for(int i = 0; i < str_vect.size(); i++){
            if(!check_pal_string(str_vect[i]))
                return false;
        }
        
        return true;
    }
    
    // Recursive Function for Partitioning
    void partition_rec(string &s, int ptr, vector<string> str_vect)
    {
        if(ptr == s.size())
        {
            if(check_palindrome(str_vect))
                ret_vect.push_back(str_vect);
            
            return;
        }      
        
        // partition
        string temp_str;
        int ptr1 = ptr;
        temp_str += s[ptr1];
        ptr1++;
        vector<string> vect1 = str_vect;
        vect1.push_back(temp_str);
        
        partition_rec(s, ptr1, vect1);
        
        // no partition
        int ptr2 = ptr;
        vector<string> vect2 = str_vect;
        vect2[vect2.size()-1] += s[ptr2];
        ptr2++;
        
        partition_rec(s, ptr2, vect2);
    }
    
public:
    // Primary Function
    vector<vector<string>> partition(string s) {
        
        if(s.size() == 0)
            return ret_vect;
        
        int ptr = 0;
        
        vector<string> temp_str;
        string t;
        t += s[ptr];
        temp_str.push_back(t);
        
        ptr++;
        
        partition_rec(s, ptr, temp_str);
        
        return ret_vect;
    }
};