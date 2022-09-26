package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnonymousCache {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Long> dataSetDataSize = new HashMap<>();
        HashMap<String, Long> bufferSS = new HashMap<>();

        HashMap<String, List<String>> dataSetDataKey = new HashMap<>();
        HashMap<String, List<String>> bufferSK = new HashMap<>();

        String input = reader.readLine();

        while (!input.equals("thetinggoesskrra")) {
            String[] inputArr = input.split(" \\| ");
            if (inputArr.length == 1) {
                String dataSet = inputArr[0];

                long value = 0;
                dataSetDataSize.putIfAbsent(dataSet, value);
                dataSetDataKey.putIfAbsent(dataSet, new ArrayList<>());
            } else {
                String dataSet = inputArr[1];
                String firstPast = inputArr[0];
                String[] arr = firstPast.split(" -> ");
                String dataKey = arr[0];
                long dataSize = Long.parseLong(arr[1]);

                if (!dataSetDataSize.containsKey(dataSet)) {
                    if (!bufferSS.containsKey(dataSet)) {
                        bufferSS.put(dataSet, dataSize);

                        bufferSK.put(dataSet, new ArrayList<>());
                        bufferSK.get(dataSet).add(dataKey);
                    } else {
                        long value = bufferSS.get(dataSet) + dataSize;
                        bufferSS.replace(dataSet, value);

                        bufferSK.get(dataSet).add(dataKey);
                    }
                } else if (dataSetDataSize.containsKey(dataSet)) {
                    long value = dataSetDataSize.get(dataSet) + dataSize;
                    dataSetDataSize.replace(dataSet, value);

                    dataSetDataKey.get(dataSet).add(dataKey);
                }
            }

            input = reader.readLine();
        }

        for (String dataSet : dataSetDataSize.keySet()) {
            if (dataSetDataSize.get(dataSet) == 0) {
                if (bufferSS.containsKey(dataSet)) {
                    dataSetDataSize.replace(dataSet, bufferSS.get(dataSet));
                    dataSetDataKey.get(dataSet).addAll(bufferSK.get(dataSet));
                }
            }
        }

        String key = "";
        long size = 0;
        for (String dataSet : dataSetDataSize.keySet()) {
            if (dataSetDataSize.get(dataSet) > size) {
                size = dataSetDataSize.get(dataSet);
                key = dataSet;
            }
        }

        Print(dataSetDataKey, dataSetDataSize, key);
    }

    private static void Print(HashMap<String, List<String>> dataSetDataKey, HashMap<String, Long> dataSetDataSize, String key) {
        if (key.length() > 0 && dataSetDataSize.containsKey(key)) {
            System.out.println("Data Set: " + key + ", Total Size: " + dataSetDataSize.get(key));

            List<String> resultKeys = new ArrayList<>();
            resultKeys.addAll(dataSetDataKey.get(key));

            for (String dataKey : resultKeys) {
                System.out.println("$." + dataKey);
            }
        }
    }
}
