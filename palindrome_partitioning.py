class Solution:
    def partition(self, s: str) -> List[List[str]]:

        # T.C = O(l x 2^n)

        result = []
        n = len(s)

        def is_palindrome(s, l, r):
            while l<r:
                if not s[l] == s[r]:
                    return False
                l += 1
                r -= 1
            return True
        

        # for loop recursion with backtracking

        def recurse2(s, idx, path):
            # base
            if idx == n:
                result.append(list(path))
                return

            # logic
            for i in range(idx, n):
                if is_palindrome(s, idx, i):
                    #action
                    path.append(s[idx:i+1])

                    # recurse
                    recurse2(s, i+1, path)

                    # backtrack
                    path.pop()

        recurse2(s, 0, [])
        return result

        
        # for loop recursion without backtracking

        def recurse1(s, idx, path):
            # base
            if idx == n:
                result.append(path)
                #print(result)
                return

            # logic
            for i in range(idx, n):
                #print('check for str: ', s[idx:i+1])
                if is_palindrome(s, idx, i):
                    npath = list(path)
                    npath.append(s[idx:i+1])

                    recurse1(s, i+1, npath)

        recurse1(s, 0, [])
        return result












