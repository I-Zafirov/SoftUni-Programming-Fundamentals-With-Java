package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Internships {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countProblem = Integer.parseInt(reader.readLine());
        int countPeople = Integer.parseInt(reader.readLine());
        ArrayDeque<String> stackProblems = new ArrayDeque<>();
        ArrayDeque<String> dequePeoples = new ArrayDeque<>();
        ArrayDeque<String> candidates = new ArrayDeque<>();
        for (int i = 0; i < countProblem; i++) {
            String name = reader.readLine();
            stackProblems.push(name);

        }
        Pattern pattern = Pattern.compile("[A-Z][a-z]+ [A-Z][a-z]+");
        for (int i = 0; i < countPeople; i++) {
            String name = reader.readLine();
            Matcher match = pattern.matcher(name);
            if (match.find()) {
                dequePeoples.add(name);
                candidates.add(name);
            }

        }
        String problem = "";
        if (dequePeoples.size() == 0 || dequePeoples.size() == 1) {
            return;
        }
        while (true) {
            if (dequePeoples.size() == 1) {
                System.out.printf("%s gets the job!", dequePeoples.peek());
                break;
            }
            String name = dequePeoples.poll();
            int sizeName = 0;
            int sizeProblem = 0;
            for (int i = 0; i < name.length(); i++) {
                int size = (int) name.charAt(i);
                sizeName += size;
            }
            if (stackProblems.size() == 0) {
                System.out.printf(String.join(", ", candidates));
                break;
            } else {
                problem = stackProblems.pop();
            }

            //int lenght=stackProblems.size();
            for (int j = 0; j < problem.length(); j++) {
                int size = (int) problem.charAt(j);
                sizeProblem += size;
            }
            if (sizeName > sizeProblem) {
                System.out.printf("%s solved %s.\n", name, problem);
                   /*if(stackProblems.size()==0){
                       System.out.printf(String.join(", ",candidates));
                       break;
                   }*/
                dequePeoples.add(name);

            } else {
                System.out.printf("%s failed %s.\n", name, problem);
                stackProblems.add(problem);

            }
        }
    }
}
