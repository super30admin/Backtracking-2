//time complexity O(n2^n)
//space complexity O(n2^n)
//APPROACH: Recursion
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        helper(s, new ArrayList<>(), 0);
        return result;
    }
    private void helper(String s, List<String> temp, int start){
        //base
        if(start == s.length()){
            result.add(temp);
            return;
        }
        //logic
        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s, start, i)){
                //action
                List<String> newList = new ArrayList<>(temp);
                newList.add(s.substring(start, i + 1));

                //recurse
                helper(s, newList, i + 1);
            }
        }

    }
    private boolean isPalindrome(String s, int l, int r){
        if(l == r) return true;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}

//time complexity O(n2^n)
//space complexity O(n)

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        backtrack(s, new ArrayList<>(), 0);
        return result;
    }
    private void backtrack(String s, List<String> temp, int start){
        //base
        if(start == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        //logic
        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s, start, i)){
                //action
                temp.add(s.substring(start, i+1));

                //recurse
                backtrack(s, temp, i + 1);

                //backtrack
                temp.remove(temp.size() - 1);
            }
        }

    }
    private boolean isPalindrome(String s, int l, int r){
        if(l == r) return true;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}
