package file;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordCount {

    @Test
    public void word() throws Exception {
        FileReader fileReader = null;
        BufferedWriter bufferedWriter = null;

        HashMap<Character, Integer> map = new HashMap<>();
        fileReader = new FileReader("hello3.txt");
        int read=-1;
        while((read=fileReader.read())!=-1){
            char c = (char) read;
            if(map.get(c)==null){
                map.put(c,1);
            }
            else {
                map.put(c,map.get(c)+1);
            }
        }
        File file = new File("wordCount.txt");
        bufferedWriter = new BufferedWriter(new FileWriter(file));
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Character, Integer> entry: entrySet) {
            switch (entry.getKey()){
                case ' ':bufferedWriter.write("空格="+entry.getValue());
                    break;
                case '\t':bufferedWriter.write("tab="+entry.getValue());
                break;
                case '\r':bufferedWriter.write("回车="+entry.getValue());
                    break;
                case '\n':bufferedWriter.write("换行="+entry.getValue());
                    break;
                case '小':bufferedWriter.write("小="+entry.getValue());
                    break;
                default:bufferedWriter.write(entry.getKey()+"="+entry.getValue());
                break;
            }
            bufferedWriter.newLine();
        }
        fileReader.close();
        bufferedWriter.close();
    }

}
