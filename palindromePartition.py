class Solution:
    def partition(self, s: str) -> List[List[str]]:
        '''
        Time Complexity: O(2^n)
        Space Complexity: O(n)
        '''
        
        res = []
        
        def part(index,path):
            nonlocal res
            if(index==len(s)):
                res.append(path[:])
                return
            for i in range(index,len(s)):
                if(s[index:i+1]== s[index:i+1][::-1]):
                    path.append(s[index:i+1])
                    part(i+1,path)
                    path.pop()
        
        
        part(0,[])
        return res
