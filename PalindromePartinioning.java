/*Time Complexity: O(2^n)
Space Complexity: O(n)
Approach: Here, we call the recursive function "backtrack" only when the current string is a palindrome
if its a palindrome, add path to the resultant lis
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
			//aab, the current tree has root at 'aab', first branch, pick 'a', next 'aa', next 'aab'. dont process the subtree if parent isnt a palindrome
            if(is_palindrome(s, start, i)){
                if(start == i) //for 'a' first letter (0 == 0)
                    temp.add(Character.toString(s.charAt(i)));
                else
                    temp.add(s.substring(start, i+1)); // 'aa'

                backtrack(s, i+1);
                //backtrack
                temp.remove(temp.size() - 1);
            } // backtracking when we know that the parent of current, is a palindorme
        }
    }

    private boolean is_palindrome(String s, int l, int r){
        if(l==r)  //'a'
            return true;

        while(l<r){
            if(s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
} 