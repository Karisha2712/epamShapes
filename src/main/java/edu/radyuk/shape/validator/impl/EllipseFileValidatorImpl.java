package edu.radyuk.shape.validator.impl;

import edu.radyuk.shape.validator.EllipseFileValidator;

import java.io.File;

public class EllipseFileValidatorImpl implements EllipseFileValidator {
    private static final String REGEXP_FOR_LINE_VALIDATION = "([-]?\\d+\\.\\d+\\s+){3}([-]?\\d+\\.\\d+)";

    public EllipseFileValidatorImpl() {

    }

    public boolean isFileValid(String filepath) {
        if (filepath == null) {
            return false;
        }
        File file = new File(filepath);
        return file.exists() && (file.length() != 0);
    }

    public boolean isEllipseFileLineValid(String fileLine) {
        return fileLine.matches(REGEXP_FOR_LINE_VALIDATION);
    }
}
