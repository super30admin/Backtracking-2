class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.recurse(s, [], 0)
        return self.result

    def recurse(self, s, path:List[int], pivot: int):
        #base
        if pivot >= len(s):
            self.result.append([n for n in path])
            return self.result
         
        #logic
        for i in range(pivot, len(s)):            
            sub_string = s[pivot : i+1] 
            # capture the substring between pivot and index (index + 1 as the last index is not considered in the range).
            # If this substring is palindrome, only then we recurse forward 
            if self.isPlaindrome(sub_string):
                #action
                path.append(sub_string)

                #recurse
                self.recurse(s, path, i + 1)

                #backtrack
                path.pop()
            
    def isPlaindrome(self, sub:str):
        l = 0
        r = len(sub)-1
        while l <= r:
            if sub[l] != sub[r]:
                return False
            l += 1
            r -= 1
        return True