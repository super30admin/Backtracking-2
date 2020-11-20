class Solution:
    def partition(self, s: str) -> List[List[str]]:
        output = []
        if not s:
            return s
        
        def helper(curr, index):
            if index == len(s):
                output.append(curr[:])
            else:
                for i in range(index, len(s)):
                    if s[index:i+1]==s[index:i+1][::-1]:
                        curr.append(s[index:i+1])
                        helper(curr, i+1)
                        curr.pop()
                return output
        return helper([], 0)
    
Time: Visualise Tree, For input N, 8 nodes, 2^N times number of nodes
Space: O(N)