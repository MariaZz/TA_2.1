import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("input.txt"));
            PrintWriter prW = new PrintWriter("output.txt");
            int n =sc.nextInt();
            int []array=new int [2*n];
            int j=0;
            while (sc.hasNext()) {
                array[j]=sc.nextInt();
                j++;
            }
            double min=minSum(array,n)*100;
            int m= (int) min;
            min=(double) m;
            min=min/100;
            prW.print(min);
            prW.flush();
        }  catch (InputMismatchException e) {
            System.out.println("Incorrect input data!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sc != null) sc.close();
        }
    }
    private static double minSum(int []ar,int n){
        double res=0,s;
        int k=0;
        int []array=new int[ar.length-2];
        for(int i=0;i<n-3;i++){
            for(int j=0;j<2*n;j++){
                if(j!=(i*2+2)&& j!=(i*2 +3)) {
                    array[k] =ar[j];
                    k++;
                }
            }
            if(n>4)
            {  s = len(i * 2,i*2+4,ar );
            s+=minSum(array,n-1) ;}
            else s=len(i * 2,i*2+4,ar );
            if(res!=0){
                if(res>s) res=s;
            }
            else res=s;

            k=0;
        }
        return res;
    }
    private static double len(int i1,int i2, int [] ar){
        double l = Math.sqrt((ar[i1]-ar[i2])*(ar[i1]-ar[i2]) + (ar[i1+1]-ar[i2+1])*(ar[i1+1]-ar[i2+1]));
        return l;
    }
}
