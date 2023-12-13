// Time Complexity: O(2^n) - n is the number of elements
// Space Complexity: O(h)  - h is the height of the recursive stack
// Solution-1 - For loop based recursion
class Solution {
    List<List<String>> result;
    List<String> path;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        helper(s, 0);
        return result;
       
    }

    private void helper(String s, int pivot){
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
        }

        for(int i=pivot; i< s.length(); i++){
            String sub = s.substring(pivot, i+1);
            if(isPalindrome(sub)){
                path.add(sub);
                helper(s, i+1);
                path.remove(path.size()-1);
            }
        }
    }


    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() -1;

        while(start < end)
            if(s.charAt(start++) != s.charAt(end--)) return false;
        return true;
    }
}

// Time Complexity: O(2^n) - n is the number of elements
// Space Complexity: O(h)  - h is the height of the recursive stack
// Solution 2 - For loop based recursion
class Solution {
    List<List<String>> result;
    List<String> path;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        helper(s);
        return result;
       
    }

    private void helper(String s){
        if(s.length() == 0){
            result.add(new ArrayList<>(path));
        }

        for(int i=0; i< s.length(); i++){
            String sub = s.substring(0, i+1);
            if(isPalindrome(sub)){
                path.add(sub);
                helper(s.substring(i+1));
                path.remove(path.size()-1);
            }
        }
    }


    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() -1;

        while(start < end)
            if(s.charAt(start++) != s.charAt(end--)) return false;
        return true;
    }
}

// Time Complexity: O(2^n) - n is the number of elements
// Space Complexity: O(h)  - h is the height of the recursive stack
// 0-1  recursion
class Solution {
    List<List<String>> result;
    List<String> path;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        helper(s, 0, 0,0);
        return result;
       
    }

    private void helper(String s, int pivot, int i, int sum){
        if(s.length() == i ){
            if(sum == s.length())
                result.add(new ArrayList<>(path));
            return;
        }
        // don't partition
        helper(s, pivot, i+1, sum);

        // partition
        String sub = s.substring(pivot, i+1);
        if(isPalindrome(sub)){
            path.add(sub);
            helper(s, i+1, i+1,sum + sub.length());
            path.remove(path.size()-1);
        }


    }


    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() -1;

        while(start < end)
            if(s.charAt(start++) != s.charAt(end--)) return false;
        return true;
    }
}