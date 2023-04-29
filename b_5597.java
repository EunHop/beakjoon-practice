import java.util.Scanner;

public class b_5597 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int arr[] = new int[30];
        for(int i=0; i<28; i++) {
            int a = sc.nextInt();
            arr[a-1]=1;
        }
        for(int j=0; j<30; j++) {
            if(arr[j]==0)
                System.out.println(j+1);
        }
    }
}
