#Approach - For loop based recursion 
#Time complexity : O(n*(2^n))) here n is number of elements and n is for checking the substring is palindrone or not in each recursion
#Space complexity : O(n) where n is the depth of tree
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=ciYRVgANgbM&ab_channel=%7BS30%7D
class Solution:
    def __init__(self):
        self.result = []
    def partition(self, s: str) -> List[List[str]]:
        #checking null condition
        if s == None or len(s) ==0:
            return self.result
        #calling the recursion function
        self.helper(s, 0, [])
        return self.result
    def helper(self, s : str, index : int, path : List[str]):
        #base condition
        #when the pointer goes out of bound then we will append the path to the result
        if index == len(s):
            self.result.append(list(path))
        #logic
        #for loop based recursion will work from the coming index to the last element in the list
        for i in range(index, len(s)):
            #sb will store the string that will store the current string produced at each step and it won't store the already generate string in the path
            sb = s[index:i+1] 
            #checking if the current substring is palindrone if it is then it is added to the path and further it calls the recursion and if it is not then it won't call the recursion on that substring
            if self.isPalindrone(sb):
                #action
                path.append(sb)
                #recurse
                self.helper(s, i+1, path)
                #backtrack
                path.pop()
    #checking if the current substring is palindrone or not 
    def isPalindrone(self, s: str):
        start = 0
        end = len(s)-1
        #while loop will work till the start cross the end 
        while start<end:
            if s[start] != s[end]:
                return False
            start +=1
            end -=1
        return True
