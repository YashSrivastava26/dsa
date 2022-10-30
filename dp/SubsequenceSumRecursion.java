import java.util.ArrayList;
//PRINTALL
/*public class SubsequenceSumRecursion {
    static void printS(int index, ArrayList<Integer> ds, int currSum, int[] arr, int sum){
            if( index == arr.length){
                if(currSum == sum){
                    for (var i : ds) {
                        System.out.print(i+" ");
                    }
                    System.out.println();
                }
                return;
            }
            ds.add(arr[index]);
            currSum += arr[index];
            printS(index + 1, ds, currSum, arr, sum);
            ds.remove(ds.size() - 1);
            currSum -= arr[index];
            printS(index + 1, ds, currSum, arr, sum);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int sum = 2;
        ArrayList<Integer> ds = new ArrayList<>();
        printS(0, ds, 0, arr, sum);

    }
}*/
//PRINT ANY ONE
/*public class SubsequenceSumRecursion {
    static boolean printS(int index, ArrayList<Integer> ds, int currSum, int[] arr, int sum){
            if( index == arr.length){
                if(currSum == sum){
                    for (var i : ds) {
                        System.out.print(i+" ");
                    }
                    System.out.println();
                    return true;
                }
                return false;
            }
            
            ds.add(arr[index]);
            currSum += arr[index];
            if(printS(index + 1, ds, currSum, arr, sum))
                return true;//answer found
            ds.remove(ds.size() - 1);
            currSum -= arr[index];
            if(printS(index + 1, ds, currSum, arr, sum))
                return true;
            return false;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int sum = 2;
        ArrayList<Integer> ds = new ArrayList<>();
        printS(0, ds, 0, arr, sum);

    }
}*/
//COUNT NUMBER WHICH SATISFIED CONDITION
public class SubsequenceSumRecursion {
    static int printS(int index, int currSum, int[] arr, int sum){
            if( index == arr.length){
                if(currSum == sum) return 1;
                return 0;
            }

            currSum += arr[index];
            int l = printS(index + 1, currSum, arr, sum);

            currSum -= arr[index];
            int r = printS(index + 1, currSum, arr, sum);
            return l + r;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int sum = 2;
        System.out.println(printS(0, 0, arr, sum));

    }
}
