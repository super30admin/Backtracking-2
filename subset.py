class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        output =[]
        def backtrack(nums,index,path):
            
            output.append(list(path))
            
            for i in range(index,len(nums)):
                path.append(nums[i])   #add
                
                
                backtrack(nums,i+1,path)  #backtrack
                path.pop()             #remove
                
        backtrack(nums,0,[])
        return output
        
        
        # tc is o(nx2^N) because we have two options for each element in list either be present or absent and we have to store it in output list.
        #sc for each element there will be 2^n subsets and n elements are there therefore o(nx2^n)
