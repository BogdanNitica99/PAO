package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogCSV {

    private static final String BASE_PATH = "./src/io/files/";

    public void writeLog(String information){
        try  {
            File file = new File(BASE_PATH + "log.csv");
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();

            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(file, true);
                fw.append("Action,Timestamp\n");
            }

            FileWriter fw = new FileWriter(file, true);

            fw.append(information);
            fw.append(",");
            fw.append(dateFormat.format(date));
            fw.append('\n');
            fw.flush();
            fw.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }


    }

}
