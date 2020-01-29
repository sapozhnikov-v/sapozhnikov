package learnJDBC;

import java.io.IOException;

class FactoryStorage {
    SaveRead saveReadStorage(StorageTypes type) throws IOException {
        SaveRead toReturn = null;
        switch (type) {
            case FILE:
                toReturn = new File();
                break;
            case LIST:
                toReturn = new ListS();
                break;
            case DB:
                toReturn = new DB();
                break;
            default:
                throw new IllegalArgumentException("Wrong storage type:" + type);
        }
        return toReturn;
    }
}


