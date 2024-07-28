//package algorithm;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> employee = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            //String log = st.nextToken();
            if (!employee.contains(name)) {
                employee.add(name);
            } else {
                employee.remove(name);
            }
        }

        List<String> list = sortEmployeeDesc(employee);

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }

    private static List<String> sortEmployeeDesc(Set<String> employee) {
        List<String> list = new ArrayList<>(employee);
        list.sort(Comparator.reverseOrder());

        return list;
    }
}