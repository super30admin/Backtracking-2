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
                    newlist = temp[:]
                    newlist.append(s[index:i+1])
                    #recurse
                    backtrack(s, result, newlist, i+1)
                    #backtrack
                    #temp.pop()
                
        backtrack(s, result, [], 0)
        return result
    
    def ispallindrome(self, s):
        if s.lower() == s[::-1].lower():
            return True
        return False

#time complexity - O(n * 2^n)

#space complexity - O(n*2^n) as the newlist is created for every step

#all test cases passed