package learnJDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class CreateArr {
    private ArrayList<Employees> arrEmp = new ArrayList<Employees>();

    CreateArr() throws IOException {
        feelingArray();
    }

    private void feelingArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите ID сотрудника");
        int readUserId = Integer.parseInt(reader.readLine());
        System.out.println("Введите имя сотрудника");
        String readName = reader.readLine();
        System.out.println("Введите возраст сотрудника");
        int readAge = Integer.parseInt(reader.readLine());
        System.out.println("Введите номер кабинета сотрудника");
        int readRoomId = Integer.parseInt(reader.readLine());
        Employees employees = new EmployeesBuilder()
                .userId(readUserId)
                .name(readName)
                .age(readAge)
                .roomId(readRoomId)
                .bulid();
        arrEmp.add(employees);
    }

    ArrayList<Employees> getArrEmp() {
        return arrEmp;
    }

}
