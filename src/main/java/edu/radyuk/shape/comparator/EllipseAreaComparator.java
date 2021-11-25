package edu.radyuk.shape.comparator;

import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.exception.EllipseException;
import edu.radyuk.shape.service.impl.EllipseServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class EllipseAreaComparator implements Comparator<Ellipse> {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        double area1 = 0;
        double area2 = 0;
        try {
            EllipseServiceImpl ellipseService = new EllipseServiceImpl();
            area1 = ellipseService.calculateArea(o1);
            area2 = ellipseService.calculateArea(o2);
        } catch (EllipseException e) {
            logger.log(Level.ERROR, e);
        }
        return Double.compare(area1, area2);
    }
}
