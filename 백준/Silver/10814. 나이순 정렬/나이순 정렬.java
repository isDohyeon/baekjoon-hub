//package algorithm;

import java.io.*;
import java.util.*;

public class Main {

    private static class Member {
        private final int age;
        private final String name;
        private final int joinOrder;

        public Member(int age, String name, int joinOrder) {
            this.age = age;
            this.name = name;
            this.joinOrder = joinOrder;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Member> members = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            members.add(new Member(age, name, i));
        }

        members.sort(getAgeAndJoinOrderComparator());

        for (Member member : members) {
            System.out.println(member);
        }
    }

    /**
     *
     * @return 나이 순서로 우선 비교 후, 가입 순서로 비교하는 비교자 반환
     */
    private static Comparator<Member> getAgeAndJoinOrderComparator() {
        return (member1, member2) -> {
            if (member1.age == member2.age) {
                return Integer.compare(member1.joinOrder, member2.joinOrder);
            } else {
                return Integer.compare(member1.age, member2.age);
            }
        };
    }
}
