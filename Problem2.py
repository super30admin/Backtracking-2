# Apace  -> On
# Time NO(2^N)
# Logic -> use helper and pivot to find all the partitions and validate if those are palindrome or not

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []

        def isPalindrome(startIndex, endIndex):
            if startIndex >= endIndex: return True
            return s[startIndex] == s[endIndex] and isPalindrome(startIndex+1, endIndex-1)

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