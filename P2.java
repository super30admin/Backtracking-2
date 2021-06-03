//time-o()- exponential
//space- check palindrome-n*(2^n)-dfs,backtracking

class Solution {
    List<List<String>>  result;
    public List<List<String>> partition(String s) {
        result= new ArrayList<>();
        if(s==null ||s.length()==0) return result;
        
        partitionHelper(s, new ArrayList<>(), 0 );
        
        return result;
    }
    
    public void partitionHelper(String s, List<String> validPartitions, int pivot)
    {
        //base
        if(pivot==s.length()) {
            result.add(new ArrayList<>(validPartitions));
           return;
        }
        
        for(int j=pivot; j<s.length() ;j++)
        {
            if(isValidPalindrome(s, pivot, j))//check if the partitioned substring is valid palindorme
            {
                //action
                System.out.println(s.substring(pivot, j+1));
                validPartitions.add(s.substring(pivot, j+1));
                
                //recurse
                partitionHelper(s, validPartitions, j+1);
            
                //backtrack
                validPartitions.remove(validPartitions.size() - 1);
           
            }
             
        }
    }
        
        
    
    public boolean isValidPalindrome(String s, int low, int high) {
        //int low = 0;
        //int high= s.length()-1;
        if(low==high) return true;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}