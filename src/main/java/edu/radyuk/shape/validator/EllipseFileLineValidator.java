package edu.radyuk.shape.validator;

public class EllipseFileLineValidator {
    private static final String REGEXP_FOR_LINE_VALIDATION = "([-]?\\d+\\.\\d+\\s+){3}([-]?\\d+\\.\\d+)";

    private EllipseFileLineValidator() {

    }

    public static boolean isEllipseFileLineValid(String fileLine) {
        return fileLine.matches(REGEXP_FOR_LINE_VALIDATION);
    }
}
