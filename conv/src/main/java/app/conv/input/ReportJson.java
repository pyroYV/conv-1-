package app.conv.input;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

public class ReportJson {

    private static ObjectMapper mapper = getDefautMapper();
    
    private static ObjectMapper getDefautMapper() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper;
    }
    
    public static void parseJsonArray(String src) throws IOException{
        
        // List<Report> reports = new ArrayList<Report>();
        
        JsonNode jsonNode = mapper.readTree(src);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Report");
        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);
        headerStyle.setFillBackgroundColor(IndexedColors.GREY_80_PERCENT.getIndex());
        header.setRowStyle(headerStyle);
        
        header.createCell(0).setCellValue("id");
        header.createCell(1).setCellValue("type");
        header.createCell(2).setCellValue("zoneCode");
        header.createCell(3).setCellValue("zoneDescription");
        header.createCell(4).setCellValue("name");
        header.createCell(5).setCellValue("companyId");
        header.createCell(6).setCellValue("company");
        header.createCell(7).setCellValue("address");
        header.createCell(8).setCellValue("transformers");

        
        int rowNum = 1;
        for (JsonNode node : jsonNode) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(node.get("id").toString());
            row.createCell(1).setCellValue(node.get("type").toString());
            row.createCell(2).setCellValue(node.get("zoneCode").toString());
            row.createCell(3).setCellValue(node.get("zoneDescription").toString());
            row.createCell(4).setCellValue(node.get("name").toString());
            row.createCell(5).setCellValue(node.get("companyId").toString());
            row.createCell(6).setCellValue(node.get("company").toString());
            row.createCell(7).setCellValue(node.get("address").toString());
            // row.createCell(8).setCellValue(node.get("features").get("transformation").get("power").toString());
        }


        
        
        
        FileOutputStream fileout = new FileOutputStream("conv\\src\\main\\java\\app\\conv\\output\\report.xlsx");
        workbook.write(fileout);
        fileout.close();
        System.out.println("Excel written successfully..");
        // for (JsonNode node : jsonNode) {

        //    System.out.println(node.get("id").toString()); 
        //       System.out.println(node.get("type").toString());
        //         System.out.println(node.get("zoneCode").toString());
        //             System.out.println(node.get("zoneDescription").toString());
        //                 System.out.println(node.get("name").toString());
        //                 System.out.println(node.get("companyId").toString());
        //                     System.out.println(node.get("company").toString());
        //                     System.out.println(node.get("address").toString());
        //                         System.out.println(node.get("features").toString());
        //                         System.out.println(node.get("features").get("transformers").toString());
        //     reports.add(mapper.readValue(node.toString(), Report.class));
        // }
        
        // return reports.toString();
    }

    // public static void StringtoXsx(String src) throws IOException{
        
        
    
    // }
}
