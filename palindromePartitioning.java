/* 131. Palindrome Partitioning
Time Complexity: 2 choices, pick or dont pick O(n.2^n) worst case, when everything is a palindrome like 'aaaaa'
Space Complexity:

call the backtrack function only when the parent string is a palindrome
check whether a picked string is a palindorme
add the tempList of each path to the resultant list
aab, the backtrack tree has a root 'aab', first branch, pick 'a', next 'aa', next 'aab'. when the parent is not a palindrome, do not continue

example: aba - three children [a, ab, aba] for 'ab' branch not a palindrom so dont continue
*/

class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> temp = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return result;
    }

    private void backtrack(String s, int start){
        //Base Case
        if(start >= s.length() && temp.size() > 0)
            result.add(new ArrayList<>(temp));

        //Logic
        for(int i=start; i<s.length(); i++){
            if(is_palindrome(s, start, i)){
                if(start == i) //for 'a' first letter (0 == 0)
                    temp.add(Character.toString(s.charAt(i)));
                else
                    temp.add(s.substring(start, i+1)); // 'aa'

                //remaining number of combinations
                backtrack(s, i+1);
                //backtrack
                temp.remove(temp.size() - 1);
            } // remember backtrack should happen inside 'if' why? because we continue a branch only is the parent or the root of it is a palindorme
        }
    }

    //compare character by character, 2 pointer approach
    private boolean is_palindrome(String s, int l, int r){
        if(l==r)  //'a'
            return true;

        while(l<r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    // private boolean is_palindrome(String s, int l, int r){
    //     String t = s.substring(l, r+1);
    //     String reverse = new StringBuffer(t).reverse().toString();
    //     return t.equals(reverse);
    // }
}