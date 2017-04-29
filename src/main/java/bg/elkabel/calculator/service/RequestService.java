package bg.elkabel.calculator.service;

import bg.elkabel.calculator.models.bind.RequestBindModel;
import bg.elkabel.calculator.models.view.RequestViewModel;
import java.util.List;

public interface RequestService {

	void createRequest(RequestBindModel request);

	List<RequestViewModel> getAllRequest(); 
	RequestViewModel findById(Long id);
}
