package edu.radyuk.shape.filler;

import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.repository.EllipseRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RepositoryFiller {
    private static final Logger logger = LogManager.getLogger();
    private final EllipseRepository ellipseRepository = EllipseRepository.getInstance();

    public RepositoryFiller() {

    }

    public void fillRepository(List<Ellipse> ellipses) {
        for (Ellipse ellipse : ellipses) {
            ellipseRepository.add(ellipse);
        }
        logger.log(Level.INFO, "Repository filled successfully");
    }
}
