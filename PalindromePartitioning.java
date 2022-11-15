//Time complexity - O(n*2^n)  n- for no of cloning times 2^n for computation
//Space Complexity - O(n)
//works in leetcode
class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {



        partition(0,s);


        return result;
    }

    public void partition(int index, String s){

        //base
        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }



        for(int i=index; i < s.length();i++){     //first level partition.

            if(isPalindrome(s,index, i)){

                path.add(s.substring(index,i+1));
                partition(i+1,s); //continue partitioninng remaining substring
                path.remove(path.size()-1);

            }


        }


    }


    public boolean isPalindrome(String s, int start, int end){

        while(start <= end){
            if(s.charAt(start++)!= s.charAt(end--))
                return false;

        }

        return true;
    }

}