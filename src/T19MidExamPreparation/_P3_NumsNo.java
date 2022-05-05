package T19MidExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class _P3_NumsNo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        if (nums.size() <= 1) {
            System.out.println("No");
            return;
        }
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        if (sum == 0){
            System.out.println("No");
            return;
        }
        double average = 1.0 * sum / nums.size();
        List<Integer> out = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {

            if (nums.get(i) > average) {
                out.add(nums.get(i));
            }else if (nums.get(i) == average) {
                count++;

            }
            if (count ==nums.size()) {
                System.out.println("No");

            }

        }
        Collections.sort(out);
        Collections.reverse(out);
        for (int i = 0; i < out.size(); i++) {
            if (i <= 4) {
                System.out.print(out.get(i) + " ");
            }
        }
    }
}
