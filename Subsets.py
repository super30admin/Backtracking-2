class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result=[]
        
        def print_subsets(inp,out):
            if len(inp)==0:
                result.append(out)
                return
            
            out1=out[:]
            out2=out[:]
            
            out1.append(inp[0])
            inp=inp[1:]
            
            print_subsets(inp,out1)
            print_subsets(inp,out2)
            
        print_subsets(nums,[])
        
        return result