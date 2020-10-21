class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        def isPalindrome(s,start_ind, end_ind):
            while start_ind < end_ind:
                if s[start_ind] != s[end_ind]: return False
                start_ind += 1
                end_ind -=1
            return True
        
        def helper(start,s,temp):
            if start >=len(s):
                output.append(list(temp))
                
            for i in range(start,len(s)):
                substring = s[start:i+1]
                if isPalindrome(s,start,i):
                    temp.append(substring)
                    helper(i+1,s,temp)
                    temp.pop()
                    
                    
        output = []
        helper(0,s,[])
        return output
        
        #tc o(n2^n)
        #sc o(n)
                    
                
