/*package sortfromfile;

public class Sort{
    public void sort (ArrayContainer arrayContainer){
        System.out.println("Сортируем по возрастанию:");
        copyArray();
        boolean sorted = true;
        do {
            sorted = true;
            for (int i = 0; i< arr1.length-1; i++){
                if (arr1[i]> arr1[i+1]){
                    int b = arr1[i+1];
                    arr1[i+1] = arr1[i];
                    arr1[i] = b;
                    sorted=false;
                }
            }
        }
        while(!sorted);

        this.fileArr1=arr1;
    }

    private int [] fileArr1 = new int[10];

    public int [] getSortedArray (){
               return fileArr1;
    }
    public int [] copyArray (ArrayContainer arrayContainer){
        int [] arr1 = new int[arrayContainer.getArray().length];
        for (int i=0; i<arrayContainer.getArray().length; i++){
            arr1[i]=arrayContainer.getArray()[i];
        }
        return arr1;
    }
        public int [] sortArray();
    }
*/