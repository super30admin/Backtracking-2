//We are initially taking a substring of the string given to and checking if it is palindrome, if it is then we are adding that element to temporary list and calling the function again by just incrementing the index by 1, as we reach the end of string we are making a copy of temporary list and are storing it to the result list, So all the values that are stored in the list while traversing are added to the result list. And while recursing we are removing the last element from the list

//Time complexity=O(n*2^n)
//Space Complexity=O(n)

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result=new ArrayList<>();
        if(s==null || s.length()==0) return result;
        
        helper(s,new ArrayList<>(),0);
        return result;
    }
    private void helper(String s, List<String> temp,int start)
    {
        //base
        if(start==s.length()){
            result.add(new ArrayList<>(temp));
            return;}
        
        //Logic
        int size=s.length();
        for(int i=start;i<size;i++){
            if(isPalindrome(s,start,i)){
            temp.add(s.substring(start,i+1));
            helper(s,temp,i+1);
            temp.remove(temp.size()-1);
            }
            }
    }
    private boolean isPalindrome(String s,int start,int end)
    {
        if(start==end) return true;
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}