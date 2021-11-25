package edu.radyuk.shape.filler;

import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.exception.EllipseException;
import edu.radyuk.shape.service.impl.EllipseServiceImpl;
import edu.radyuk.shape.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class WarehouseFiller {
    private static final Logger logger = LogManager.getLogger();
    private final Warehouse warehouse = Warehouse.getInstance();

    public WarehouseFiller() {

    }

    public void fillWarehouse(List<Ellipse> ellipses) {
        EllipseServiceImpl ellipseService = new EllipseServiceImpl();
        for (Ellipse ellipse : ellipses) {
            int ellipseId = ellipse.getEllipseId();
            if (warehouse.containsEllipse(ellipseId)) {
                continue;
            }
            try {
                double perimeter = ellipseService.calculatePerimeter(ellipse);
                double area = ellipseService.calculateArea(ellipse);
                warehouse.putParameters(ellipseId, area, perimeter);
            } catch (EllipseException e) {
                logger.log(Level.ERROR, "Error while filling warehouse ", e);
            }
        }
    }
}
