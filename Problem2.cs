// Time Complexity : O(2^N * N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I pass pivot = 0 and call recursive Helper method where I perform for-loop based recursion. 

Base Condition for Helper Method - 
    If pivot = s.Length, create a deep copy of tempList and add it to result

Core Logic - 
    Loop from i = pivot to n : 
        1. Create substring from pivot to i
        2. if substring is a palindrome : 
            2.1 Add substring to tempList
            2.2 Call Helper on pivot = i + 1
            2.3 Backtrack by removing last element added to tempList
*/

public class Solution {
    List<IList<string>> result;
    public IList<IList<string>> Partition(string s) {
        result = new();
        Helper(s, 0, new List<string>());
        return result;
    }

    public void Helper(string s, int pivot, List<string> tempList)
    {
        // Base Condition
        if(pivot == s.Length)
        {
            result.Add(new List<string>(tempList));
            return;
        }

        // Core Logic
        for(int i = pivot; i < s.Length; i++)
        {
            string tempStr = s.Substring(pivot, i - pivot + 1);

            if(IsPalindrome(tempStr))
            {
                tempList.Add(tempStr);
                Helper(s, i + 1, tempList);
                tempList.RemoveAt(tempList.Count - 1);
            }
        }
    }

    public bool IsPalindrome(string s)
    {
        int low = 0, high = s.Length - 1;
        while(low < high)
        {
            if(s[low] != s[high])
            {
                return false;
            }

            low++;
            high--;
        }

        return true;
    }
}