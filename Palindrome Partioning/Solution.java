// Time Complexity: O(2^n)
// Space Complexity: O(n)
class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        if(s==null || s.length()==0) return null;
        res=new ArrayList<>();
        String st = "";
        helper(s,0,new ArrayList<>());
        return res;
    }
    
    private void helper(String s, int i, List<String> pathSoFar){
        // base
       if(i==s.length()){
           res.add(new ArrayList<>(pathSoFar));
           return;
       }
        for(int j=i;j<s.length();j++){
            String sb = s.substring(i,j+1);
            if(isPal(sb)){
                pathSoFar.add(sb);
                helper(s,j+1,pathSoFar);
                pathSoFar.remove(pathSoFar.size()-1);
            }
        }
    }
    
    private Boolean isPal(String st){
        if(st.length()==0) return false;
        int i=0;
        int j=st.length()-1;
        while(i<j){
            if(st.charAt(i) != st.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
