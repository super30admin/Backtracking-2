class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        if not s:
            return result
        def backtrack(s, result, temp, index):
            #base
            if index == len(s):
                result.append(temp[:])
                return
            #logic
            for i in range(index, len(s)):
                if self.ispallindrome(s[index:i+1]):
                    #action
                    temp.append(s[index:i+1])
                    #recurse
                    backtrack(s, result, temp, i+1)
                    #backtrack
                    temp.pop()
                
        backtrack(s, result, [], 0)
        return result
    
    def ispallindrome(self, s):
        if s.lower() == s[::-1].lower():
            return True
        return False

#time complexity - O(n*2^n)

#space complexity - O(n), as only temp is created as an extra data structure

#all testcases passed