package UI.manualUI;

import org.junit.Test;

import static org.junit.Assert.*;

public class manualScreenControllerTest {

    @Test
    public void initialize()
    {
        manualScreenController manualScreenController = new manualScreenController();

        manualScreenController.initialize();

        assertNotNull(manualScreenController.anchorPane);

        assertNotNull(manualScreenController.upButton);

        assertNotNull(manualScreenController.backButton);

        assertNotNull(manualScreenController.turnSlider);


    }

    @Test
    public void resetSlider()
    {
        manualScreenController manualScreenController = new manualScreenController();

        manualScreenController.initialize();

        manualScreenController.resetSlider();

        assert(manualScreenController.turnSlider.getValue() == 0.0);
    }


}