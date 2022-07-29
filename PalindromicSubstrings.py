from pip import List
# Time Complexity => O(N.x^N) Exponential
# Space Complexity => O(N)

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        def isPalindrome(s, low, high):
            while(low<high):
                if(s[low]!=s[high]):
                    return False
                low+=1
                high-=1
            return True        
        
        def helper(index, currlist, result, s):
            if(index>=len(s)):
                result.append(currlist.copy())
                return
            for i in range(index, len(s)):
                if(isPalindrome(s,index,i)):
                    currlist.append(s[index:i+1])
                    helper(i+1, currlist,result, s)
                    currlist.pop()
        
        helper(0, [], result, s)
        return result
        