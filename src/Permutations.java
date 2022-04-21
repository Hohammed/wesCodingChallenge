import java.util.*;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(new Permutations().permuteUnique(new int[] { 1, 1, 2 }));
        System.out.println(new Permutations().permuteUnique(new int[] { 1, 2, 3 }));
    }

    public List<List<Integer>> permuteUnique(int[] numbers) {
        List<List<Integer>> bigList =
                new ArrayList<List<Integer>>();
        Arrays.sort(numbers);
        permute(numbers, 0, bigList);
        return bigList;
    }

    private void permute(int[] numbers, int index, List<List<Integer>> bigList) {
        if (index == numbers.length) {
            List newList = new ArrayList<Integer>(numbers.length);
            for (int num : numbers)
                newList.add(num);
            bigList.add(newList);
            return;
        }
        Set<Integer> dups = new HashSet();
        for (int i = index; i < numbers.length; i++) {
            if (dups.add(numbers[i])) {
                swap(numbers, i, index);
                permute(numbers, index + 1, bigList);
                swap(numbers, i, index);
            }
        }
    }

    private void swap(int[] numbers, int i, int index) {
        int temp = numbers[i];
        numbers[i] = numbers[index];
        numbers[index] = temp;
    }
}	