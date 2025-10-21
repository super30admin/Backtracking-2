# Space Complexity: O(h) -> h can max to s
# Time Complexity: O(2^n)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def pali(s): 
            i = 0
            j = len(s)-1

            while i <= j: 
                if s[i] != s[j]:
                    return False
                i+=1
                j-=1
            return True

        ans = []

        def helper(s, pivot, path):
            # Base Case
            if pivot >= len(s):
                ans.append(path[:])
                return 

            # Logic
            for i in range(pivot, len(s)):
                curr = s[pivot:i+1]
                if pali(curr):

                    #action
                    path.append(curr)

                    #recurse
                    helper(s, i+1, path)

                    #backtrack
                    path.pop()


        helper(s, 0, [])
        return ans
