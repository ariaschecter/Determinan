import java.util.Arrays;

public class Determinan {
    public static void main(String[] args) {
        int[][] matriks = {
                {1,-2,0,0},
                {3,2,-3,1},
                {4,0,5,1},
                {2,3,-1,4}
        };

        int[][] Buffer = new int[matriks.length][2 * matriks[0].length - 1];

        int i,j;

        int m = matriks.length; // kebawah
        int n = matriks[0].length; // menyamping

        for(i = 0; i < m; i++){
            for (j = 0; j < n; j++){
                Buffer[i][j] = matriks[i][j];
            }
        }

        for(i = 0; i < m ; i++){
            for(j = 0; j < n - 1; j++){
                Buffer[i][j + n] = matriks[i][j];
            }
        }

        System.out.println("Determinan......");

        int temp = 1;
        int hasil = 0;

        for (j=0; j<m;j++){
            for(i=0;i<n;i++){
                temp = temp * Buffer[i][j+i];
            }
            hasil = hasil + temp;
            temp = 1;
        }
        int buff;

        for (j=m-1; j<(2 * m - 1);j++){ // 2 3 4 5
            buff = j;
            for(i=0;i<n;i++){ // 0 1 2
                temp = temp * Buffer[i][buff--];
            }
            hasil = hasil - temp;
            temp = 1;
        }
        for(i = 0; i < matriks.length; i++){
            System.out.println(Arrays.toString(matriks[i]));
        }
        System.out.println("Determinan = " + hasil);
        
    }
}
