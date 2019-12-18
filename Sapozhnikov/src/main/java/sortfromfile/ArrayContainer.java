package sortfromfile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArrayContainer {
    private int[] fileArr = new int[10];
    public ArrayContainer() throws IOException {
        BufferedReader readerfile = new BufferedReader((new FileReader(ReadName.getName())));
        int[] fileArr = new int[10];
        for (int i = 0; i < fileArr.length; i++) {
            fileArr[i] = Integer.parseInt(readerfile.readLine());
            this.fileArr=fileArr;
        }
        readerfile.close();
    }
    public int[] getArray(){
        return fileArr;
    }

}
