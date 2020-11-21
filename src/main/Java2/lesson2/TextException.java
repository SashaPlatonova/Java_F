package lesson2;

public class TextException {
    public static void main(String[] args) {
        String [][] userArray = {{"1", "ppppp","4", "5"},
                {"1", "3", "7", "10"},
                {"10", "60", "3", "4"},
                {"2", "6", "78", "8"}};
        try {
            catchMyException(userArray);
        } catch (MyArraySizeException e) {
            System.out.println("Введен массив недопустимого размера");
        }
        catch (MyArrayDataException e){

        }

    }
    public static void catchMyException (String [][] array) throws MyArraySizeException,
            MyArrayDataException {
        int sum = 0;
        if (array.length!=4){
            throw new MyArraySizeException();
        }
        for (int i = 0; i<4; i++){
            if (array[i].length!=4){
                throw new MyArraySizeException();
            }
            for (int j = 0; j<4; j++){
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (RuntimeException e){
                    throw new MyArrayDataException("Некоректные данные в ячейке [" + i + "][" + j + "]");
                }
                finally {
                    continue;
                }
            }
        }
        System.out.println("Сумма элементов массива = " + sum);
    }
}
