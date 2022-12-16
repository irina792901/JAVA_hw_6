import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 * Создать множество ноутбуков.
 * Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
 * Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
 * <p>
 * сдать работу в виде ссылки на гит репозиторий.
 *
 * @author Шипунова Ирина группа 3417/2
 */
public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Set<Laptop> laptops = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            Laptop lap = new Laptop();
            lap.setBrand(brand(rnd.nextInt(8)));
            lap.setDiagonal(diagonal(rnd.nextInt(8)));
            lap.setScreenType(screenType(rnd.nextInt(4)));
            lap.setOs(os(rnd.nextInt(3)));
            lap.setRam(ram(rnd.nextInt(5)));
            lap.setRom(rom(rnd.nextInt(5)));
            lap.setBattery(battery(rnd.nextInt(3)));
            lap.setColor(color(rnd.nextInt(2)));
            System.out.println(lap);
            laptops.add(lap);
        }
        filter_query(laptops);
    }

    public static String brand(int x) {
        String[] brand = new String[]{"Lenovo", "HP", "Aser", "Dell", "Apple", "Asus", "Huawei", "Evoo"};
        return brand[x];
    }

    public static float diagonal(int x) {
        float[] diagonal = new float[]{10.1f, 11.6f, 12.5f, 13.3f, 14.1f, 15.6f, 17.3f, 18.4f};
        return diagonal[x];
    }

    public static String screenType(int x) {
        String[] screen = new String[]{"TN", "VA", "IPS", "OLED"};
        return screen[x];
    }

    public static String os(int x) {
        String[] os = new String[]{"Windows", "Linux", "MacOs"};
        return os[x];
    }

    public static int ram(int x) {
        int[] ram = new int[]{2, 4, 8, 16, 32};
        return ram[x];
    }

    public static int rom(int x) {
        int[] rom = new int[]{128, 256, 512, 1024, 2048};
        return rom[x];
    }

    public static int battery(int x) {
        int[] buttery = new int[]{2200, 2400, 2600};
        return buttery[x];
    }

    public static String color(int x) {
        String[] color = new String[]{"черный", "серебристый"};
        return color[x];
    }

    public static void filter_query(Set<Laptop> laptops) {
        System.out.println("Наберите через пробел цифры, соответствующие критериям фильтра \n" +
                "1 - торговая марка \n" +
                "2 - диагноаль экрана \n" +
                "3 - тим матрицы дисплея \n" +
                "4 - операционная система \n" +
                "5 - объём операционной памяти \n" +
                "6 - объём жесткого диска \n" +
                "7 - размер батареи \n" +
                "8 - цвет корпуса");
        Scanner sc = new Scanner(System.in);
        String[] query = sc.nextLine().split(" ");
        Laptop dream = new Laptop();
        for (int i = 0; i < query.length; i++) {
            switch (Integer.parseInt(query[i])) {
                case 1:
                    System.out.println("Выберите бренд: \n" +
                            "1 - Lenovo \n" + "2 - HP \n" + "3 - Aser \n" +
                            "4 - Dell \n" + "5 - Apple \n" +
                            "6 - Asus \n" + "7 - Evoo");
                    dream.setBrand(brand(Integer.parseInt(sc.nextLine()) - 1));
                    break;
                case 2:
                    System.out.println("Введите желаемый размер диагонали в дюймах: ");
                    dream.setDiagonal(Float.parseFloat(sc.nextLine()));
                    break;
                case 3:
                    System.out.println("Выберите желаемый тип матрицы дисплея: \n" +
                            "1 - TN \n" + "2 - VA \n" + "3 - IPS \n" + "4 - OLED");
                    dream.setScreenType(screenType(Integer.parseInt(sc.nextLine()) - 1));
                    break;
                case 4:
                    System.out.println("Выберите тип операциооной системы: \n" +
                            "1 - Windows \n" + "2 - Linux \n" + "3 - MacOs");
                    dream.setOs(os(Integer.parseInt(sc.nextLine()) - 1));
                    break;
                case 5:
                    System.out.println("Введите желаемый объём оперативной памяти в Гб: ");
                    dream.setRam(Integer.parseInt(sc.nextLine()));
                    break;
                case 6:
                    System.out.println("Введите желаемый объём жёсткого диска в Гб: ");
                    dream.setRom(Integer.parseInt(sc.nextLine()));
                    break;
                case 7:
                    System.out.println("Введите желаемyю батарею в мА/час: ");
                    dream.setBattery(Integer.parseInt(sc.nextLine()));
                    break;
                case 8:
                    System.out.println("Введите желаемый цвет корпуса: \n" +
                            "1 - чёрный \n" + "2 - серебристый \n");
                    dream.setColor(color(Integer.parseInt(sc.nextLine()) - 1));
                    break;
            }
        }
        Set<Laptop> dreamComeTrue = new HashSet<>();
        for (Laptop item : laptops) {
            if ((item.getBrand().equals(dream.getBrand()) || dream.getBrand()==null)
            && (item.getDiagonal() >= dream.getDiagonal() || dream.getDiagonal()==0)
            && (item.getScreenType().equals(dream.getScreenType()) || dream.getScreenType()==null)
            && (item.getOs().equals(dream.getOs()) || dream.getOs()==null)
            && (item.getRam() >= dream.getRam() || dream.getRam()==0)
            && (item.getRom() >= dream.getRom() || dream.getRom()==0)
            && (item.getBattery() >= dream.getBattery() || dream.getBattery()==0)
            && (item.getColor().equals(dream.getColor()) || dream.getColor()==null)){
                dreamComeTrue.add(item);
            }
        }
        if (dreamComeTrue.isEmpty()) System.out.println("По вашему запросу ничего не найдено");
        else {
            for (Laptop item : dreamComeTrue) {
                System.out.println(item);
            }
        }
    }
}
