#Time Complexity: O(N*2**N)
#Space Complexity: O(N)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        li = []
        def ispalindrome(strr):
            flag = True
            low = 0
            high = len(strr) - 1
            while low < high:
                if strr[low] != strr[high]:
                    flag = False
                    break
                low +=1
                high -=1
            return flag
                
        def helper(index,path):
            #base
            if index == len(s):
                li.append(path.copy())
                return
            #logic
            for i in range(index,len(s)):
                if ispalindrome(s[index:i+1]):
                    path.append(s[index:i+1])
                    helper(i+1,path)
                    path.pop()
        helper(0,[])
                
        return li