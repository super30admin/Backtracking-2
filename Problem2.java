TC - exponential
SC - exponential

class Solution {
    List<List<String>> li = new ArrayList<>();
    Set<List<String>> st = new HashSet<>();
    
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return li;
        
        if(s.length() == 1) {
            List<String> l = new ArrayList<>();
            l.add(s.substring(0,1));
            li.add(l);
            return li;
        }
        
        backtrack(s, 0, new ArrayList<>());
        
        return li;
    }
    
    private void backtrack(String s, int idx, List<String> list)
    {
        //Base
        if(idx == s.length())
        {
            if(!st.contains(list))
                li.add(list);
                
            st.add(list);
            return;
        }
        
        //Logic
        for(int j = idx; j < s.length(); ++j)
        {
            String st1 = s.substring(idx, j+1);
            String st2 = s.substring(j+1, s.length());
            
            if(checkPalin(st1))
            {
                list.add(st1);
                
                backtrack(s, j + 1, new ArrayList<>(list));
                
                list.remove(list.size() - 1);
            }
            
        }
    }
    
    private boolean checkPalin(String a)
    {
        int i = 0, j = a.length()-1;
        
        while(i <= j)
        {
            if(a.charAt(i) != a.charAt(j)) return false;
            
            ++i;
            --j;
        }
        return true;
    }
}
