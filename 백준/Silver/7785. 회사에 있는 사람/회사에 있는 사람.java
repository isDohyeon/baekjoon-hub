//package algorithm;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, String> logMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();
            logMap.put(name, log);
        }

        List<String> list = getCurrentEmployees(logMap);

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }

    private static List<String> getCurrentEmployees(Map<String, String> logMap) {
        List<String> list = new ArrayList<>();

        for (Map.Entry<String, String> employee : logMap.entrySet()) {
            if (employee.getValue().equals("enter")) {
                list.add(employee.getKey());
            }
        }

        list.sort(Comparator.reverseOrder());
        
        return list;
    }
}