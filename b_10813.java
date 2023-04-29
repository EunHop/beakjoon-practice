import java.util.Scanner;

public class b_10813 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int a=0; a<n; a++) {
            arr[a] = a + 1;
        }
        int m=sc.nextInt();
        for(int b=0; b<m; b++) {
            int temp=0;
            int i=sc.nextInt();
            int j=sc.nextInt();
            temp=arr[i-1];
            arr[i-1]=arr[j-1];
            arr[j-1]=temp;
        }
        for(int b=0; b<n; b++) {
            System.out.printf("%d ", arr[b]);
        }
    }
}
