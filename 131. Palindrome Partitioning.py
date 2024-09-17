#Time Complexity:O(2^n)
#Space Complexity:O(n)

class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        def checkPalindrome(str,startIndex,lastIndex):
            while startIndex <= lastIndex:
                if str[startIndex] != str[lastIndex]:
                    return False
                startIndex += 1
                lastIndex -= 1
            return True

        result=[]
        def backTrack(s,index,path):
            if index==len(s):
                result.append(path[:])
                return
            for i in range(index,len(s)):
                if checkPalindrome(s,index,i):
                    path.append(s[index:i+1])
                    backTrack(s,i+1,path)
                    path.pop()
        backTrack(s,0,[])
        return result
