# Time Complexity :
# O(N* 2^(N))

# Space Complexity :
# O(N) - max Stack depth

# Did this code successfully run on Leetcode :
#Yes

#We do for loop based recursion - for each value of the pivot, we check if srting[pivot : i+1] is a palindrome - if it is, then we add that to the path and go forward. If it isn't, then we do not add it to the path. 
#When it is a palindrome and keep going in - when the pivot reaches the end, then we know we have found a set of partitions with all palindromes. Then we add it to our result

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.return_partitions = []
        self.for_loop_recursion(s,0,[])
        return self.return_partitions

    def for_loop_recursion(self,s,pivot,path):
        if pivot == len(s):
            self.return_partitions.append(path[:])
            return
        
        for i in range(pivot,len(s)):
            substring = s[pivot:i+1]
            if self.is_palindrome(substring) :
                path.append(substring)
                self.for_loop_recursion(s,i+1,path)
                path.pop(-1)

    def is_palindrome(self,string):
        #print ("string", string)
        for i in range(0,int(len(string)/2)):
            #print (string[i],string[-(i+1)])
            if string[i] != string[-(i+1)]:
                return False
        return True
