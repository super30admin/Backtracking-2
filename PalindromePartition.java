import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
TC : exponential 2^ no of subsets
SC : similar to above
LC : not passing all cases
Problems : need to handle all cases
 */
public class PalindromePartition {

    public List<List<String>> list = new ArrayList();

    public List<List<String>> partition(String s) {
        if (s.length() == 1)
            list.add(new ArrayList(Arrays.asList(Character.toString(s.charAt(0)))));
        List<Integer> temp = new ArrayList(Arrays.asList(Character.toString(s.charAt(0))));
        helper(s, 1, new ArrayList(temp), false);
        helper(s, 1, new ArrayList(temp), true);

        return list;
    }

    public void helper(String s, int index, List<String> path, boolean flag) {
        System.out.println(path + " " + index);
        if (index == s.length()) {

            return;
        }


        if (!flag) {

            String temp1 = path.get(path.size() - 1);
            temp1 += s.charAt(index);
            path.remove(path.size() - 1);
            if (temp1.length() != 0)
                path.add(temp1);
            if (index == s.length() - 1) {
                if (isPalindrome(path))
                    list.add(new ArrayList(path));

            } else {
                helper(s, index + 1, path, false);
                String temp2 = path.get(path.size() - 1);
                temp2 = temp2.substring(0, temp2.length() - 1);
                path.remove(path.size() - 1);
                if (temp2.length() != 0)
                    path.add(temp2);

                if (index == s.length() - 1) {
                    if (isPalindrome(path))
                        list.add(new ArrayList(path));

                } else
                    helper(s, index + 1, path, true);
            }

        } else {

            path.add(Character.toString(s.charAt(index)));

            if (index == s.length() - 1) {
                if (isPalindrome(path))
                    list.add(new ArrayList(path));

            } else {
                helper(s, index + 1, path, false);

                path.remove(path.size() - 1);
                path.add(Character.toString(s.charAt(index)));
                helper(s, index + 1, path, true);
            }


        }


    }

    public boolean isPalindrome(List<String> list) {

        for (String str : list) {

            int start = 0;
            int end = str.length() - 1;

            while (start <= end) {
                if (str.charAt(start) != str.charAt(end))
                    return false;
                start++;
                end--;
            }

        }
        return true;
    }
}
