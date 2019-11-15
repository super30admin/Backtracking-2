#leetcode:accepted
#time comlexity: 2^n (they are making choice)
#space complexity: 2^n
#explaination: see every line


class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
         """
        result=[]
        
        #calling a helper function
        self.check(s,[],result)
        
        #returning the result
        return result
    
    
    def check_palindrome(self,s):
        
        #just a function to check if its a palindrome, if its a palindrome we add it in the temp list
        if s[::]==s[::-1]:  #python way to find palnidrome
            return True
        return False
    
    def check(self,s,temp,result):
        print(s)
        if s: 
            for i in range(0,len(s)):
                #considering letter by letter
                print(i)
                print("s:",s[:i+1])
                if self.check_palindrome(s[:i+1]):
                    #if its a palndrome then appending it to the list
                    temp.append(s[:i+1])
                    print("temp",temp)
                    #calling the check with the next letter
                    self.check(s[i+1:],temp,result)
                    print("popping")
                    temp.pop()
        else:
            #after reaching end of strinf we add it to resultant list
            result.append(temp[:])
            print("result",result)
                