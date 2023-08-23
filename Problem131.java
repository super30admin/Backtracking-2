class Problem131 {
    List<List<String>> result;
//TC= O(2^n) Actual: O(n*2^n) [O(n) for checking if it is a palindrome]
// SC=  O(n) n is the height of the tree   
    public List<List<String>> partition(String s) {
        this.result=new ArrayList<>();
        helper(s,0,new ArrayList<String>());
        return result;
    }
    
    private void helper(String s, int pivot,ArrayList<String> path){
        if(pivot==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=pivot;i<s.length();i++){
            String subString=s.substring(pivot,i+1);
            if(isPalindrome(subString)){
                //action
                path.add(subString);
                //recurse
                helper(s,i+1,path);
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String subString){
        int start=0;
        int end=subString.length()-1;
        while(start<end){
            if(subString.charAt(start)!=subString.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

  public static void main(String[] args){
        Problem131 problem=new Problem131();
        System.out.println(problem.partition("aab"));
  }
}
