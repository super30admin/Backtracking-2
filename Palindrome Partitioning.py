# time complexity is o(n*2^n), where n is the size of the input
# space complexity is o(n*2^n), where n is the size of the input
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = list()
        self.helper(s, [], 0, result, len(s))
        return result
    
    def helper(self, s, temp, ind, result, l):
        if(ind == l):
            result.append(temp.copy())
            return

        for i in range(ind, l):
            sub = s[ind : i+1]
            if(self.ispalindrome(sub)):
                temp.append(sub)
                # print(temp)
                self.helper(s, temp, i + 1, result, l)
                temp.pop()
        
        
    def ispalindrome(self, strs):
        start = 0
        end = len(strs) - 1
        while(start < end):
            if(strs[start] == strs[end]):
                start += 1
                end -= 1 
            else:
                return False
        return True
        
        