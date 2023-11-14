package org.codeforall.iorns;

import java.io.*;

public class FileManager {


    public static String readFile(){
        String result = "";


        try {
            FileReader fileReader = new FileReader("resources/grid.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            while((line = bufferedReader.readLine())!= null){

                result += line;


            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public  static void writeFile(String grid){

        try {

            FileWriter fileWriter = new FileWriter("resources/grid.txt");
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);

            bufferWriter.write(grid);
            bufferWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
