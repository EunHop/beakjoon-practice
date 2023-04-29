import java.util.Scanner;

public class b_10810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        int m=sc.nextInt();
        for(int b=0; b<m; b++) {
            int i=sc.nextInt();
            int j=sc.nextInt();
            int k=sc.nextInt();
            for(int c=i-1; c<j; c++) {
                arr[c]=k;
            }
        }
        for(int a=0; a<n; a++)
            System.out.printf("%d ", arr[a]);
    }
}
