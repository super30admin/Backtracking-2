/**

 L.C: 131. Palindrome Partitioning

 Approach: Recursion with backtracking

 Time Complexity: 2^N
 Space Complexity: O(n)

 */

class PalindromePartitioning {

    List<List<String>> result;
    public List<List<String>> partition(String s) {

        if(s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        recurse(s, 0, new ArrayList<>());

        return result;
    }

    private void recurse(String s, int index, List<String> path) {

        //base
        if(index == s.length()) {
            result.add(new ArrayList<>(path));

        }

        //logic
        for(int i=index; i<s.length(); i++){

            String subStr = s.substring(index, i+1);

            if(isPalindrome(subStr)) {

                //action
                path.add(subStr);

                //recurse
                recurse(s, i+1, new ArrayList<>(path)); //i+1 because we

                //backtrack
                path.remove(path.size() - 1);
            }

        }
    }

    private boolean isPalindrome(String str) {


        int i = 0;
        int j = str.length()-1;

        while(i<j) {

            if(str.charAt(i) != str.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
