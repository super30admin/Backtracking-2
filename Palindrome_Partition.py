# Created by Aashish Adhikari at 4:02 PM 1/29/2021

'''
Time Complexity:
At each node, (a) checking palindromeO(n) (b) Copying the initial substring O(n)
Total nodes 2 ^n since 2 decisions at each node.

Hence, O( (n ^2). (2 ^n))

Space Complexity:
O(n) to store the current path.
The substrings that we have stored are part of the solution returned and thus do not count.
'''

class Solution(object):

    def is_palindrome(self, word):

        for idx in range(len(word)/2):

            if word[idx] != word[len(word)-1-idx]:
                return False

        return True




    def recurse(self, s, current_sol, pos):

        # base case
        if pos == len(s):

            self.sols.append(copy.deepcopy(current_sol))



        else:

            for idx in range(pos, len(s)):

                initial_str = s[pos:idx+1]


                # if not palindrome discard the path, else continue
                if self.is_palindrome(initial_str):

                    # take action
                    current_sol.append(initial_str)
                    # recurse
                    self.recurse(s, current_sol, idx+1)
                    # backtrack
                    current_sol.pop()







    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """

        if len(s) == 0:
            return []


        self.sols = []
        self.recurse(s, [], 0)
        return self.sols
