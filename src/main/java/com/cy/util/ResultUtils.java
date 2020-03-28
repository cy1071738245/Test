package com.cy.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResultUtils {

    public static void ajaxPrintWriter(String msg, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
            out.print(msg);
            //关闭流
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
