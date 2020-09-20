package file;

import org.junit.Test;

import java.io.*;

public class TransferStream {

    @Test
    public void transfer() throws IOException{
        FileInputStream inputStream = new FileInputStream("hello3.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");

        char[] chars = new char[19];
        int c=0;
        while((c=inputStreamReader.read(chars))!=-1){
            String s = new String(chars, 0, c);
            System.out.print(s);
        }
        inputStreamReader.close();
    }

    @Test
    public void readerAndWriter() throws IOException{
        File file1 = new File("hello3.txt");
        File file2= new File("hello4.txt");
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
        OutputStreamWriter gbk = new OutputStreamWriter(fileOutputStream, "gbk");

        char[] chars = new char[19];
        int c=0;
        while((c=inputStreamReader.read(chars))!=-1){
            String s = new String(chars, 0, c);
            gbk.write(s);
        }
        inputStreamReader.close();
        gbk.close();
    }
}
