//TC:- O(n * 2 ^n)
//SC:- O(n)
class Solution {

    List<List<String>> result;
    public List<List<String>> partition(String s) {
        
        //we will use for loop based recursion
        this.result = new ArrayList<>();

        //we store all the string in the path
        List<String> path = new ArrayList<>();
        backtrack(s, 0, path);
        return result;
    }

    public void backtrack(String s, int pivot, List<String> path) {

        //base condition
        if(pivot == s.length()) {

            //this means all the partitions we got in the path are palindrome
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        //if a string is a palindrome then we dig deeper
        for(int i = pivot; i < s.length(); i++) {

            String currPar = s.substring(pivot, i + 1);

            //if it is a palindrome we can add it to path
            //then we check the next letters in string
            if(isPalindrome(currPar, 0, currPar.length() - 1)) {

                //action :- add substring to path, check next substrings
                path.add(currPar);

                //recurse :- find whether next letters are palindrome
                backtrack(s, i + 1, path);

                //backtrack :- while going back remove letter from path
                path.remove(path.size() - 1);
            }
        }

    }

    public boolean isPalindrome(String s, int left, int right) {

        while(left < right) {

            if(s.charAt(left) != s.charAt(right))
                return false;
            
            left++;
            right--;
        }

        return true;
    }

}