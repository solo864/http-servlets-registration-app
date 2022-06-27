package util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JspHelper {

    private static final String FORMAT = "WEB-INF/jsp/%s.jsp";

    public static String get(String jspName) {
        return FORMAT.formatted(jspName);
    }

}
