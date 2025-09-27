class Solution(object):
    # tc : O(n*2^n) there are 2^ n calls we make, and at each does the palindrome checks and also deep copy while adding it into the result
    # sc : O(n*2) recursive stack and also the substring creation 
    def partition(self, s):
        # intiution 
        # check if the substr we choosen is a palindrome or not a, palindrome the partion left is ab check if ab is palindrome or not and so on ...
        # approach : doing a 0/1 recurssion, where at every index choosin to parition here or skip and parttion the later index 
        # once done the parition checkl if its palindrome and if it is then we move the partition point one step ahead,we stop once we reach till the end of the strng, i.e once we have processed all the elements in the sting
        # then we will add the path , where path is the paritions of the stin g where each partition is a palindrome 
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.result = []
        self.n = len(s)
        self.helper(0,0,0,s,[])

        return self.result
        

    def helper(self, pivot, idx,size, s, path):
        # base
        if idx == self.n : # check if we are at the end 
            if size == self.n: # and also making sure , that we have gng through the entire string 
                self.result.append(list(path)) # making a new path as result will have the refence of the path and as path gets ovrwirtten everytime , deep copying the snapshot at the time and adding its refeence into the result. 
            return 

        # not choose 
        self.helper(pivot,idx+1,size,s,path) # if not choosed to parition here we just move our idx to next pointer 
        
        substr = s[pivot:idx+1] # piviot is a start pointer and i is the end pointer of the parition which gives us the substr

        if self.isPalindrome(substr):
            
            # action
            path.append(substr) # if this parttion is a palindrome then we add out substr into the path and later adding it into the result

            # choose
            self.helper(idx+1,idx+1, size+len(substr),s, path) # since till idx we have taken for the substr the new paritin will be form the idx+1 ( from the end of the old parition will be ou new pivot)

            # backtrack
            path.pop() # since the path gets overwritten, before it goes back to the parent cell, we need to undoen the strign we added so we pop it up 

    def isPalindrome(self,s):
        left, right = 0, len(s) - 1
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True




