import java.util.Scanner;

public class b_2562 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arr[] = new int[9];
        for(int i=0; i<9; i++) {
            arr[i]=scan.nextInt();
        }
        int max=0;
        int index=0;
        for(int j=0; j<9; j++) {
            if(max<arr[j]) {
                max = arr[j];
                index=j+1;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }
}
