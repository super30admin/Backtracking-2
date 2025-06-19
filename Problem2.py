# Time Complexity : O(n.2^n)
# Space Complexity : O(n.2^n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
# Three line explanation of solution in plain english:
"""1. We use recursion and for loop to explore all possible palindrome of the given string.
2. with the help of pivot index and iterating every character of the string unitl the pivot reaches end of string
3. only call the recursion if the substring is palindrome and add it to the path.
4. once the pivote reaches end of string return the result having the paths of all possible palindromes."""

#Your code here along with comments explaining your approach
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        
        """
        res=[]
        def backtrack(s,pivot,path):
            #check for pivot index out of bound 
            #append the path to result if pivot is at the end of string i.e when the path has valid palindromes
            if pivot==len(s):
                #copy the path to only append the palindromes found in a given path
                res.append(path[:])
            #iterating through the string from pivot to end of string     
            for i in range(pivot,len(s)):
                #select the substring from pivot index to i
                currStr=s[pivot:i+1]
                #check if substring is palindrome and append to the path if it is a valid palindrome
                if currStr==currStr[::-1]: 
                    path.append(currStr)
                    #call the recursion only if the substring is palindrome and move to the next index
                    backtrack(s,i+1,path)
                    #remove the last element in the path to backtrack
                    path.pop()
        backtrack(s,0,[])
        return res
