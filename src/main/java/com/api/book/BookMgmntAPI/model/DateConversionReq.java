package com.api.book.BookMgmntAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateConversionReq {
    private Date time;
    private String fromTimeZone;
    private String toTimeZone;
}
