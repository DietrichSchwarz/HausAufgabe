package org.dima12.PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class PBook {
    static List<Record> records = new ArrayList<>();

    public void add ( Record record){
        records.add(record);
    }

    public Record find(String name){
        for (Record record:records){
            if (record.getName().equals(name)){
                return record;
            }
        }
        return null;
    }
    public List<Record> findAll (String name) {
        List<Record> records1 = new ArrayList<>();
        for (Record record : records) {
            if (record.getName().equals(name)) {
                records1.add(record);
            }

        }
        if (records1.isEmpty()) {
            return null;
        } else {
            return records1;

        }
    }
    public static List<Record> getRecords() {
        return records;
    }
}
