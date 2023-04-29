import java.util.Scanner;

public class b_10807 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int arr[] = new int[a];
        int cnt = 0;
        for (int i = 0; i < a; i++) {
            arr[i] = scan.nextInt();
        }
        int v = scan.nextInt();
        for(int j=0; j<a; j++) {
            if(arr[j]== v)
                cnt++;
        }
        System.out.println(cnt);
    }
}
