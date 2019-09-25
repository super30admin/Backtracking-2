class Solution(object):
    
    def partition(self, input_string):
        """
        Partition a palindrome into subsets of palindromes

        logic is similar to power set
        palindrome_partitioning("abacaba") = { "a" , palindrome_partitioning("bacaba") } +
                                            { "aba" , palindrome_partitioning("caba") } +
                                            { "abacaba"}

        Time complexity :  O(c^n)
      
        Space complexity : O(n)
      
        Run on leet code : yes
      
        Edge Cases : s = ""

        :param input_string: string to partition
        :return: set of all partitions
        """
        if input_string == "":
            return [[""]]
        
        return self._palindrome_partitioning(input_string[0], input_string) + (
                [[input_string]] if self.is_palindrome(input_string) else [])
        
    def is_palindrome(self, s):
        """
        Checks if string is palindrome
        :param s: string
        :return: boolean indicating whether palindrome or not
        """
        return s == s[::-1]
    
    def merge_palindrome_to_partition(self, p, partitions):
        """
        merges partition p to an existing list of partitions
        :param p: start partition
        :param partitions: existing partition list
        :return: merged partition list
        """
        return [[p] + e for e in partitions] if partitions else [[p]]
    
    def next_palindrome(self, old_start_partition, input_string):
        """
        Returns next start partition.
        if input string is "" it returns ""
        :param old_start_partition:  previous start partition .
        :param input_string: input string
        :return: next start partition
        """
        
        if input_string == "":
            return None
        
        if old_start_partition == input_string:
            return input_string
        
        partition_start = len(old_start_partition) + 1
        while not self.is_palindrome(input_string[:partition_start]):
            partition_start += 1
            if len(input_string) < partition_start:
                return None
            # this should exit because input string is a palindrome
        
        return input_string[:partition_start]
    
    def _palindrome_partitioning(self, start_partition, input_string):
        """
        We exit when start_partition == input string
        :param start_partition:
        :param input_string:
        :return:
        """
        result = []
        
        if start_partition == input_string:
            return []
        
        while (start_partition != input_string) and (start_partition is not None):
            result += self.merge_palindrome_to_partition(
                start_partition, self.partition(input_string[len(start_partition):]))
            start_partition = self.next_palindrome(start_partition, input_string)
        return result


if __name__ == "__main__" :
    print(Solution().partition("aaaaa"))