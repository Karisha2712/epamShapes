package edu.radyuk.shape.repository.impl;

import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.exception.EllipseException;
import edu.radyuk.shape.repository.EllipseSpecification;
import edu.radyuk.shape.warehouse.EllipseParameters;
import edu.radyuk.shape.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EllipseAreaSpecification implements EllipseSpecification {
    private static final Logger logger = LogManager.getLogger();
    private final double areaFrom;
    private final double areaTo;

    public EllipseAreaSpecification(double areaFrom, double areaTo) {
        this.areaFrom = areaFrom;
        this.areaTo = areaTo;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        Warehouse warehouse = Warehouse.getInstance();
        double area = 0;
        try {
            EllipseParameters ellipseParameters = warehouse.receiveParameters(ellipse.getEllipseId());
            area = ellipseParameters.getArea();
        } catch (EllipseException e) {
            logger.log(Level.ERROR, "There is no such ellipse in warehouse");
        }
        return (Double.compare(area, areaFrom) == 1 && Double.compare(area, areaTo) == -1);
    }
}
