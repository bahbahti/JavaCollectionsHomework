package test;

import java.io.*;

public class WriteToFile {
    File myFile;
    PrintWriter writer;

    public WriteToFile(String fileName) {
        myFile = new File(fileName);
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(myFile, true)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void functionForWritingInFile(long value) {
            writer.print(value);
            writer.print(" ");
            writer.flush();
            //writer.close();
    }
    public void functionToCloseFile() {
        writer.close();
    }

    public void clearingOfFile(){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(myFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.close();
    }
}
