package model;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DefaultCalculatorHistory implements iGetModel{
    private String fileName;

    public DefaultCalculatorHistory(String fileName) {

        this.fileName = fileName;
    }

    @Override
    public void setHistory(String operation) {
        File history = new File(fileName);
        try {
            history.createNewFile();
        }catch (IOException e){
            System.out.println("Файл найден");
        }
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss':'");

        try(FileWriter writer = new FileWriter(fileName, true))
        {

            String operationFormat = formatForDateNow.format(dateNow)+"\t"+operation+"\n";
            writer.write(operationFormat);

            writer.flush();
        }
        catch(IOException e){
            System.out.println("Ошибка записи в файл");
        }

    }

    @Override
    public String[] getOperationHistory(int quantity ) {

        String file="";
        try {

            FileReader fileReader=new FileReader(fileName);
            BufferedReader bufferedReader =new BufferedReader(fileReader);

            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) break;

                file += line+'\n';
            }
            bufferedReader.close();
            fileReader.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(file);


        String[] fileArray =  file.split("\n");

        if (fileArray.length<quantity){
            String [] operationList =  new String[fileArray.length];
            int counter=0;
            for (int i = fileArray.length-1; i >= 0; i--) {
                operationList[counter]=fileArray[i];
                counter++;
            }
            return operationList;
        }

        String [] operationList =  new String[quantity];
        int counter=0;
        for (int i = fileArray.length-1; i >= fileArray.length- quantity; i--) {
            operationList[counter]=fileArray[i];
            counter++;

        }

        return operationList;
    }
}
