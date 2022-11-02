class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        op = []
        def dfs(index, arr):
            if(index == len(s)):
                temp = list(arr)
                op.append(temp)
                return
            
            for i in range(index, len(s)):
                val = s[index:i+1]
                if(val == val[::-1]):
                    arr.append(s[index:i+1])
                    dfs(i+1, arr)
                    arr.pop()
        dfs(0, [])
        return op