import java.util.Scanner;

public class b_10818 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i]=scan.nextInt();
        }
        int min=arr[0];
        int max=arr[0];
        for(int j=1; j<n; j++) {
            if(max<arr[j])
                max=arr[j];
            if(min>arr[j])
                min=arr[j];
        }
        System.out.printf("%d %d", min, max);
    }
}
