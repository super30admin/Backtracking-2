import java.util.ArrayList;
import java.util.List;
class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        // partitionHelper(s, new ArrayList<>(), 0, 0);
        partitionHelper(s, new ArrayList<>(), 0);
        return result;
    }

    // private void partitionHelper(String s, List<String> path, int pivot, int i, int sizeofpartitions)
    private void partitionHelper(String s, List<String> path, int pivot)
    {
        // // a. recursion with choose and not choose + backtracking
        // // base
        // if(i == s.length())
        // {
        //     if(s.length() == sizeofpartitions)
        //     {
        //         // add if all char of s are part of partitions
        //         result.add(new ArrayList<>(path));
        //     }
        //     return;
        // }

        // // logic
        //     // action
        //     // recurse
        // // not choose
        // partitionHelper(s, path, pivot, i+1, sizeofpartitions);
        // // choose
        // String substr = s.substring(pivot, i+1);
        // if(isPalindrome(substr))
        // {
        //     path.add(substr);
        //     partitionHelper(s, path, i+1, i+1, sizeofpartitions+substr.length());
        //         // backtrack
        //     path.remove(path.size() - 1);
        // }

        // b. recursion + for loop + backtrack
        // base
        if(pivot == s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        for(int i = pivot; i < s.length(); i++)
        {
            // action
            String substr = s.substring(pivot, i+1);
            // recurse
            if(isPalindrome(substr))
            {
                path.add(substr);
                partitionHelper(s, path, i+1);
                // backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s)
    {
        int left = 0, right = s.length() -1;
        while(left <= right)
        {
            if(s.charAt(left) != s.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}