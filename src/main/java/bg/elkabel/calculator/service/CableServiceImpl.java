package bg.elkabel.calculator.service;

import bg.elkabel.calculator.entity.Cable;
import bg.elkabel.calculator.entity.Conductor;
import bg.elkabel.calculator.models.bind.CableBindModel;
import bg.elkabel.calculator.repository.CableRepository;
import bg.elkabel.calculator.repository.ConductorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CableServiceImpl implements CableService {

	private final ModelMapper modelMapper;
	private final CableRepository cableRepository;
	private final ConductorRepository conductorRepository;

	@Autowired
	public CableServiceImpl(ModelMapper modelMapper, CableRepository cableRepository, ConductorRepository conductorRepository) {
		this.modelMapper = modelMapper;
		this.cableRepository = cableRepository;
		this.conductorRepository = conductorRepository;
	}

	@Override
	public void createCable(CableBindModel cable) {

		Cable currentCable = this.modelMapper.map(cable, Cable.class);
		Conductor conductor = this.conductorRepository.findOneByName(cable.getConductorName());
		currentCable.setConductor(conductor);
		
		this.cableRepository.saveAndFlush(currentCable);
	}

}
