class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        '''
        T = O( N* (2^N) )
        S = O(2N) - involves recursive stack 
        '''
        
        def helper( s , idx   ):
            
            if idx >= len(s):
                result.append( list( current_partition )  )
                return 
            
            for i in range( idx , len(s)):
                curr_part = s[idx:i+1]
                if curr_part == ''.join(reversed( curr_part  )) :
                    current_partition.append( curr_part )
                    helper( s , i+1 )
                    current_partition.pop()
        
        
        result = []
        idx  = 0 
        current_partition = []
        helper( s , idx   )
        return result 
    
