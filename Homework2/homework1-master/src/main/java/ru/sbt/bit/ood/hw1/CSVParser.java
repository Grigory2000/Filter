package ru.sbt.bit.ood.hw1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Григорий on 20.12.2016.
 */

public class CSVParser implements Parser<Trade> {
    private String fileName;
    public CSVParser() {fileName = "FileName"; }
    public CSVParser(String fileName) {this.fileName = fileName;}

    public Iterable<Trade> parse() {
        try {
            Reader in = new FileReader(fileName);
            Iterable<Trade> records = CSVToTrade(CSVFormat.EXCEL.parse(in));
            return records;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error while parsing CSV file");
        }
    }
    public Iterable<Trade> CSVToTrade(Iterable<CSVRecord> inp){
        List<Trade> trades = new ArrayList<Trade>();
        for(CSVRecord record : inp) {
            Trade curTrade = new Trade(record.toMap());
            trades.add(curTrade);
        }
        return trades;
    }
}