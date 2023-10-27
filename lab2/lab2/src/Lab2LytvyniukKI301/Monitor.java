package Lab2LytvyniukKI301;

import java.io.FileWriter;
import java.io.IOException;

class MonitorComponent {
    private String componentName;

    public MonitorComponent(String componentName) {
        this.componentName = componentName;
    }

    public void start() {
        log("Запуск компоненту " + componentName);
    }

    public void stop() {
        log("Зупинка компоненту " + componentName);
    }

    private void log(String message) {
        try {
            FileWriter writer = new FileWriter("log.txt", true);
            writer.write(message + "\n");
            writer.close();
        } catch (IOException e) {
            System.err.println("Помилка запису в лог-файл: " + e.getMessage());
        }
    }

}

public class Monitor {
    private MonitorComponent screen;
    private MonitorComponent cpu;
    private MonitorComponent speaker;
    private String brand;
    private String size;
    private String color;

    public Monitor(String screenBrand, String screenSize, String screenColor) {
        screen = new MonitorComponent("Екран");
        cpu = new MonitorComponent("Процесор");
        speaker = new MonitorComponent("Динамік");
        brand = screenBrand;
        size = screenSize;
        color = screenColor;
    }

    public void powerOn() {
        screen.start();
        cpu.start();
        speaker.start();
    }

    public void powerOff() {
        screen.stop();
        cpu.stop();
        speaker.stop();
    }
    
    public void printInfo() {
        System.out.println("Інфо: " + brand + " " + size + " "+ color);
    }

    public static void main(String[] args) {
        Monitor monitor = new Monitor("Samsung", "27 дюймів", "чорний");
        
        monitor.powerOn();
        monitor.powerOff();
        
        monitor.printInfo();
    }
}