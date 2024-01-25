
# Solution

# // Time Complexity : O(2^n) since we will have choose no choose for each element, so if we build that tree there will be 2^n
#                      iterations. Valid for recursion, for loop recursion and the two for loop approach
#               
# // Space Complexity : O(N) because of implicit stack of recursion, max recursion will be N
#                       O(1) for the two for loop approach
# 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is to use choose/no choose option for each element, if we draw the tree we can visualise. In each step if we choose
# an element that gets added to the list, if we do not choose an element then existing list stays the same. So if we do not choose
# any element, we get empty list. This approach exhaustively goes through all branches to create the power set
# Approach2 is "For Loop Based Recursion", approach is almost same. Only thing is here we generally only take the choose scenario
# and append the not choose before considering the choose scenario
# Approach3 is to update empty list to result, then, for all the lists in result, copy the existing list and add each element one
# by one to all the lists. Lists keep getting added and size of result keeps getting updated
import datetime
def subsets(nums):
    # S30 and Leetcode User logic, trying to implement it,
    # As of now I think BFS takes 2^n
    res = []

    res.append([])
    for num in nums:
        for i in range(0,len(res)):
            res.append(res[i].copy())
            res[-1].append(num)
    
    return res

    # S30, for loop based recursion
    # def helper(nums,pivot,path,result):
    #     for i in range(pivot,len(nums)):
    #         path.append(nums[i])
    #         result.append(path.copy())
    #         helper(nums,i+1,path,result)
    #         path.pop()
    # result = [[]]
    # helper(nums,0,[],result)
    # return result
    # S30
    # def helper(nums,idx,path,result):
    #     if idx>=len(nums):
    #         result.append(path.copy())
    #         return
        
    #     path.append(nums[idx])
    #     helper(nums,idx+1,path,result)
    #     path.pop()
    #     helper(nums,idx+1,path,result)
        
    # result = []
    # helper(nums,0,[],result)
    # return result

    # DFS, My solution completed with help of user solution
    # As of now I think DFS takes n!
    # res = []
    # res.append([])

    # def dfs(begin,temp):
    #     res.append(temp.copy())
    #     for i in range(begin,len(nums)):
    #         temp.append(nums[i])
    #         dfs(i+1,temp)
    #         temp.pop()
    
    # for i in range(0,len(nums)):
    #     temp = []
    #     temp.append(nums[i])
    #     dfs(i+1,temp)
    # return res
            
    

if __name__ == "__main__":
    startTime = datetime.datetime.now()
    nums = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]
    print(subsets(nums))
    endTime = datetime.datetime.now()
    timeTaken = endTime - startTime
    print("Time Taken:",timeTaken.total_seconds())