package edu.radyuk.shape.warehouse;

import edu.radyuk.shape.exception.EllipseException;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Warehouse instance = new Warehouse();
    private Map<Integer, EllipseParameters> parametersStorage = new HashMap<Integer, EllipseParameters>();

    private Warehouse() {

    }

    public static Warehouse getInstance() {
        return instance;
    }

    public void putParameters(int id, double area, double perimeter) {
        EllipseParameters ellipseParameters = new EllipseParameters(area, perimeter);
        parametersStorage.putIfAbsent(id, ellipseParameters);
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
    }
}
