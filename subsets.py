# As taught in class, I used backtracking to solve this problm
#Time Complexity: exponential
#Space Complexity: O(n)
arr = []
nums = [1,2,3]
def subsets(nums):
    if nums is None:
        return
    helper(nums,0,[])
    return arr

def helper(nums,index,temp):

    arr.append(list(temp))
    for i in range(index,len(nums)):
        temp.append(nums[i])
        helper(nums,i+1,temp)
        temp.pop()

subsets(nums)
print(arr)