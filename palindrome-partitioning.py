# without backtrack

# Run a loop i from pivot to len(s). Check if the substring from pivot to i+1 is a palindrome
# If it is  a palindrome, call recursive function with pivot =i+1 and path=path+ss. If pivot is
# out of bounds, append path to result.

# time: O(n.2^n)
# space: O(n)

class Solution(object):

    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.result=[]
        self.helper(s,0,[])
        return self.result
    
    def helper(self, s,pivot,path):
        if pivot==len(s):
            self.result.append(path[:])
            return


        for i in range(pivot, len(s)):
            ss=s[pivot:i+1]
            # print(ss,ss[::-1])
            if ss==ss[::-1]:
                self.helper(s,i+1,path+[ss])
                

            












#Using Backtracking

# Run a loop from pivot to len of s. check if substring of i to pivot is palindrome. 
# If it is palindrome, append the sustring to path and call recursive func with pivot=i+1.
# Pop the path for backtracking. If pivot is out of bound, append the path copy to result

# Time: O(2x2^n)
# Space: O(2^n)
class Solution(object):

    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.result=[]
        self.helper(s,0,[])
        return self.result
    
    def helper(self, s,pivot,path):
        if pivot==len(s):
            self.result.append(path[:])
            return


        for i in range(pivot, len(s)):
            ss=s[pivot:i+1]
            # print(ss,ss[::-1])
            if ss==ss[::-1]:
                path.append(ss)
                self.helper(s,i+1,path)
                path.pop()