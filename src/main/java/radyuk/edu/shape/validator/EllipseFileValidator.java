package radyuk.edu.shape.validator;

import java.io.File;

public class EllipseFileValidator {
    private EllipseFileValidator() {

    }

    public static boolean isFileValid(String filepath) {
        if (filepath == null) {
            return false;
        }
        File file = new File(filepath);
        return file.exists() && (file.length() != 0);
    }
}
