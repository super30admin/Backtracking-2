class Solution:
    def partition(self, s: str):
        superset, subset = [], []
        N = len(s)

        def palindrome(substring):
            i, j = 0, len(substring)-1
            while i < j:
                if substring[i] != substring[j]:
                    return False
                i += 1
                j -= 1
            return True

        def backtrack(i):
            if i >= N:
                superset.append(subset.copy())
                return
            
            for j in range(i, N):
                substring = s[i:j+1]
                if not palindrome(substring):
                    continue
                
                subset.append(substring)

                #Fast Forward to "j" since we chose all the elements from it
                backtrack(j+1) 

                subset.pop()
        backtrack(0)
        return superset