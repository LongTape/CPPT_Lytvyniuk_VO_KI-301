package lab5;

import java.util.Scanner;
import java.io.*;
import java.io.DataInputStream;

public class binary_out {
    public static void main(String[] args) {
        try {
            System.out.print("Enter file name: ");
            Scanner in = new Scanner(System.in);
            String fName = in.nextLine();
            PrintWriter textOutput = new PrintWriter(new File(fName));
            DataOutputStream binaryOutput = new DataOutputStream(new FileOutputStream(fName + ".dat"));

            try {
                Equations eq = new Equations();
                System.out.print("Enter X: ");
                int x = in.nextInt();
                double result = eq.calculate(x);
                textOutput.print("Result: " + result);
                binaryOutput.writeDouble(result);
            } catch (CalcException ex) {
                System.out.print(ex.getMessage());
            } finally {
                textOutput.flush();
                textOutput.close();
                binaryOutput.close();
            }

            //читання і виводу даних з файлу .dat
            try (DataInputStream binaryInput = new DataInputStream(new FileInputStream(fName + ".dat"))) {
                double result = binaryInput.readDouble();
                System.out.println("Read result from binary file: " + result);
            } catch (IOException ex) {
                System.err.println("Error reading binary file: " + ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.print("Exception reason: Perhaps wrong file path");
        } catch (IOException ex) {
            System.out.print("Error writing to binary file: " + ex.getMessage());
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