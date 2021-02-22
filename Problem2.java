//Time complexity:O(n^n)
//Space complexity:O(length of string)
//Ran on leetcode:No
//Solution with comments: My output does not have unique subarray.
class Solution {
    List<List<String>> output= new ArrayList<>();
    public List<List<String>> partition(String s) {
       
        int n=s.length();     
        backtrack(s.substring(0,n),new ArrayList<>());
        return output;
    }
    
    public void backtrack(String sub, List<String> list){
        int n= sub.length();
        if(sub.length()<1)
            return;
        
        else if(sub.length()==1){
            list.add(sub);
            output.add(list);
            return;
        }
        else{
            if(sub.charAt(0)==sub.charAt(n-1))
            {
                list.add(sub);
                output.add(new ArrayList<>(list));
            }
            else{
                for(int i=0;i<n-1;i++){
                    
                    list.add(sub.substring(0,i+1));            
                    backtrack(sub.substring(i+1,n),list);
                    output.add(new ArrayList<>(list));
                    list= new ArrayList<>();
                }
            }
               
        }
    }
    
}