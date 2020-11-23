class Solution:
    def partition(self, s: str) -> List[List[str]]:
        num = s
        def helper(temp, index):
            #base
            if index == len(num):
                res.append(temp.copy())
                return
            
            #logic
            for i in range(index, len(num)):
                #action
                if num[index:i+1] == num[index:i+1][::-1]:
                    temp.append(num[index:i+1])
                    
                    #recursion
                    helper(temp, i+1)

                    #backtrack
                    temp.pop()
            
        
        res = []
        temp = []
        helper(temp, 0)
        return res
            
            
        
        
        
        