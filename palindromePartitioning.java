class Solution {
    List<List<String>> finalList;
    public List<List<String>> partition(String s) {
        finalList = new ArrayList<>();
        backtrack(s, new ArrayList<>(), 0);
        return finalList;
    }
    public void backtrack(String s, List<String>list, int index){
        if(index == s.length())
            finalList.add(new ArrayList<>(list));

        for(int i = index; i< s.length(); i++){
            String subs = s.substring(index, i+1);
            if(isValidPalindrome(subs)){
                //action
                list.add(subs);
                //recursion
                backtrack(s, list, i+1);
                //backtrack
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isValidPalindrome(String s){
        int start =0, end = s.length()-1;
        while(start < end )
            if(s.charAt(start++) != s.charAt(end--)) 
                return false;
        return true;
    }
}
