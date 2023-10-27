package Lab4LytvyniukKI301;

import java.util.Scanner;
import java.io.*;
import static java.lang.System.out;

public class catch_lab {
    public static void main(String[] args) {
        try {
            out.print("Enter file name: ");
            Scanner in = new Scanner(System.in);
            String fName = in.nextLine();
            PrintWriter fout = new PrintWriter(new File(fName));
            
            try {
                Equations eq = new Equations();
                out.print("Enter X: ");
                int x = in.nextInt();
                double result = eq.calculate(x);
                fout.print("Result: " + result);
            } catch (CalcException ex) {
                out.print(ex.getMessage());
            } finally {
                fout.flush();
                fout.close();
            }
        } catch (FileNotFoundException ex) {
            out.print("Exception reason: Perhaps wrong file path");
        }
    }
}

class CalcException extends ArithmeticException {
    public CalcException() {
    }

    public CalcException(String cause) {
        super(cause);
    }
}

class Equations {
    public double calculate(int x) throws CalcException {
        double y, rad;
        rad = x * Math.PI / 180.0;

        try {
            y = Math.cos(rad) / Math.sin(rad);
            if (Double.isInfinite(y) || Double.isNaN(y)) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException ex) {
            if (rad == Math.PI / 2.0 || rad == -Math.PI / 2.0) {
                throw new CalcException("Exception reason: Illegal value of X for tangent calculation");
            } else if (x == 0) {
                throw new CalcException("Exception reason: X = 0");
            } else {
                throw new CalcException("Unknown reason of the exception during exception calculation");
            }
        }
        return y;
    }
}