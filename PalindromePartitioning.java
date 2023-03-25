// TC - O((N+N)(2^N)) - N: checking if its a palindrome, N for creating substrings, 2^N for creating nodes choose and not choose case
// SC - O((N+N)(2^N))

// For-loop based recursion using Backtracking 
public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        int n = s.length();
        result = new ArrayList<>();
        if(s==null || n<0) return result;
        helper(s,0,new ArrayList<>());
        return result;
    }

    private void helper(String s, int idx, List<String> path){
        // base
        if(idx==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        for(int i=idx;i<s.length();i++){
            String sub = s.substring(idx,i+1);
            if(isPalindrome(sub)){
                // action
                path.add(sub);
                // recursion
                helper(s,i+1,path);
                // backtrack
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
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

// For-loop based recursion using Backtracking without pivot
public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        int n = s.length();
        result = new ArrayList<>();
        if(s==null || n<0) return result;
        helper(s,new ArrayList<>());
        return result;
    }

    private void helper(String s, List<String> path){
        // base
        if(s.length()==0){
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        for(int i=0;i<s.length();i++){
            String sub = s.substring(0,i+1);
            if(isPalindrome(sub)){
                // action
                path.add(sub);
                // recursion
                helper(s.substring(i+1),path);
                // backtrack
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
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

// brute force using recursion
public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        int n = s.length();
        result = new ArrayList<>();
        if(s==null || n<0) return result;
        helper(s,0,new ArrayList<>());
        return result;
    }

    private void helper(String s, int idx, List<String> path){
        // base
        if(idx==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        for(int i=idx;i<s.length();i++){
            String sub = s.substring(idx,i+1);
            if(isPalindrome(sub)){
                List<String> temp = new ArrayList<>(path);
                temp.add(sub);
                helper(s,i+1,temp);
            }
        }
    }

    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
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

// 0-1 backtracking
public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        int n = s.length();
        result = new ArrayList<>();
        if(s==null || n<0) return result;
        helper(s,0,0,new ArrayList<>());
        return result;
    }

    private void helper(String s, int idx, int i,List<String> path){
        // base
        if(idx==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        if(i==s.length()) return;

        // logic
        // not choose
        helper(s,idx,i+1, path);

        // choose
        String sub = s.substring(idx,i+1);
        if(isPalindrome(sub)){
            // action
            path.add(sub);
            // recurse
            helper(s,i+1,i+1,path);
            // backtrack
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
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