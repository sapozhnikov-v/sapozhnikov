package learnJDBC;

class FactorySave {
    Save getSaveStorage(StorageTypes type) {
        Save toReturn = null;
        switch (type) {
            case FILE:
                toReturn = new SaveToFile();
                break;
            case LIST:
                toReturn = new SaveToList();
                break;
            case DB:
                toReturn = new SaveToDB();
                break;
            default:
                throw new IllegalArgumentException("Wrong storage type:" + type);
        }
        return toReturn;
    }
}


