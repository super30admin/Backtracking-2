#Approach: For loop without recursion
#Time Complexity 2^n  => o(2^n)
#Space Complexity O(1)
#It successfully runs on leetcode

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
            res = list([])
            res.append([])
            for i in range(len(nums)):                
                for j in range(len(res)):
                    row = list(res[j])
                    row.append(nums[i])
                    res.append(row)
            return res

#Approach: For loop recursion
#Time Complexity 2^n  => o(2^n)
#Space Complexity O(n) recursive stack
#It successfully runs on leetcode
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
            def findsubset(nums,idx,path):
                result.append(list(path)) 
                for i in range(idx,len(nums)):
                    path.append(nums[i])
                    findsubset(nums, i+1, path)
                    path.pop()

            result = []
            findsubset(nums, 0, [])
            return result 



#Approach: Choose not choose recursion
#Time Complexity n * 2^n  => o(2^n)
#Space Complexity O(n) recursive stack
#It successfully runs on leetcode 
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def findsubset(nums,i,path):
            if i==len(nums): 
                result.append(list(path)) 
                return
            #not choose
            findsubset(nums, i+1, path)
            #choose
            path.append(nums[i])
            findsubset(nums, i+1, path)
            path.pop()
        
        result = []
        findsubset(nums, 0, [])
        return result