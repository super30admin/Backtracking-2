def partition(s):
        result = []
        def is_palindrome(s):
            return s == s[::-1]
        
        def helper(s, pivot, interim):
            #base case
            #out of bound
            if pivot > len(s) - 1: 
                nonlocal result
                result.append(list(interim))

            
            for i in range(pivot, len(s)):
                if is_palindrome(s[pivot:i+1]):
                    # add
                    interim.append(s[pivot:i+1])
                    #recurse
                    helper(s, i + 1, interim)
                    #backtrack
                    interim.pop()

        helper(s, 0, [])
        return result


