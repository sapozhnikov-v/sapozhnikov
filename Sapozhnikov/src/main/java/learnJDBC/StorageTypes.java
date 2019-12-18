package learnJDBC;

public enum StorageTypes {
    FILE("FILE"),
    LIST("LIST"),
    DB("DB");

    private String title;

    StorageTypes(String title) {
        this.title = title;
    }
}
