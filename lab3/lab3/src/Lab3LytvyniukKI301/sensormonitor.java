package Lab3LytvyniukKI301;


// Абстрактний суперклас Monitor
abstract class Monitor {
    private String brand;
    private String size;
    private String color;

    public Monitor(String screenBrand, String screenSize, String screenColor) {
        brand = screenBrand;
        size = screenSize;
        color = screenColor;
    }


    public void printInfo() {
        System.out.println("Info: " + brand + " " + size + " " + color);
    }

    // Абстрактний метод, який буде реалізований в підкласі
    public abstract void touchScreen();
}

// Підклас TouchScreenMonitor, який реалізує інтерфейс Touchable
class TouchScreenMonitor extends Monitor implements Touchable {
    public TouchScreenMonitor(String screenBrand, String screenSize, String screenColor) {
        super(screenBrand, screenSize, screenColor);
    }

    // Реалізація абстрактного методу touchScreen
    @Override
    public void touchScreen() {
        System.out.println("Touch Screen Monitor: Touched the screen.");
    }
}

// Інтерфейс Touchable для сенсорних моніторів
interface Touchable {
    void touchScreen();
}

class Main {
    public static void main(String[] args) {
        TouchScreenMonitor touchMonitor = new TouchScreenMonitor("Samsung", "27 inches", "black");
        touchMonitor.touchScreen();
        touchMonitor.printInfo();
    }
}





