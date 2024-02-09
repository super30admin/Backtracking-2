//Accepted on LT
//Just do for loop based recursion
//and check for palindrone 
class Solution {
    List<List<String>> l;

    public List<List<String>> partition(String s) {
        this.l = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        helper(s, l2, 0);
        return l;
    }

    public void helper(String s, List<String> l2, int pivot) {
        // base
        if (pivot == s.length()) {
            l.add(new ArrayList<>(l2));
            return;
        }

        for(int i=pivot;i<s.length();i++){
            //action
            String subs = s.substring(pivot,i+1);
            if (p(subs)){
                l2.add(s.substring(pivot,i+1));
                  //recurse
                helper(s,l2,i+1);


                //bct
                l2.remove(l2.size()-1);

            }

          
        }

        
    }

    public static boolean p(String input) {
        if (input == null) {
            return false;  
        }

        int length = input.length();
        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                return false; 
            }
        }
        return true;  
    }
}
