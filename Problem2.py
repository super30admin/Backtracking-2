#Time complexity is: O(2^N)
#Space complexity is:O(2^N)
#Code ran successfully on leet code
#No issues faced while coding

class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        #Creating an empty list to store final result
        self.result=[]
        self.helper(s,0,[])
        return self.result
    
    def helper(self,s,pivot,path):
        #base
        #if the base condition is satisfied, we will add the path to the result
        if(pivot==len(s)):
            self.result.append(list(path))
            return
        #logic
        #Here we will be looping through the entire s
        for i in range(pivot,len(s)):
            #Here we are taking the substring from pivot to i
            sub=s[pivot:i+1]
            #Checking for the palindorme
            if(self.isPalindrome(sub)):
                #Appending the substring to the path
                path.append(sub)
                #recursion
                self.helper(s,i+1,path)
                #backtrack
                path.pop()

    #Method to check whther the string is palindrome or not
    def isPalindrome(self,string_input):
        start=0
        end=len(string_input)-1
        while(start<end):
            if(string_input[start]!=string_input[end]):
                return False
            start+=1
            end-=1
        return True