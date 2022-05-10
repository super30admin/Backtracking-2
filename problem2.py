#Palindrome partitioning

# // Time Complexity : O(N!) factorial as we are looking for the rest of the array everytime 
# // Space Complexity : O(N) as recursion stack could hold all the values
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no




class Solution:
    def partition(self, s):
        res=[]
        path=[]
        def helper(s, index):
            if (index==len(s)):                                     #if you reach to the end, append path to the result
                res.append(path.copy())
                return
            
            for i in range(index, len(s)):                          #from the range of index to the end
                if (palin(s, index, i)):                            #if its a palindome, then add to the path and run recursion to the rest of the array
                    path.append(s[index: i+1])
                    helper(s, i+1)
                    path.pop()                                      #backtrack
        helper(s,0) 
        return res
    
def palin(s, i, j):                 #checks if s is a palindrome given a range form i to j
    while(i<j):
        if(s[i]!=s[j]):
            return False
        i+=1
        j-=1
    return True

