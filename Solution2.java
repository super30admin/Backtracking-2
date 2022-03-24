class Solution {
    
    List<List<String>> result;
    
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        
        helper(s, 0, new ArrayList<>());
        
        return result;
    }
    
    public void helper(String str, int index, List<String> parts){
        if(index == str.length()){
            result.add(new ArrayList<>(parts));
            return;
        }
        for(int i=index; i<str.length(); i++){
            String substr = str.substring(index, i+1);
            if(isPalindrome(substr)){
                parts.add(substr);
                helper(str, i + 1, parts);
                parts.remove(parts.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String str){
        int i = 0;
        int j = str.length() - 1;
        
        while(i<=j){
            char chi = str.charAt(i);
            char chj = str.charAt(j);
            
            if(chi!=chj){
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
}
