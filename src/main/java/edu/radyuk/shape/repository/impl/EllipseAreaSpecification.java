package edu.radyuk.shape.repository.impl;

import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.exception.EllipseException;
import edu.radyuk.shape.repository.EllipseSpecification;
import edu.radyuk.shape.service.impl.EllipseServiceImpl;
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
        double area = 0;
        try {
            EllipseServiceImpl ellipseService = new EllipseServiceImpl();
            area = ellipseService.calculateArea(ellipse);
        } catch (EllipseException e) {
            logger.log(Level.ERROR, e);
        }
        return (Double.compare(area, areaFrom) == 1 && Double.compare(area, areaTo) == -1);
    }
}
