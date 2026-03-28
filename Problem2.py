class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []

        def isPalindrome(startIndex, endIndex):
            if startIndex >= endIndex: return True
            return s[startIndex] == s[endIndex] and isPalindrome(startIndex+1, endIndex-1)
            # while left<=right:
            #     if s[left]!=s[right]:
            #         return False
            #     left+=1
            #     right-=1
            return True
        def helper(pivot, partitionsList):
            if pivot == len(s):
                result.append(partitionsList[:])
                return
            for i in range(pivot, len(s)):
                if not isPalindrome(pivot, i):
                    continue
                subString = s[pivot:i+1]                
                partitionsList.append(subString)
                helper(i+1, partitionsList)
                partitionsList.pop()
        helper(0, [])
        return result