import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {

    private String readFromConsole() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getPathToFile(String inOut) {
        switch (inOut) {
            case "in" -> System.out.println("Укажите путь к файлу: ");
            case "out" -> System.out.println("Укажите куда сохранить файл: ");
        }
        return readFromConsole();
    }

    public int chooseOperation() {
        System.out.println("""
                Выберите операцию:\s
                0 - Зашифровать текст при помощи ключа,
                1 - Расшифровать текст при помощи ключа,
                2 - Расшифровать текст при помощи brut force.""");
        int choice = Integer.parseInt(readFromConsole());
        switch (choice) {
            case 0 -> System.out.println("Вы выбрали: Зашифровать текст при помощи ключа.");
            case 1 -> System.out.println("Вы выбрали: Расшифровать текст при помощи ключа.");
            case 2 -> System.out.println("Вы выбрали: Расшифровать текст при помощи brut force.");
            default -> {
                System.out.println("Ошибка ввода, нужно ввести номер операции.");
                chooseOperation();
            }
        }
        return choice;
    }

    public int getKey() {
        System.out.println("Введите ключ шифрования от 1 до 20: ");
        int choice = 0;
        try {
            choice = Integer.parseInt(readFromConsole());
            if (choice < 1 || choice > 20) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода.");
            getKey();
        }
        return choice;
    }

    public void doneMessage() {
        System.out.println("Операция выполнена успешно!");
    }

    public void wrongPathToFile() {
        System.out.println("Вы указали не верный путь...");
    }
}
