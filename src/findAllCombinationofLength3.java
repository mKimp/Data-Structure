public class findAllCombinationofLength3 {
    public static void main(String[] args) {
        int [] a = new int [] {1,2,3,4,5,6,7};
        int [] buffer = new int[3];
        printCombos(a, buffer, 0, 0);
    }

    public static void printCombos(int[]a, int[]buffer, int startIndex, int bufferIndex){
        if (bufferIndex == buffer.length){
            printArray(buffer);
            return;
        }
        if(startIndex == a.length)
            return;

        for (int i = startIndex; i < a.length; ++i){
            buffer[bufferIndex] = a[i];
            printCombos(a, buffer, i+1, bufferIndex +1);
        }
    }

    public static void printArray(int [] buffer){
        for (int i : buffer){
            System.out.print(i);
        }
    }
}
