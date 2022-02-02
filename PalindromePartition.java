//Time Complexity: O(exponential)
//Space Complexity: O(n)


class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result=new ArrayList();
        if(s==null || s.length()==0)
            return result;
        helper(s,0,new ArrayList<>());
        return result;
    }
    private void helper(String s, int index, List<String> path){
        //base case
        if(index==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=index;i<s.length();i++){
            String substr=s.substring(index,i+1);
            if(isPalindrome(substr)){
                path.add(substr);
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
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
