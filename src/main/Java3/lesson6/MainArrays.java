package lesson6;

public class MainArrays {

    public static void main(String[] args) {
        int [] arr1 = {4,1, 3, 0, 7};
        int [] arr2 = {1,1,1,1,1,1,4,2};
        int [] mArr = modifiedArr(arr1);
//        for (int i = 0; i < mArr.length; i++) {
//            System.out.print(mArr[i]);
//        }
        boolean test = oneFourInArr(arr2);
        System.out.println(test);
    }

    public static int[] modifiedArr(int[] arr){
        int [] modArr;
        int i, j;
        for (i = arr.length-1; i > -1; i--) {
            if(arr[i] == 4){
                break;
            }
        }
        if(i == -1){
            throw new RuntimeException("There are no 4");
        }
        modArr = new int[arr.length-i-1];
        for (j = 0; j < modArr.length; j++){
            i++;
            modArr[j] = arr[i];
            System.out.print(modArr[j]);
        }
        return modArr;
    }

    public static boolean oneFourInArr(int[] arr){
        int oneCounter = 0, fourCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1){
                oneCounter++;
            }
            else if(arr[i]==4){
                fourCounter++;
            }
            else
                return false;
        }
        if(oneCounter==0 || fourCounter==0){
            return false;
        }
        return true;
    }
}
