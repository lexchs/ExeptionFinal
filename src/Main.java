import util.ExeptionDataCatcher;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ExeptionDataCatcher {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ваши данные через пробел(Фамилия_Имя_Отчество_дата рождения_номер телефона_пол) ");
        String data = in.nextLine();
        String[] dataArr = data.split(" ");
        if (dataArr.length != 6) throw new ExeptionDataCatcher("Данных не хватает!");

        for (int i = 0; i < 3; i++) {
            if (!(dataArr[i] instanceof String)) throw new ExeptionDataCatcher("Неверные ФИО!");
        }
        String FullName = dataArr[0] + " " + dataArr[1] + " " + dataArr[2];

        if (dataArr[3].length() != 10) throw new ExeptionDataCatcher("Неверный формат даты!");
        String date = dataArr[3];
        try {
            int phone = Integer.parseInt(dataArr[4]);
        } catch (NumberFormatException e) {
            throw new ExeptionDataCatcher("Номер должен содержать только цифры!");
        }
        String phone = dataArr[4];
        String gender = dataArr[5];
        if (!gender.equals("m") && !gender.equals("f")) throw new ExeptionDataCatcher("Неверный формат пола!");
        if (gender.equals("m")) {
            gender = "Муж";
        } else {
            gender = "Жен";
        }
        String fileName = dataArr[0];

        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(String.format("%s, %s, %s, %s", FullName, date, phone, gender));
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}