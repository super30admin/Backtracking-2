class Solution {
    public List<List<String>> partition(String s) {
        List<String> subList=new ArrayList<>();
        List<List<String>> list=new ArrayList<>();
        partion(s,0,subList,list);
        return list;
    }
    void partion(String s, int index,List<String> subList,List<List<String>> list) {
        if (index==s.length()){
            list.add(new ArrayList<>(subList));
            return;
        }
        for (int i = index; i <s.length() ; ++i) {
            if (isPalindrome(s,index,i)){
                subList.add(s.substring(index,i+1));
                partion(s,i+1,subList,list);
                subList.remove(subList.size()-1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        while (start<=end){
            if (s.charAt(start++) !=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
