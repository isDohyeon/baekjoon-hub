import java.util.Scanner;
import java.util.Arrays;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] h = new int[N];

        for (int i = 0; i < N; i++)
        {
            h[i] = sc.nextInt();
        }
        Arrays.sort(h);

        for(int i = 0; i < N; i++)
        {
            if (h[i] <= L)
                L++;
            else
                break;
        }
        System.out.print(L);
    }
}