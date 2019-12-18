package learnJDBC;

public class EmployeesBuilder {
    private int userId;
    private String name;
    private int age;
    private int roomId;


    public EmployeesBuilder userId(int userId) {
        this.userId = userId;
        return this;
    }

    public EmployeesBuilder name(String name) {
        this.name = name;
        return this;
    }

    public EmployeesBuilder age(int age) {
        this.age = age;
        return this;
    }

    public EmployeesBuilder roomId(int roomId) {
        this.roomId = roomId;
        return this;
    }

    public Employees bulid() {
        return new Employees(this);
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getRoomId() {
        return roomId;
    }
}
