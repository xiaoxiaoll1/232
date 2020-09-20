package file;

import org.junit.Test;

import java.io.*;

public class FileReaderWriterTest {


    @Test
    public void testFileReader(){
        File file = new File("src\\hello.txt");
        System.out.println(file.getAbsolutePath());
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            int read = fileReader.read();
            while (read!=-1){
                System.out.println((char)read);
                read=fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileReader!=null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void testFileReader2(){
        File file = new File("src\\hello.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            char[] cBuffer = new char[5];
            int read=-1;
            while ((read = fileReader.read(cBuffer))!=-1){
                for (int i = 0; i <read ; i++) {
                    System.out.println(cBuffer[i]);
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileReader!=null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void testFileWriter() throws IOException {
        File file = new File("hello1.txt");
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write("lao zi lai\n");
        fileWriter.write("le");
        fileWriter.close();
    }

    @Test
    public void testFileWriterAndReader(){
        File file = new File("src\\hello.txt");
        File file1 = new File("hello2.txt");
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(file1);
            char[] cBuffer = new char[5];
            int read=-1;
            while ((read = fileReader.read(cBuffer))!=-1){
                fileWriter.write(cBuffer,0,read);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileReader!=null) {
                    fileReader.close();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void testFileWriterAndReader3(){
        File file = new File("THL Logo.jpg");
        File file1 = new File("THL Logo4.jpg");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            byte[] cBuffer = new byte[5];
            int read=-1;
            while ((read = fis.read(cBuffer))!=-1){
                for (int i = 0; i <read ; i++) {
                    cBuffer[i] = (byte) (cBuffer[i] ^ 5);
                }
                fos.write(cBuffer,0,read);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null) {
                    fis.close();
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    @Test
    public void testFileWriterAndReader4(){
        File file = new File("THL Logo4.jpg");
        File file1 = new File("THL Logo5.jpg");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            byte[] cBuffer = new byte[5];
            int read=-1;
            while ((read = fis.read(cBuffer))!=-1){
                for (int i = 0; i <read ; i++) {
                    cBuffer[i] = (byte) (cBuffer[i] ^ 5);
                }
                fos.write(cBuffer,0,read);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null) {
                    fis.close();
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }



}
