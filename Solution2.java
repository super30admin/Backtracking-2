import java.util.*;

public class Solution2 {
    
    //Backtracking solution- Recursive Iterative Approach
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result=new ArrayList<>();
        if (s==null||s.length()==0)
            return result;
        helper(s,0,new ArrayList<>());
        
        return result;
    }
    
    private void helper(String s,int index,List<String> partitions){
   
        
        //base
        if(index==s.length()){
            result.add(new ArrayList<>(partitions));
            return;
        }
        //logic
        for(int i=index;i<s.length();i++){
            
            String currPartition= s.substring(index,i+1);
            if(isPalindrome(currPartition)){
                //List<String> newList= new ArrayList<>(partitions);
                partitions.add(currPartition);
                helper(s,i+1,partitions);
                partitions.remove(partitions.size()-1);
            }
        }
    }
    // Recursive 0/1case

    List<List<String>> result1;
    public List<List<String>> partition1(String s) {
        result=new ArrayList<>();
        if (s==null||s.length()==0)
            return result1;
        helper1(s,0,0,new ArrayList<>(),0);
        
        return result;
    }
    
    private void helper1(String s,int start, int index,List<String> partitions,int count){
        
        //base
        if(index>=s.length())
        {
            if(count==s.length()){
                result.add(partitions);
                   
            }
             return;
        }
        //case0
        helper1(s,start,index+1,partitions,count);
        
        String currPartition= s.substring(start,index+1);
        if(isPalindrome(currPartition)){
            List<String> newList= new ArrayList<>(partitions);
            newList.add(currPartition);
            //case1
            
             helper1(s,index+1,index+1,newList,count+currPartition.length());
        }
    }
    private boolean isPalindrome(String s){
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            
            start++;
            end--;
        }
        return true;
    }
}
