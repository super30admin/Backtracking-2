//Time Complexity: O(2^n)
//Space Complexity: O(2^n)

/*
 * In this approach we can do it with a for loop in recursion. At each iteration we will find the substring from pivot and i. If it a palindrome we add that character to the
 * path anf we move the i. We also backtrack after the action. When we reach the end of array we add the path to the result.
*/
//for loop recursion
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length()==0)return result;
        helper(s,0, new ArrayList<>());
        return result;
    }
    private void helper(String s, int index,  List<String> path){
        //base
        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = index ; i<s.length();i++){
            String sub = s.substring(index,i+1);
            if(isPalindrome(sub)){
                path.add(sub);
                helper(s, i+1 ,path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int start =0;
        int end= s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

//0-1 recursion
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length()==0)return result;
        helper(s,0, 0,new ArrayList<>());
        return result;
    }
    private void helper(String s, int pivot, int i,  List<String> path){
        //base
        if(i == s.length()){
            if(pivot == s.length()){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        //logic
        //not choose
        helper(s,pivot,i+1,path);
        //choose
        String sub = s.substring(pivot, i+1);
        if(isPalindrome(sub)){
            path.add(sub);
            helper(s,i+1,i+1,path);
            path.remove(path.size()-1);
        }

    }

    private boolean isPalindrome(String s){
        int start =0;
        int end= s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}