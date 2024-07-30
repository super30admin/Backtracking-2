#####78. Subsets##################################################################################################################
// Time Complexity : n
// Space Complexity : Not sure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
We have taken initially an empty list than we are goin through the string and first element is combined with empty list and 2 elements are formed than the 2 elements are taken as source list and combined with next element give 4 results now

class Solution:
   
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result=[]
        l1=[]
        result.append(l1)
        #print(len(result))
        for i in nums:
            #len1=len(result)
            for j in range(len(result)):
                tmp=copy.deepcopy(result[j])
                tmp.append(i)
                result.append(tmp)
        print(result)
        return result


        


######131. Palindrome Partitioning#######################################################################################################


// Time Complexity : logn
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA

// Your code here along with comments explaining your approach in three sentences only
We have applied for based recursion and found all substring and than found which are palindrome

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result=[]
        l1=[]
        self.backtrack(result,l1,0,s)
        #print(result)
        return result


    def backtrack(self,result,l1,pivot,s):
        #base
        if pivot==len(s):
            #print('in base',l1)
            result.append(copy.deepcopy(l1))
            return

        #logic
        #print('----------->for loop start:',s,'<------------')
        for i in range(pivot,len(s)):
            cursubstr=s[pivot:i+1]
            #print(cursubstr)
            if self.isPalindrome(cursubstr):
                l1.append(cursubstr)
                #print('in for loop',l1, s)
                self.backtrack(result,l1,i+1,s)
            #print('backtrack')
                l1.pop()
        #print('------>for loop over',s)
    
    def isPalindrome(self,s) -> bool:
        i,j=0,len(s)-1
        #print(i,j)
        while i<=j:
            #print(s[i],s[j])
            if s[i]!=s[j]:
                return False
            i+=1
            j-=1
        return True