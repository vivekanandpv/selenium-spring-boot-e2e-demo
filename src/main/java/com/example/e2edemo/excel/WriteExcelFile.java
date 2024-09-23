package com.example.e2edemo.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class WriteExcelFile {
    public void write() throws IOException {
        File file = Path.of("/Users/vivekanandpv/states-capitals-2.xlsx").toFile();

        List<StateCapitalPair> pairList = List.of(
                new StateCapitalPair("Telangana", "Hyderabad"),
                new StateCapitalPair("Tamil Nadu", "Chennai"),
                new StateCapitalPair("Uttar Pradesh", "Lucknow"),
                new StateCapitalPair("Assam", "Guwahati"),
                new StateCapitalPair("Punjab", "Chandigarh")
        );

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);) {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("State-Capitals");


            for (int i = 0; i < pairList.size(); i++) {
                Row row = sheet.createRow(i);

                StateCapitalPair pair = pairList.get(i);
                Cell state = row.createCell(0);
                state.setCellValue(pair.getState());

                Cell capital = row.createCell(1);
                capital.setCellValue(pair.getCapital());
            }

            workbook.write(fileOutputStream);
        }
    }

    public static void main(String[] args) throws IOException {
        WriteExcelFile wef = new WriteExcelFile();
        wef.write();
    }
}

class StateCapitalPair {
    private final String state;
    private final String capital;

    public StateCapitalPair(String state, String capital) {
        this.state = state;
        this.capital = capital;
    }

    public String getState() {
        return state;
    }

    public String getCapital() {
        return capital;
    }
}
