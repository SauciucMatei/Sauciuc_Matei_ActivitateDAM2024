package com.example.seminar4;

import androidx.room.TypeConverter;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class TypeConverters {
    @TypeConverter
    public Long DateToLong(Date data) {
        long millisec=data.getTime();
        return millisec;
    }

    @TypeConverter
    public Date LongToDate(long data){
        Date date = new Date(data);
        return date;
    }
}
