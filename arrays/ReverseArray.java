import java.util.Scanner;

class ReverseArray {
    
	public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int testCase =  s.nextInt();
        while(testCase-- > 0){
            int size = s.nextInt();
            int arr[] = new int[size];
            for(int i = 0; i < arr.length; i++)
                arr[i] = s.nextInt();
            for (int i = 0; i < arr.length; i++) 
                System.out.print(arr[arr.length - 1 - i] + " ");
            System.out.println();
        }
	}
}