class Solution(object):
    
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        output =[]
        def isPalindrome(s):
            left = 0
            right = len(s) - 1
            while(left<=right):
                if s[left] != s[right]:
                    return False
                left += 1
                right -= 1
            return True                    
        
        def recur(index,temp):
            if index>=len(s):
                output.append(temp[:])
            for i in range(index,len(s)):
                sub_str = s[index:i+1]
                if isPalindrome(sub_str):
                    temp.append(sub_str)
                    recur(i+1,temp)
                    temp.pop()
        recur(0,[])
        return output