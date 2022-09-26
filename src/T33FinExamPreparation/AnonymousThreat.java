package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnonymousThreat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> myList = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s+")));

        String input = reader.readLine();
        while (!"3:1".equals(input)) {
            String[] commArr = input.split("\\s+");
            String command = commArr[0];

            switch (command) {
                case "merge":
                    int startIndex = Integer.parseInt(commArr[1]);
                    int endIndex = Integer.parseInt(commArr[2]);

                    if (startIndex < 0) {
                        startIndex = 0;
                    } else if (startIndex > myList.size() - 1) {
                        break;
                    }
                    if (endIndex > myList.size() - 1) {
                        endIndex = myList.size() - 1;
                    }

                    ArrayList<String> buffList = new ArrayList<>();
                    for (int i = 0; i < startIndex; i++) {
                        buffList.add(myList.get(i));
                    }

                    StringBuilder sb = new StringBuilder();
                    for (int i = startIndex; i <= endIndex; i++) {
                        sb.append(myList.get(i));
                    }
                    buffList.add(sb.toString());

                    for (int i = endIndex + 1; i < myList.size(); i++) {
                        buffList.add(myList.get(i));
                    }
                    myList.clear();
                    myList.addAll(buffList);

                    break;
                case "divide":
                    int index = Integer.parseInt(commArr[1]);
                    int partitions = Integer.parseInt(commArr[2]);
                    if (index > myList.size() - 1) {
                        break;
                    }

                    if (myList.get(index).length() % partitions == 0) {

                        ArrayList<String> buff = new ArrayList<>();
                        for (int i = 0; i < index; i++) {
                            buff.add(myList.get(i));
                        }

                        int wordLength = myList.get(index).length();
                        int step = wordLength / partitions;
                        int indx = 0;
                        int endIdtx = step;
                        for (int i = 0; i < partitions; i++) {
                            String element = myList.get(index).substring(indx, endIdtx);
                            buff.add(element);
                            indx = endIdtx;
                            endIdtx += step;
                        }

                        for (int i = index + 1; i < myList.size(); i++) {
                            buff.add(myList.get(i));
                        }

                        myList.clear();
                        myList.addAll(buff);
                    } else {
                        ArrayList<String> buff = new ArrayList<>();
                        for (int i = 0; i < index; i++) {
                            buff.add(myList.get(i));
                        }

                        int chCounts = myList.get(index).length() / partitions;
                        int str = 0;
                        int finishCh = 0;
                        if (chCounts > 0) {
                            str = 0;
                            finishCh = str + chCounts;

                            for (int i = 0; i < partitions; i++) {
                                if (i == partitions - 1) {
                                    String element = myList.get(index).substring(str, myList.get(index).length() - 1);
                                    buff.add(element);
                                } else {
                                    String element = myList.get(index).substring(str, finishCh);
                                    buff.add(element);
                                    str = finishCh;
                                    finishCh += chCounts;
                                }
                            }
                        }

                        for (int i = index + 1; i < myList.size(); i++) {
                            buff.add(myList.get(i));
                        }

                        myList.clear();
                        myList.addAll(buff);
                    }
                    break;
            }

            input = reader.readLine();
        }

        for (String str : myList) {
            System.out.print(str + " ");
        }
    }
}
