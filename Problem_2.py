#TC: O(N*2^N)
#SC: O(N*2^N)

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def helper(list1, idx):
            #base
            if idx == len(s):
                self.res.append(list(list1))
                return

            for i in range(idx, n):
                #action
                temp = s[idx:i+1]
                if temp == temp [::-1]:
                    li = list(list1)
                    li.append(temp)
                    #recurse
                    helper(li, i+1)
                    #backtrack
                    # list1.pop()

        self.res = []
        n = len(s)
        helper([], 0)
        return self.res