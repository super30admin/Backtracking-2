#time: O(n*2^n)
#space: O(n)

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        def check(substring):
            start=0
            end = len(substring)-1
            while start<=end:
                if substring[start]!=substring[end]:
                    return False
                start+=1
                end-=1
            return True 

        def helper(s, ch, index , arr):
            if index == len(s):
                result.append(arr)
                return

            if ch == len(s):
                return 
            
            #not choose 
            helper(s, ch+1,index ,arr.copy())

            #choose
           
            substring = s[index: ch+1]
            if (check(substring)):
                arr.append(substring)
                helper(s, ch+1, ch+1 , arr.copy())
                #arr.pop()

        if len(s) ==0:
            return 
        result= []
        helper(s, 0 ,0, [])
        return result
        