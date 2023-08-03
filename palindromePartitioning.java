//time: O(n^2) where n is length of string;
//space: O(n^2) where n is length of string;



public class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, List<String>path){
        if(pivot==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i =pivot; i<s.length(); i++){
            String subs = s.substring(pivot, i+1);
            if(isPalindrome(subs)){
                path.add(subs);
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;

        while(start < end){

            if(s.charAt(start) != s.charAt(end)){ 
                return false;
            }
            start++; end--;

        }

        return true;

    }

}
 {
    
}
