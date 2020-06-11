package LeetCode;
/*
 * 
 * 
 * TC = O(n*2^n)
 *  SC = O(n) 
 * 
 * */
class Solution {
    int c = 0;
    public List<List<String>> partition(String s) {
        c=Integer.MAX_VALUE;
       List<List<String>> result = new ArrayList<>();
        helper(result, s, 0, new ArrayList<String>());
        System.out.print(c-1);
        return result;
    }
    
    public void helper(List<List<String>> res,String s,int index,List<String> temp){
        
        if (temp.size() >=c){
            return;
        }
        if(index == s.length()){
            c=Math.min(c,temp.size());
        res.add(new ArrayList<>(temp));
        return;}
        
        
        for(int i=index;i<s.length();i++){ 
            if(isval(s.substring(index,i+1))){
        
                temp.add(s.substring(index,i+1));
                // c++;
                helper(res,s,i+1,temp);
                temp.remove(temp.size()-1);
                // c--;
                
            }
        }
    }
    
    public static boolean isval(String s){
        int start=0,l=s.length()-1;
        while(start<l){
            if(s.charAt(start++)!=s.charAt(l--))
                return false;
        }
        return true;   
    }
}

