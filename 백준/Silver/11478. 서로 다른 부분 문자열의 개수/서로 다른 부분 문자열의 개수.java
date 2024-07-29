//package set_map;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int length = s.length();

        Set<String> differencePartSet = new HashSet<>();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                differencePartSet.add(s.substring(i, j));
            }
        }
        System.out.print(differencePartSet.size());
    }
}