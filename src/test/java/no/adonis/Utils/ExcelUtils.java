package no.adonis.Utils;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static List<List<String>> readExcel(String fileName) {
        HSSFWorkbook excel = null;
        try {
            excel = new HSSFWorkbook(new FileInputStream("src/test/resources/properties/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        HSSFSheet sheet = excel.getSheetAt(0);
        List<List<String>> table = new ArrayList<List<String>>();

        sheet.forEach(c->{
            List<String> list = new ArrayList<>();
            c.forEach(i->{
                list.add(i.toString());
            });
            table.add(list);
        });
        return table;
    }
}
