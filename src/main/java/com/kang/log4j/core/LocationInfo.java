package com.kang.log4j.core;

import org.springframework.util.StringUtils;

/**
 * @Author：zeqi
 * @Date: Created in 13:32 22/2/18.
 * @Description:
 */
public class LocationInfo {

    private final static String NA = "?";
    private Throwable t;

    private String categoryName;

    private String className;

    private String lineNumber;

    private String methodName;

    private String fileName;

    public LocationInfo(Throwable t, String categoryName) {
        this.t = t;
        this.categoryName = categoryName;
    }

    public String getLocationInfo() {
        if (t == null || StringUtils.isEmpty(this.categoryName)) {
            return null;
        }
        StackTraceElement[] traceElements = new Throwable().getStackTrace();

        StringBuffer sb = new StringBuffer();
        String preClass = NA;
        for (int i = traceElements.length - 1; i >= 0; i--) {
            String thisClass = traceElements[i].getClassName();

            if (categoryName.equals(thisClass)) {
                //实际调用者为category的前一个
                int caller = i + 1;

                className = preClass;
                methodName = traceElements[caller].getMethodName();
                int line = traceElements[caller].getLineNumber();
                if (line < 0) {
                    lineNumber = NA;
                }
                lineNumber = String.valueOf(line);

                fileName = traceElements[caller].getFileName();

                if (fileName == null) {
                    fileName = NA;
                }

                sb.append("");
                sb.append(className);
                sb.append(".");

                sb.append(methodName);
                sb.append("(");
                sb.append(fileName);
                sb.append(":");
                sb.append(lineNumber);
                sb.append(")");


                break;
            }
            preClass = thisClass;

        }
        return sb.toString();
    }


    public String getClassName() {
        return className;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getFileName() {
        return fileName;
    }
}
