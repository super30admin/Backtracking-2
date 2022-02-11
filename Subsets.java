// Time Complexity: O(n*2^n) -> O(2^n)
// Space Complexity: (1)
// iterative
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        // add empty list
        result.add(new ArrayList<>());
        // controls adding duplicates as index moves ahead always
        for(int i = 0 ; i < nums.length ; i++) 
        {
            // get the size of current result list
            int size = result.size();
            for(int j = 0 ; j < size; j++)
            {
                // copy over numbers added so far
                List<Integer> subset = new ArrayList<>(result.get(j));
                // add new number
                subset.add(nums[i]);
                // add this to the result set
                result.add(subset);
            }
        }
        return result;
    }
}

// Time Complexity: O(n*2^n) -> O(2^n)
// Space Complexity: O(n)
// iterative backtrack
public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        iterativeBacktrack(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void iterativeBacktrack(int []nums, int index, List<Integer> path)
    {
        // base case not needed because controlled by for loop
        
        //logic
        result.add(new ArrayList<>(path));
        for(int i = index ; i < nums.length; i++)
        {
            path.add(nums[i]);
            iterativeBacktrack(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}

// Time Complexity: O(n*2^n) -> O(2^n)
// Space Complexity: (n)
// 0-1 backtrack
public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void backtrack(int []nums, int index, List<Integer> path)
    {
        // base case
        if(index == nums.length)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        // case 0
        backtrack(nums, index+1, path);
        // case 1
        path.add(nums[index]);
        backtrack(nums, index+1, path);
        path.remove(path.size()-1);
    }
}
