class Solution {// time and space of 2^N * N
    List<List<String>> output;
    public List<List<String>> partition(String s) {
        output = new ArrayList<>();
        helper(0,s, new ArrayList<>());
        return output;
    }
    private void helper(int start, String s , ArrayList temp)
    {
        //Base case || Right output
        if(start >= s.length())
        {
            output.add(new ArrayList<>(temp));
        }
        //Explore
        for(int i = start ; i< s.length() ;i++)
        {
            String substr = s.substring(start,i+1);//make cut at i
            if(isPalindrome(s,start,i))
            {
                temp.add(substr);
                helper(i+1,s,temp);
                temp.remove(temp.size()-1);
            }
        }
        
    }
    private boolean isPalindrome(String s, int start, int end){
        while(start< end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
}