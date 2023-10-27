package lab1;

import java.io.*;
import java.util.*;

public class Lab1LytvyniukKI301 {

    public static void main(String[] args) throws FileNotFoundException {
        int N;
        char[][] arr;
        String filler;
        Scanner in = new Scanner(System.in);
        File datafile = new File("output.txt");
        PrintWriter fout = new PrintWriter(datafile);

        System.out.print("Введіть розмір матриці: ");
        N = in.nextInt();
        in.nextLine();

        arr = new char[N][N];
        
        System.out.print("Введіть символ заповнювач: ");
        filler = in.nextLine();

        exit:
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++) 
            {
                if (i > (N / 2)-1 ^ j > (N / 2)-1) 
                {
                    if (filler.length() == 1) 
                    {
                        arr[i][j] = filler.charAt(0);
                        System.out.print(arr[i][j] + " ");
                        fout.print(arr[i][j] + " ");
                    } 
                    else if (filler.length() == 0) 
                    {
                        System.out.print("\nНе введено символ заповнювач");
                        break exit;
                    } 
                    else 
                    {
                        System.out.print("\nЗабагато символів заповнювачів");
                        break exit;
                    }
                } 
                else 
                {
                    arr[i][j] = ' ';
                    System.out.print(arr[i][j] + " ");
                    fout.print(arr[i][j] + " ");
                }
            }
            System.out.print("\n");
            fout.print("\n");
        }
        fout.flush();
        fout.close();
    }
}
