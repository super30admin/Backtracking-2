'''
Time complxity --> O(2^n)

Space complexity -->O(2^n)
'''
class Solution:
    def partition(self, s: str) -> List[List[str]]:

        if len(s)==0:
            return []
        result = []

        #Bcktrack function
        def backtrack(s, index, path):
            if index==len(s):
                result.append(path[:])   #Once the index reaches the end of the index append to result
                return
            else:
                for i in range(index, len(s)):
                    if isPlaindrome(s, index, i):
                        #print('Yes')

                        path.append(s[index:i+1])

                        backtrack(s, i+1, path)

                        path.pop()
        


        



        def isPlaindrome(s, l, r):
            while l<=r:
                if s[l]!=s[r]:
                    return False
                l+=1
                r-=1
            return True
                



        backtrack(s, 0, [])   
        return result