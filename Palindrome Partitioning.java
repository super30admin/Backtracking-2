class Solution {
    //Time: O(n.2^n) where n is the length of the string. We need to go over the portion of the string everytime to check if it is a palindrome so n gets muktiplied.
	//Space: O(n)
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> partition(String s) {
        //ababc
        
    //a babc    ab abc  aba bc  
        
  //a  b abc a b abc
 //-   - a bc
        
        dfs(0, s, new LinkedList<String>());
        
        return res;
    }
    
    public void dfs(int start, String s, List<String> indi){
        
        //base cases
        
        if(start >= s.length()){
            
            res.add(new LinkedList<String> (indi));
            return;
            
        }
        
        for(int end = start ; end < s.length(); end++){
            
            if(is_pal(start, end, s)){
                
                indi.add(s.substring(start, end + 1));
                
                dfs(end + 1, s, indi);
                
                indi.remove(indi.size() - 1);
                
            }
            
        }
        
    }
    
    public boolean is_pal(int start, int end, String s){
        
        while(start < end){
            
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start ++;
            end --;
            
        }
        
        return true;
        
    }
    
    
}