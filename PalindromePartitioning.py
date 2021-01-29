'''
    Time Complexity:
        O(n^2 * 2^n)
        (2^n because the tree would have at the most 2^n children)
        (n^2 because additionally, at each step we are creating a deepcopy of the
        current array and a substring)

    Space Complexity:
        O(n)
        (this is the only additional stack trace memory this algorithm uses)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Backtracking.
        The tree for tool would look like the following.
        I branch would be followed only if the current substring is a palindrome.
        ''
            t
                o
                    o
                        l
                    ol
                oo
                    l
                ool
            to
                o
                    l
                ol
            too
                l
            tool
'''
class Solution:
    def __init__(self):
        self.str = ''
        self.partitions = []

    def partition(self, s: str) -> List[List[str]]:
        self.str = s
        self.generate_partitions(0, [])

        return self.partitions

    def generate_partitions(self, idx, curr):
        if idx == len(self.str):
            self.partitions.append(deepcopy(curr))
            return

        for i in range(idx, len(self.str)):
            sub_str = self.str[idx: i+1]

            if not Solution.is_palindrome(sub_str):
                continue

            curr.append(sub_str)
            self.generate_partitions(i + 1, curr)
            curr.pop()


    @staticmethod
    def is_palindrome(sub_str):
        i = 0
        j = len(sub_str) - 1

        while i < j:
            if sub_str[i] != sub_str[j]:
                return False

            i += 1
            j -= 1

        return True
