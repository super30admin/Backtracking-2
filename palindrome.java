class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s,0,new ArrayList<>(), result);
        return result;
    }
    
    private void helper(String s, int idx, List<String> path, List<List<String>> result){
        
        if(idx == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx; i< s.length(); i++){
            String sub = s.substring(idx, i+1);
            if(isPalindrome(sub)){
                path.add(sub); 
                helper(s,i+1, path,result);
                path.remove(path.size()-1);
            }
   
            
        }
    }
    
    private boolean isPalindrome(String s){
        int start =0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)) 
                return false;
            start++;
            end--;
        }
        return true;
    }
}