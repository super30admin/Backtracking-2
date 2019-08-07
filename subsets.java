//famous problem at facebook
//Time complexity:n*(2raise to n) 

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> result = new ArrayList();
      result.add(new ArrayList());
      for(int n:nums){
          int size = result.size(); //size of the list is 2raise to n(that many combinations)
          for(int i=0;i<size;i++){
              List<Integer> sublist = new ArrayList(result.get(i));
              sublist.add(n);
              result.add(sublist);
          }
      }
      return result;
    }
}
