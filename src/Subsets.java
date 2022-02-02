import java.util.ArrayList;
import java.util.List;

public class Subsets {
    //with new String list everytime
    /*
    /*  Problem 1
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)

     */
    class ChooseNotChoose {
        List<List<Integer>> result;
        public List<List<Integer>> subsets(int[] nums) {
            result = new ArrayList<>();
            if(nums == null) return result;
            helper(nums, 0, new ArrayList<>());
            return result;
        }
        private void helper(int[] nums, int index, List<Integer> list) {
            //base
            if(index == nums.length ){
                result.add(list);
                return;
            }

            //logic;
            //not choose
            helper(nums, index+1, new ArrayList(list));
            List<Integer> temp = new ArrayList(list);
            temp.add(nums[index]);
            //choose
            helper(nums, index+1, temp);

        }
    }

    // with back tracking
    class ChooseNotChooseBacktrack {
        List<List<Integer>> result;
        public List<List<Integer>> subsets(int[] nums) {
            result = new ArrayList<>();
            if(nums == null) return result;
            helper(nums, 0, new ArrayList<>());
            return result;
        }
        private void helper(int[] nums, int index, List<Integer> list) {
            //base
            if(index == nums.length ){

                result.add(new ArrayList(list));
                return;
            }

            //logic;
            //not choose
            helper(nums, index+1, new ArrayList(list));
            list.add(nums[index]);
            //choose
            helper(nums, index+1, list);
            list.remove(list.size()-1);

        }
    }

    //recursion using for
    class recurseFor {
        List<List<Integer>> result;
        public List<List<Integer>> subsets(int[] nums) {
            result = new ArrayList<>();
            if(nums == null) return result;
            helper(nums, 0, new ArrayList<>());
            return result;
        }
        private void helper(int[] nums, int index, List<Integer> list) {
            //base

            result.add(new ArrayList(list));
            for(int i = index; i< nums.length; i++) {
                list.add(nums[i]);
                helper(nums, i+1, (list));
                list.remove(list.size()-1);
            }
        }
    }

    //without recursion for
    class iterative {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            for( int i =0 ;i<nums.length;i++) {
                int k=result.size();
                for(int j=0; j<k; j++) {
                    List<Integer> l = new ArrayList(result.get(j));
                    l.add(nums[i]);
                    result.add(l);
                }
            }
            return result;
        }
    }
}
