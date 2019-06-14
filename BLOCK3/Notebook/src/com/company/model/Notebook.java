package com.company.model;

import java.util.ArrayList;
import java.util.Collection;

public class Notebook {

    private ArrayList<Record> records;

    public Notebook() {
        records = new ArrayList<>();
    }

    public Collection<Record> getRecords() {
        return records;
    }


    public  final void addRecord (Record record) throws NotUniqueNickname{
        for(Record rec : records){
            if(rec.getNickName().equals(record.getNickName())){
                throw new NotUniqueNickname(record.getNickName());
            }
        }
        this.records.add(record);
    }
}
