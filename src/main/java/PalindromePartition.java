
import java.util.*;

public class PalindromePartition {

	List<List<String>>l1= new ArrayList<>();
    private boolean isPalindrome(String s){
        
    HashMap<String, Boolean>hm= new HashMap<>();
        
        if(hm.containsKey(s)){return hm.get(s);}else{
            
            int x=0;
            int y=s.length()-1;
            
            while(x<y){
                
                if(s.charAt(x)!=s.charAt(y)){
                    hm.put(s,false);
                    return hm.get(s);
                }x++;
                y--;
            }
      
        }
        
        hm.put(s,true);
        return hm.get(s);
    }
    
    private void helper(int index, String s, List<String> l){
        
        
        if(index==s.length()){ l1.add(new ArrayList(l));return;}
        
        for(int i=index; i<s.length();i++){
            
            String curr= s.substring(index,i+1);
            
            if(isPalindrome(curr)){
                
                l.add(curr);
                helper(i+1,s,l);
                l.remove(l.size()-1);
                
            }
            
            
        }
        
    }
    
    
    public List<List<String>> partition(String s) {
    
    List<String> l= new ArrayList<>();
        helper(0,s,l);
        return l1;
        
    }
	
}
