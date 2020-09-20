package file;

import org.junit.Test;

import java.io.*;

public class OtherStream {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true){
            String s = bufferedReader.readLine();
            if("e".equalsIgnoreCase(s)||"exit".equalsIgnoreCase(s)){
                break;
            }
            String s1 = s.toUpperCase();
            System.out.println(s1);
        }
        bufferedReader.close();
    }

    @Test
    public void test1() throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\IO\\test.txt"));
        PrintStream printStream = new PrintStream(fileOutputStream, true);
        System.setOut(printStream);

        for (int i = 0; i < 200; i++) {
            System.out.print((char)i);
        }
        printStream.close();
    }
}
