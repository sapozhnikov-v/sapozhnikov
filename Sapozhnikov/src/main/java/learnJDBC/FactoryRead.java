package learnJDBC;

public class FactoryRead {
    Read readFromStorage(StorageTypes type) {
        Read toReturn = null;
        switch (type) {
            case FILE:
                toReturn = new ReadFromFile();
                break;
            case LIST:
                toReturn = new ReadFromList();
                break;
            case DB:
                toReturn = new ReadFromDB();
                break;
            default:
                throw new IllegalArgumentException("Wrong storage type:" + type);
        }
        return toReturn;
    }
}
