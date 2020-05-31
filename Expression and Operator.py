#Time Cokplexity : O(3^N) where N is number of elements in string
##Time Cokplexity : O(3^N) where N is number of elements stored in stack

class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        result = []
        if len(num) == 0:
            return result
        
        
        def helper(num,path,index,calc,tail):
            if index == len(num):
                if calc == target:
                    result.append(path)
                return
                    
            for i in range(index,len(num)):
                if index!=i and num[index] =='0':
                    break
                curr = int(num[index:i+1])
                
                if index == 0:
                    helper(num,path+str(curr),i+1,curr,curr)
                else:
                    helper(num,path + "+" + str(curr),i+1,calc+curr,curr)
                    helper(num,path + "-" + str(curr),i+1,calc-curr,-curr)
                    helper(num,path + '*' + str(curr),i+1,calc-tail + tail*curr,tail*curr)
        helper(num,"",0,0,0)
        return result
===========================================================================================
