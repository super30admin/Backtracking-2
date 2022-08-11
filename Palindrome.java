public class Palindrome {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        backtracking(s, 0, new ArrayList<>());
        return result;
    }
    
    private void backtracking(String s, int pivot, List<String> path){
        // base
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=pivot; i< s.length(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(pivot,i+1));
            if(isPalindrome(sb)){
            path.add(sb.toString());
            backtracking(s, i+1, path);
            path.remove(path.size()-1);
            }
            
        }
    }
    
    private boolean isPalindrome(StringBuilder s){
        int i=0, j=s.length()-1;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
