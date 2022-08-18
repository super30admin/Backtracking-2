#Time Complexity : o(n*2^n)
#Space Complexity : o(n)
class Solution:
    result = []

    def helper(self, s, index, path):
        #base
        if index == len(s):
            self.result.append(list(path))
            return

        #logic
        for i in range(index, len(s)):
            sb = s[index : i+1]
            print(sb)
            if (self.pelindrome(sb)):
                #action

                path.append(sb)
                #print(path)

                #recurse
                self.helper(s, i+1, path)

                #backtrack
                path.pop()

    def pelindrome(self, s):
        l = 0
        h = len(s) - 1
        flag = True
        while(l <= h):
            if s[l] != s[h]:
                flag = False
                break
            l = l + 1
            h = h - 1

        return flag

    def partition(self, s: str) -> List[List[str]]:
        self.result = []

        self.helper(s, 0, [])
        return self.result