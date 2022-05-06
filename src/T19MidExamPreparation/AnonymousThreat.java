package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(String::trim).collect(Collectors.toList());

        while (true) {

            String line = scanner.nextLine();

            if (line.equals("3:1")) {
                break;
            }

            String[] tokens = line.split("\\s+");
            int begin = Integer.parseInt(tokens[1]);
            int end = Integer.parseInt(tokens[2]);

            switch (tokens[0]) {
                case "merge":

                    if (end > names.size() - 1 || end < 0) {
                        end = names.size() - 1;
                    }
                    if (begin < 0 || begin > names.size()) {
                        begin = 0;
                    }

                    for (int i = begin; i < end; i++) {

                        names.set(begin, names.get(begin) + names.get(begin + 1));
                        names.remove(begin + 1);

                    }

                    break;

                case "divide":
                    int a = names.get(begin).length() / end;
                    int b = names.get(begin).length() % end;
                    int beginIndex = 0;
                    int nextIndex = a;

                    for (int i = 0; i < end; i++) {
                        String abc = names.get(begin);

                        if (b == 0) {
                            names.add(begin + i + 1, abc.substring(beginIndex, nextIndex));
                        } else {

                            if (i == end - 1) {
                                names.add(begin + i + 1, abc.substring(beginIndex, abc.length()));
                            } else {
                                names.add(begin + i + 1, abc.substring(beginIndex, nextIndex));
                            }

                        }
                        beginIndex += a;
                        nextIndex += a;
                    }
                    names.remove(begin);
                    break;

            }

        }

        for (String name : names) {
            System.out.print(name + " ");
        }

    }
}
