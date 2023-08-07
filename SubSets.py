#Time Complexity: O(2^n)
#Space Complexity: O(n) 

# 0-1 Approach
class Solution:
    global outputList
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.outputList=[]
        self.helper(0,nums,[])
        return self.outputList

    def helper(self, i,array, path):
        #Base
        if i==len(array):
            self.outputList.append(path)
            return
        #Logic
        #Not choose
        self.helper(i+1,array,path[::])
        #choose
        path.append(array[i])
        self.helper(i+1,array,path[::])

# 0-1 with backtracking

class Solution:
    global outputList
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.outputList=[]
        self.helper(0,nums,[])
        return self.outputList

    def helper(self, i,array, path):
        #Base
        if i==len(array):
            self.outputList.append(path[::])
            return
        #Logic
        #Not choose
        self.helper(i+1,array,path)
        #choose
        path.append(array[i])
        self.helper(i+1,array,path)
        path.pop()


#For Loop
class Solution:
    global outputList
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.outputList=[]
        self.helper(0,nums,[])
        return self.outputList

    def helper(self, pivot ,array, path):
        #Base
        self.outputList.append(path[::])
        #Logic
        
        for i in range(pivot, len(array)):
            path.append(array[i])
            self.helper(i+1,array,path)
            path.pop()
            
            

        