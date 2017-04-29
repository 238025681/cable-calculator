package bg.elkabel.calculator.service;

import bg.elkabel.calculator.entity.Cable;
import bg.elkabel.calculator.entity.Request;
import bg.elkabel.calculator.models.bind.RequestBindModel;
import bg.elkabel.calculator.models.view.RequestViewModel;
import bg.elkabel.calculator.repository.CableRepository;
import bg.elkabel.calculator.repository.RequestRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

	private final ModelMapper modelMapper;
	private final RequestRepository requestRepository;
	private final CableRepository cableRepository;

	@Autowired
	public RequestServiceImpl(ModelMapper modelMapper, RequestRepository requestRepository, CableRepository cableRepository) {
		this.modelMapper = modelMapper;
		this.requestRepository = requestRepository;
		this.cableRepository = cableRepository;
	}

	@Override
	public void createRequest(RequestBindModel request) {

		Request currentRequest = this.modelMapper.map(request, Request.class);
		Cable cable = this.cableRepository.findOneByName(request.getCableName());

		currentRequest.setCable(cable);
		currentRequest.setDate(new Date());

		this.requestRepository.saveAndFlush(currentRequest);
	}

	@Override
	public List<RequestViewModel> getAllRequest() {
		List<Request> requests = this.requestRepository.findAll();
		List<RequestViewModel> result = new ArrayList<>();
		requests.forEach(r -> {

			RequestViewModel currentRequest = this.modelMapper.map(r, RequestViewModel.class);
			result.add(currentRequest);
		});

		return result.size() > 0 ? result : null;
	}

	@Override
	public RequestViewModel findById(Long id) {
		Request request = this.requestRepository.findOne(id);

		return this.modelMapper.map(request, RequestViewModel.class);
	}

}
