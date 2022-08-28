
//TC = O(2^n)
//Space =. O(1)
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        // String, Pivot, Path
        if(s == null || s.length() == 0) return result;
        
        helper(s, new ArrayList<>());        
        return result;
    }
    
    private void helper(String s, List<String> path){
        //base
        if(s.length() == 0){
            result.add(new ArrayList<>(path));
                return;
        }
        //logic
        for(int i = 0; i < s.length(); i++){
            String subString = s.substring(0, i+1); 
            if(isPalindrome(subString)){
                //action
                List<String> temp = new ArrayList<>(path);
                temp.add(subString);
                //System.out.println(path);
                //recurse
                helper(s.substring(i+1), temp);
                //backtrack
                //path.remove(path.size()-1);
            }
            
        }
    }
    
    private boolean isPalindrome(String s){
        System.out.println(s);
        int start = 0;
        int end = s.length() - 1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}



class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        // String, Pivot, Path
        if(s == null || s.length() == 0) return result;
        
        helper(s, 0, new ArrayList<>());        
        return result;
    }
    
    private void helper(String s, int pivot, List<String> path){
        //base
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
                return;
        }
        //logic
        for(int i = pivot; i < s.length(); i++){
            String subString = s.substring(pivot, i+1); 
            if(isPalindrome(subString)){
                //action
                path.add(subString);
                //System.out.println(path);
                //recurse
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size()-1);
            }
            
        }
    }
    
    private boolean isPalindrome(String s){
        System.out.println(s);
        int start = 0;
        int end = s.length() - 1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}




//TC = O(2^n)
//Space =. O(1)
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        // String, Pivot, Path
        if(s == null || s.length() == 0) return result;
        
        helper(s, new ArrayList<>());        
        return result;
    }
    
    private void helper(String s, List<String> path){
        //base
        if(s.length() == 0){
            result.add(new ArrayList<>(path));
                return;
        }
        //logic
        for(int i = 0; i < s.length(); i++){
            String subString = s.substring(0, i+1); 
            if(isPalindrome(subString)){
                //action
                List<String> temp = new ArrayList<>(path);
                temp.add(subString);
                //System.out.println(path);
                //recurse
                helper(s.substring(i+1), temp);
                //backtrack
                //path.remove(path.size()-1);
            }
            
        }
    }
    
    private boolean isPalindrome(String s){
        System.out.println(s);
        int start = 0;
        int end = s.length() - 1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}




//TC = O(2^n)
//Space =. O(1)
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        // String, Pivot, Path
        if(s == null || s.length() == 0) return result;
        
        helper(s, new ArrayList<>());        
        return result;
    }
    
    private void helper(String s, List<String> path){
        //base
        if(s.length() == 0){
            result.add(new ArrayList<>(path));
                return;
        }
        //logic
        for(int i = 0; i < s.length(); i++){
            String subString = s.substring(0, i+1); 
            if(isPalindrome(subString)){
                //action
                List<String> temp = new ArrayList<>(path);
                temp.add(subString);
                //System.out.println(path);
                //recurse
                helper(s.substring(i+1), temp);
                //backtrack
                //path.remove(path.size()-1);
            }
            
        }
    }
    
    private boolean isPalindrome(String s){
        System.out.println(s);
        int start = 0;
        int end = s.length() - 1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}


