package org.example;

import com.moandjiezana.toml.Toml;
//import com.moandjiezana.toml.TomlParseResult;
import com.alibaba.excel.EasyExcel;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;


public class BinaryToCSV {

    public static CSVFormat customCsvFormat(String[] CSV_HEAD){
        return CSVFormat.Builder.create()
                .setAllowMissingColumnNames(false) // 不允许丢失字段名称，默认为True
                .setDelimiter(",") //默认为逗号
                .setHeader(CSV_HEAD) // CSV 表头
                .setTrim(true) // 去除数据两边的空格，如 "Abc " 则实际输出为"Abc"，但是数据为"A bc",实际输出还是"A bc"
                .build();
    }
    public static void generateCsvWithConfig(int n,List<String[]> Strs, CSVFormat csvFormat,String writepath){
        // 可以通过设置FileWriter的编码来控制输出文件的编码格式
        // FileWriter fileWriter = new FileWriter("ApacheCsv.csv", StandardCharsets.UTF_8);
        try(FileWriter fileWriter = new FileWriter(writepath+"CSV"+String.format("%04d",n)+".csv", StandardCharsets.UTF_8);
            CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat)){
            // 会将整个String 列表作为一条数据行写入
            // csvPrinter.printRecord(users);
            // 默认配置不会写表头，如果需要添加表头可以单独设置表头
            //System.out.println(writepath+"测试文档"+String.format("%04d",n)+".csv");
            for (String[] str : Strs) {
                csvPrinter.printRecord(str);
            }
            // 输出一个空行
            csvPrinter.println();
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void bintocsv(int splitnum,String writepath,List<String> handarr,List<String[]> row){
        int part = row.size()/splitnum;
        String[] headerArr = handarr.toArray(new String[handarr.size()]);
        int n =0;
        for(;n < part; n++){
        generateCsvWithConfig(n,row.subList(n*splitnum, (n+1)*splitnum), customCsvFormat(headerArr),writepath);
        }
        if (!row.isEmpty()) {
            generateCsvWithConfig(n, row.subList((n)*splitnum, row.size()), customCsvFormat(headerArr),writepath);
        }
        System.out.println("数据成功写出到CSV文件中");
    }
    public static void bintoexcel(int splitnum,String writepath,List<String> handarr,List<String[]> row){
        List<ExcelTO> excels = new ArrayList<>();
        String[] headerArr = handarr.toArray(new String[handarr.size()]);
        int n=0;
        for(int i=0;i< row.size();i++){//excel以类的方式传入
            //System.out.println(Arrays.toString(row.get(i)));
            ExcelTO excel = new ExcelTO(row.get(i));
            //System.out.println(excel);
            excels.add(excel);
        }
        int part = excels.size()/splitnum;
        for(;n < part; n++){
            EasyExcel.write(writepath+"excel"+String.format("%04d",n)+".xlsx").head(ExcelTO.class).sheet("测试").doWrite(excels.subList(n*splitnum, (n+1)*splitnum));
            //generateCsvWithConfig(n,row.subList(n*splitnum, (n+1)*splitnum), customCsvFormat(headerArr),writepath);
        }
        if (!excels.isEmpty()) {
            EasyExcel.write(writepath+"excel"+String.format("%04d",n)+".xlsx").head(ExcelTO.class).sheet("测试").doWrite(excels.subList((n)*splitnum, excels.size()));
            //generateCsvWithConfig(n, row.subList((n)*splitnum, row.size()), customCsvFormat(headerArr),writepath);
        }
        System.out.println("数据成功写出到Excel文件中");
    }

    public static void main(String[] args) {
        //读取toml配置
        Toml toml = new Toml().read(new File("src/config.toml"));
        String readpath = toml.getString("setting.readpath");
        String writepath = toml.getString("setting.writepath");
        List<String> handarr = toml.getList("setting.handarr");
        String writeform = toml.getString("setting.writeform");
        String splitstr = toml.getString("splitchar");
        int splitnum = toml.getLong("setting.splitnum").intValue();
        //处理bin中数据，用row存储
        List<String[]> row = new ArrayList<>();
        try {
            //File file = new File(binaryFilePath);
            //BufferedReader fis = new BufferedReader(new FileReader(binaryFilePath));
            BufferedReader fis = new BufferedReader(new InputStreamReader(new FileInputStream(readpath), "gbk"));
            //FileInputStream fis = new FileInputStream(file);
            //BufferedInputStream bis = new BufferedInputStream(fis);
            String line ;
            while ((line = fis.readLine()) != null) {
                // 处理每一行的逻辑
                String[] values = line.split("\u0001",-1); // 使用0001分割每一行的值
                row.add(values);
            }
            fis.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        //选择进程
        if (writeform.equals("CSV")){
            System.out.println("输出CSV");
            bintocsv(splitnum, writepath, handarr, row);
        } else if (writeform.equals("EXCEL")) {
            System.out.println("输出EXCEL");
            bintoexcel(splitnum,writepath, handarr, row);
        }
    }








//        String binaryFilePath = "src/样本.txt";//二级制文件地址
//        //String csvFilePath = "path/to/your/outputfile.csv";//csv文件地址
//        String[] headerArr = new String[]{"名字", "公司", "介绍","公司", "地址", "身份证", "时间", "法人", "注册金额", "编号", "网址"};
//        char a = 200;//分割的函数大小
//        int n = 0;
//
//        List<ExcelTO> excels = new ArrayList<>();
//        for(int i=0;i< row.size();i++){
//            //System.out.println(Arrays.toString(row.get(i)));
//            ExcelTO excel = new ExcelTO(row.get(i));
//            //System.out.println(excel);
//            excels.add(excel);
//        }
////        int part = row.size()/a;
////        for(;n < part; n++){
//
//        EasyExcel.write("src/测试"+String.format("%04d",n)+".xlsx").head(ExcelTO.class).sheet("测试").doWrite(excels);
//        System.out.println("数据成功写出到Excel文件中");
//            //generateCsvWithConfig(n,row.subList(n*a, (n+1)*a), customCsvFormat(headerArr));
////        }
////        if (!row.isEmpty()) {
////            //generateCsvWithConfig(n, row.subList((n)*a, row.size()), customCsvFormat(headerArr));
////        }
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