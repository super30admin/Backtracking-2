// Time Complexity : O(e^N) N- number of elements in given array
// Space Complexity :recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Code in C++

class Solution {
    
    public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> result; //declare result array 
        vector<string> temp;    //declare a running array(subset of result)
        //Edge case
        if(s.empty()||s.length()==0) //check if given string is empty or NULL
            return{};
        
        backprop(s,result,temp,0); //call backprop function
        return result;
    }
        
private:
        void backprop(string s,vector<vector<string>> &result,vector<string> &temp,int index)
        {
            //Base case
            if(index==s.length()) //return result when index reaches last character in string
            {   
                result.push_back(temp); //push running array into result vector
                return;
            }
            
            if(index>s.size()) //if index reaches out of bounds, return
                return;
            
            //Logic
            for(int i=index;i<s.length();i++) //run through entire loop
            {
                
                if(isPalindrome(s.substr(index,i-index+1))) //check if current string is palindrome
                {
                    temp.push_back(s.substr(index,i-index+1));  //push into running array if substring is a palindrome              
                    backprop(s,result,temp,i+1); //excute backprop function with incrementing next character in string
                    temp.pop_back(); //remove last inserted character from running array
                }
                
            }//End of For loop
                       
        }//End of function
        
    
    bool isPalindrome(string s) //function to check if current string is palindrome 
    {
        int l,r;
        l=0,r=s.length()-1; //two variables holding first and last position of current string
        while(l<r) //check to see if two variables dont cross each other
        {
            if(s[l]!=s[r])
                return false; //return false if characters dont match
            l++;
            r--;
        }
        return true;
    }
        
    
};