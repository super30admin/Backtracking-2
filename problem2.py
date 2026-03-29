# problem 2

# https://leetcode.com/problems/palindrome-partitioning/
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.final_arr = []
        self.helper(s,0,[])
        return self.final_arr 

    def helper(self,s,pivot,path):
        if pivot == len(s):
            self.final_arr.append(list(path))
            return  
        for i in range(pivot,len(s)):
            sub_str = s[pivot:i+1]
            if self.isPalindrome(sub_str):
                path.append(sub_str)
                self.helper(s,i+1,path)
                path.pop()

    def isPalindrome(self,ip_str):
        i = 0 
        j = len(ip_str)-1
        while(i<j):
            if ip_str[i] != ip_str[j]:
                return False 
            i+=1
            j-=1
        return True