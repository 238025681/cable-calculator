package bg.elkabel.calculator.service;

import bg.elkabel.calculator.models.bind.ConductorBindModel;
import bg.elkabel.calculator.models.view.ConductorViewModel;
import java.util.List;

public interface ConductorService {

	void create(ConductorBindModel conductor);

	List<ConductorViewModel> findAll();
}
