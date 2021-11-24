package edu.radyuk.shape.warehouse;

import edu.radyuk.shape.exception.EllipseException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Logger logger = LogManager.getLogger();
    private static final Warehouse instance = new Warehouse();
    private final Map<Integer, EllipseParameters> parametersStorage = new HashMap<Integer, EllipseParameters>();

    private Warehouse() {

    }

    public static Warehouse getInstance() {
        return instance;
    }

    public void putParameters(int id, double area, double perimeter) {
        EllipseParameters ellipseParameters = new EllipseParameters(area, perimeter);
        parametersStorage.putIfAbsent(id, ellipseParameters);
        logger.log(Level.INFO, "Parameters added successfully");
    }

    public EllipseParameters receiveParameters(int id) throws EllipseException {
        EllipseParameters ellipseParameters = parametersStorage.get(id);
        if (ellipseParameters == null) {
            throw new EllipseException("There is no ellipse with such id");
        }
        return ellipseParameters;
    }

    public void updateParameters(int id, double area, double perimeter) throws EllipseException {
        EllipseParameters ellipseParameters = parametersStorage.get(id);
        if (ellipseParameters == null) {
            throw new EllipseException("There is no ellipse with such id");
        }
        ellipseParameters.setArea(area);
        ellipseParameters.setPerimeter(perimeter);
        logger.log(Level.INFO, "Parameters updated successfully");
    }
}
