public class ReverseSquare {
    public static void main(String[] args) {
        int [] result = reverse(new int[]{1,1});


        for (int i : result){
            System.out.println(i);
        }
    }

    public static int [] reverse(int [] arr){

        if(arr.length < 1){
            return new int[]{};
        }
        int [] result = new int [arr.length];
        int s = 0; int e = arr.length - 1; int i = result.length - 1;
        while (s <= e){
            int squareS = arr[s] * arr[s];
            int squareE = arr[e] * arr[e];

            if (squareS > squareE){
                result[i] = squareS;
                --i;
                ++s;
            }
            else{
                result[i] = squareE;
                --e; --i;
            }
        }
        return result;
    }
}
