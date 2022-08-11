//TC - Exponential
//SC - O(N)
class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if(s.length()==0) return res;
        
        
        helper(s,0,new ArrayList<>());
        
        return res;
    }
    
    private void helper(String s, int index, List<String> list){
        
        //base
        if(index>=s.length()){
            res.add(new ArrayList<>(list));            
        }
        //logic
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                
                //action
                list.add(""+s.substring(index,i+1));

                //recurse
                helper(s,i+1,list);

                //backtrack
                list.remove(list.size()-1);
            }            

            
        }
    }
    
    private boolean isPalindrome(String list,int s,int e){
        while(s<e){
            if(list.charAt(s++)!=list.charAt(e--)) return false;
        }

        
        return true;
    }
}