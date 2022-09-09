# TC : O(2^n)
# SC : O(n)
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.nums=nums
        self.result = []
        self.recur(0,[])
        return self.result
        
    def recur(self,i,path):
        
        #base
        if(i==len(self.nums)):
            self.result.append(path)
            return
        
        #logic
        #no choose
        self.recur(i+1,path[:])
        
        path.append(self.nums[i])
        
        #choose
        self.recur(i+1,path[:])

# TC : O(2^n)
# SC : O(1)
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = [[]]
        for num in nums:
            size = len(result)
            for i in range(size):
                temp = result[i][:] 
                temp.append(num)
                result.append(temp)
        return result
