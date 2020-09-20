package file;


import org.junit.Test;

import java.io.*;

public class FileInput {
    
    @Test
    public void testFileReader2(){
        File file = new File("src\\hello.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] cBuffer = new byte[5];
            int read=-1;
            while ((read = fis.read(cBuffer))!=-1){
                String string = new String(cBuffer,0,read);

                System.out.print(string);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    @Test
    public void testFileWriterAndReader(){
        File file = new File("THL Logo.jpg");
        File file1 = new File("THL Logo2.jpg");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            byte[] cBuffer = new byte[5];
            int read=-1;
            while ((read = fis.read(cBuffer))!=-1){
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
    public void testBufferWriterAndReader(){
        File file = new File("THL Logo.jpg");
        File file1 = new File("THL Logo3.jpg");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            bis = new BufferedInputStream(fis);
            bos  = new BufferedOutputStream(fos);
            byte[] cBuffer = new byte[5];
            int read=-1;
            while ((read = bis.read(cBuffer))!=-1){
                bos.write(cBuffer,0,read);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null) {
                    bis.close();
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void testBufferWriterAndReader2(){
        File file = new File("src\\hello.txt");
        File file1 = new File("hello3.txt");
       FileReader fileReader=null;
       FileWriter fileWriter = null;
       BufferedReader bufferedReader = null;
       BufferedWriter bufferedWriter = null;
        try {
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(file1);
            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter  = new BufferedWriter(fileWriter);
            char[] cBuffer = new char[5];
            String data=null;
           while((data=bufferedReader.readLine())!=null){
               bufferedWriter.write(data);
             // bufferedWriter.newLine();
           }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileReader!=null) {
                    bufferedReader.close();
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
