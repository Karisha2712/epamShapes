package edu.radyuk.shape.observer.impl;

import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.exception.EllipseException;
import edu.radyuk.shape.observer.EllipseEvent;
import edu.radyuk.shape.observer.EllipseObserver;
import edu.radyuk.shape.service.impl.EllipseServiceImpl;
import edu.radyuk.shape.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EllipseObserverImpl implements EllipseObserver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void updateParameters(EllipseEvent event) {
        Ellipse ellipse = event.getSource();
        int ellipseId = ellipse.getEllipseId();
        Warehouse warehouse = Warehouse.getInstance();
        EllipseServiceImpl ellipseService = new EllipseServiceImpl();
        try {
            double ellipseArea = ellipseService.calculateArea(ellipse);
            double ellipsePerimeter = ellipseService.calculatePerimeter(ellipse);
            warehouse.updateParameters(ellipseId, ellipseArea, ellipsePerimeter);
        } catch (EllipseException e) {
            logger.log(Level.ERROR, "Error while changing warehouse ", e);
        }
    }
}
