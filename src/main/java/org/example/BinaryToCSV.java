package org.example;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class BinaryToCSV {

    public static void main(String[] args) {
        String binaryFilePath = "src/样本.txt";//二级制文件地址
        //String csvFilePath = "path/to/your/outputfile.csv";//csv文件地址
        //String excelFilePath = "path/to/your/outputfile.csv";//excel文件地址
        char a = 1;
        try {
            //File file = new File(binaryFilePath);
            //BufferedReader fis = new BufferedReader(new FileReader(binaryFilePath));
            BufferedReader fis = new BufferedReader(new InputStreamReader(new FileInputStream(binaryFilePath), "gbk"));
            //FileInputStream fis = new FileInputStream(file);
            //BufferedInputStream bis = new BufferedInputStream(fis);
            String line ;
            int n = 0;
            while ((line = fis.readLine()) != null) {
                // 处理每一行的逻辑
                String[] values = line.split("\u0001"); // 使用0001分割每一行的值
                List<String> row = new ArrayList<>();
                for (String value : values) {
                    System.out.println(value);
                    row.add(value.trim()); // 去除每个值的空格并添加到行中
                }
                n++;
                if (n>=100){
                    break;
                }
            }
            fis.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
















//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
//    }
//}