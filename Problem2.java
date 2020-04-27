// Time Complexity - O(n*n*2^n)
// Space Complexity - O(n*n)
//                      depth = n and checking palindrome string n
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        backtrack(s,0,new ArrayList<>());
        return result;
    }


    private void backtrack(String s, int index, List<String> path){

        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < s.length(); i++){
            String str = s.substring(index,i+1);
            if(isPalindrome(str)){
                path.add(str);
                backtrack(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int start = 0, end = s.length()-1;

        while(start<end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}