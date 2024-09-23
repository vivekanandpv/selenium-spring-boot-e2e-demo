package com.example.e2edemo.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

public class ReadExcelFile {
    public void read() throws IOException {
        File file = Path.of("/Users/vivekanandpv/states-capitals.xlsx").toFile();

        try (FileInputStream fileInputStream = new FileInputStream(file);) {
            Optional<Workbook> workbookOptional;

            if (file.getName().endsWith("xlsx")) {
                workbookOptional = Optional.of(new XSSFWorkbook(fileInputStream));
            } else if (file.getName().endsWith("xls")) {
                workbookOptional = Optional.of(new HSSFWorkbook(fileInputStream));
            } else {
                throw new RuntimeException("Unknown file type");
            }

            read(workbookOptional);
        }

    }

    private void read(Optional<Workbook> workbookOptional) {
        try (Workbook workbook = workbookOptional.orElseThrow(() -> new RuntimeException("Could not load the workbook"))) {
            Sheet sheet = workbook.getSheet("Sheet1");

            for (Row row : sheet) {
                System.out.println(String.format("\nRow: %d", row.getRowNum()));
                for (Cell cell : row) {
                    System.out.print(String.format("\t%s", cell.getStringCellValue()));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        ReadExcelFile ref = new ReadExcelFile();
        ref.read();
    }
}
