import java.io.*;
import java.nio.file.*;
import java.util.*;

public class BinaryToCSV {

    public static void main(String[] args) {
        String binaryFilePath = "path/to/your/binaryfile.bin";//二级制文件地址
        String csvFilePath = "path/to/your/outputfile.csv";//csv文件地址
        String excelFilePath = "path/to/your/outputfile.csv";//excel文件地址
        try {
            File file = new File(binaryFilePath);

            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                // 在此处处理读取到的数据
            }
            bis.close();
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