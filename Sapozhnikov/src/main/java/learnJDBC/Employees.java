package learnJDBC;

public class Employees {
    private final int userId;
    private final String name;
    private final int age;
    private final int roomId;

    Employees(EmployeesBuilder builder) {
        this.userId = builder.getUserId();
        this.name = builder.getName();
        this.age = builder.getAge();
        this.roomId = builder.getRoomId();
    }


    int getUserId() {
        return userId;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    int getRoomId() {
        return roomId;
    }

    @Override
    public String toString() {
        return this.userId + "|" + this.name + "|" + this.age + "|" + this.roomId;
    }
}


