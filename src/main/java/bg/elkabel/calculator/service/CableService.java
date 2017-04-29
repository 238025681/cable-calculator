package bg.elkabel.calculator.service;

import bg.elkabel.calculator.models.bind.CableBindModel;
import bg.elkabel.calculator.models.view.CableViewModel;
import java.util.List;

/**
 *
 * @author Kalin
 */
public interface CableService {

    void createCable(CableBindModel cable);

    List<CableViewModel> allCables();
}
