public class Main {
    public static void main(String[] args){
        int js = 80;
        int dsk= 20;
        int c = 0;
        System.out.println(Evklid(js, dsk));
        System.out.println(Evklid(js, c));
    }
    public static int Evklid(int a, int b){
        if (a == 0 || b == 0){
            return 0;
        }
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}