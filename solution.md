# Problem 1
## Time Complexity :
O(2^n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No. 

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def subsets(self, nums: List[int]) -> List[List[int]]:
              result = []
              #Edge case
              if not nums or len(nums)==0:
                  return result
              def backtrack(nums, index, temp, result):
                  #Base Case
                  if index>len(nums):
                      return result
                  result.append(list(temp))
                  for i in range(index, len(nums)):
                      #Action
                      temp.append(nums[i])
                      #Recurse
                      backtrack(nums, i+1, temp, result)
                      #Backtrack
                      temp.pop()
              backtrack(nums, 0, [], result)
              return result

# Problem 2
## Time Complexity :
O(2^n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
No

## Any problem you faced while coding this :
Yes. Cannot fighure out the error.

## Your code here along with comments explaining your approach
### Solution:
          class Solution:
              def partition(self, s: str) -> List[List[str]]:
                  result=[]
                  #Edge Case
                  if not s or len(s)==0:
                      return result
                  def backtrack(s,index,temp,result):
                      if index==len(s):
                          result.append(list(temp))
                          return result
                      for i in range(index,len(s)):
                          if(isPalindrome(s,index,i+1)):
                              #Action
                              temp.append(s[index:i+1])
                              #Recurse
                              backtrack(s,i+1,temp,result)
                              #Backtrack
                              temp.pop()
                  def isPalindrome(s,l:int,r:int):
                      while(l<r):
                          if s[l]!=s[r]:
                              return False
                          l+=1
                          r-=1
                      return True
                  backtrack(s,0,[],result)
