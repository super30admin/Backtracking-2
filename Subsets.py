class Solution(object):
    # tc : O(n*2^n) we will have 2^n calls, 1st iteration choose of 1 or not choose 2 options then 4 options and then 8 options and it taks n time for each subset to copy when enterign into the result 
    # sc : O(n) at once the max space occupied in path would be n 
    def subsets(self, nums):
    # intution
    # at every index we have two options take this cell or not , we take 1 we get a subset of 1 , if we choose not to take 2 and then we choose to take 3 we get [1,3]
    # so basic idea is to for every cell make combination of choosing that cell or not choosign which will give us the subsets
    # will use recurssion, and at every recursive call it goes from the left to right and add the elements in a path varuiable as we travser and decice which elene twe are chosng and add that element in out path varuiable
    # once we make a combiantion of all the cells be it choosing it or not choosing i.e hit the end of the arr then we add that path into the final output
    
        self.result = []
        self.n = len(nums)
        self.helper(0,[],nums)

        return self.result


    def helper(self,pivot,path,nums):
        # base 
        if pivot == self.n:
            self.result.append(list(path)) # since the path gets overwritten ,before adding the path into the result make a deep copy and store it. 
            return
        # lets say the path is of a refernce 420, if we save the path in the result we will have output of [[420], [420], whereas the 420 address gets overwritten so make a deep copy
        # like at an address 920 which will be the snapshot of 420 at that point and out final output will be like [[920], [1080].. etc] which gives the proper output. 

        # not choose case
        self.helper(pivot+1,path,nums)


        # action
        path.append(nums[pivot]) # if we choose this add it into the path 

        # recruse    
        # choose case
        self.helper(pivot+1, path,nums)

        # backtrack
        path.pop() # once we have done the left and right recrussion, we go to parent node while gng back our path should not have the nodes we added in this child node, 
        # so we need to pop it once we go back to our parent node ( in the stack) 

        return