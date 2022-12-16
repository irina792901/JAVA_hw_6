public class Laptop {
    private String brand;
    private float diagonal;
    private String screenType;
    private String os;
    private int ram;
    private int rom;
    private int battery;
    private String color;

//    public Laptop(String brand) {
//        this.brand = brand;
//    }

    @Override
    public String toString() {
        StringBuilder queryClient = new StringBuilder();
        queryClient.append("Ноутбук: ");
        if (brand != null) queryClient.append(brand + " ");
        if (diagonal != 0) queryClient.append("диагональ экрана: " + diagonal + " ");
        if (screenType != null) queryClient.append("тип матрицы дисплея: " + screenType + " ");
        if (os != null) queryClient.append("операционная система: " + os + " ");
        if (ram != 0) queryClient.append("размер ОЗУ: " + ram + " ");
        if (rom != 0) queryClient.append("объём жёсткого диска: " + rom + " ");
        if (battery != 0) queryClient.append("ёмкость аккумулятора: " + battery + " ");
        if (color != null) queryClient.append("цвет корпуса: " + color + " ");
        return String.valueOf(queryClient);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(float diagonal) {
        this.diagonal = diagonal;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}


