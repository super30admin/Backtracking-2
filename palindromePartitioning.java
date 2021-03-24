//Time Complexity: O(n*(2^n)) since two choices and height will be the number of elements and also the isPalindrome for every node O(n)
//Space Complexity: O(n) asymptotically

//Code
class Solution {
    private List<List<String>> output = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0)
            return output;
        backtracking(s, 0, new ArrayList());
        return output;
    }
    private boolean isPalindrome(String str){
        int left = 0;
        int right = str.length()-1;
        
        while(left<right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private void backtracking(String s, int index, List<String> path){
        //base case
        if(index >= s.length()){
            output.add(new ArrayList<>(path));
            return;
        }
        
        //logic case
        for(int i=index;i<s.length();i++){
            String curr = s.substring(index, i+1);
            if(isPalindrome(curr)){
                path.add(curr);
                backtracking(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    
    }
}


/*
//Using hashSet
class Solution {
    private List<List<String>> output = new ArrayList<>();
    private HashSet<String> hashSet = new HashSet<>();
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0)
            return output;
        backtracking(s, 0, new ArrayList());
        return output;
    }
    private boolean isPalindrome(String str){
        int left = 0;
        int right = str.length()-1;
        
        while(left<right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private void backtracking(String s, int index, List<String> path){
        //base case
        if(index >= s.length()){
            output.add(new ArrayList<>(path));
            return;
        }
        
        //logic case
        for(int i=index;i<s.length();i++){
            String curr = s.substring(index, i+1);
            if(isPalindrome(curr) || hashSet.contains(curr)){
                path.add(curr);
                hashSet.add(curr);
                backtracking(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    
    }
}
*/