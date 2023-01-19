# // Time Complexity : O(2^n)
# // Space Complexity : O(2^n)
# // Did this code successfully run on Leetcode : Yes
# // Three line explanation of solution in plain english 

# // Your code here along with comments explaining your approach
class solution:
    def partition(self, s):
        self.result = []
        self.helper(0, s, [])
        return self.helper

    def forloop_helper(self, idx,s , path ):
        '''
        in this for loop based recursion we use a pivot called index, we will start a for loop for pivot to end, and create 
        a substring from pivot to i+1 and check if it is palindrom. if it is then we add the next element to path and recurse from i +1 
        and then pop the element
        '''
        # base
        if idx >= len(s):
            self.result.append(copy.deepcopy(path))
            return
        #logic

        for j in range(idx, len(s)):
            if self.ispalindrome(s[idx:j+1]):
                path.append(s[idx:j+1])
                self.helper(j+1, s, path)
                path.pop()
    
    def helper(self, start, idx, count, s, path):

        # base
        if idx >= len(s):
            if count == len(s):
                self.result.append(copy.deepcopy(path))
                return
            return
        #logic

        ## choose
        sub = s[start:idx+1]
        if self.ispalindrome(sub):
            path.append(sub)
            self.helper(idx+1, idx+1, count+len(sub), s, path)
            path.pop()
        

        ##nochoose

        self.helper(start, idx+1, count s, path)



    def ispalindrome(self,s):
        if s == s[::-1]:
            return True
