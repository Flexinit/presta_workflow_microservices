package com.prestacapital.WorkflowAutomator.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;

public  class Utils {

    public  static final String URL = "http://localhost:8090/api/v1/approvals";

    public static Function<Void, Date> getCurrentDateTime = date -> {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    };

}
