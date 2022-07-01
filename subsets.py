#code using backtracking
#TC:O(2^n)
#SC:O(n)
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res=[]
        def helper(nums,idx,path):
            #base
            if len(nums)==idx: 
                res.append(path[:])
                return
            #logic
            #no choose
            helper(nums,idx+1,path)
            #choose
            path.append(nums[idx])
            helper(nums,idx+1,path)
            #backtrack
            path.pop()
        
        helper(nums,0,[])
        return res

#code using normal recursion with out backtracking and with choose case first and then no choose.

'''
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res=[]
        def helper(nums,idx,path):
            #base
            if len(nums)==idx: 
                res.append(path)
                return
            #logic
            #choose
            li=path[:]
            li.append(nums[idx])
            helper(nums,idx+1,li)
            #no choose
            helper(nums,idx+1,path[:])
        
        helper(nums,0,[])
        return res
'''
#code using for loop recursion and backtracking
'''
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res=[]
        def helper(nums,idx,path):
            #base case will be taken care by for loop
            #if idx==len(nums):
                #res.append(path[:])
                #return
            res.append(path[:])
            #logic
            for i in range(idx,len(nums)):
                path.append(nums[i])
                helper(nums,i+1,path)
                path.pop()
        
        helper(nums,0,[])
        return res
'''

#code using for loop recursion with out backtracking

'''
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res=[]
        def helper(nums,idx,path):
            #base
            
            #logic
            res.append(path)
            for i in range(idx,len(nums)):
                temp=path[:]
                temp.append(nums[i])
                helper(nums,i+1,temp)
        
        helper(nums,0,[])
        return res
'''

#code using nested for loop
'''
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res=[[]]
        for i in range(len(nums)):
            for j in range(len(res)):
                li=res[j][:]
                li.append(nums[i])
                res.append(li)
        return res
'''