/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.elkabel.calculator.service;

import bg.elkabel.calculator.entity.Conductor;
import bg.elkabel.calculator.entity.Core;
import bg.elkabel.calculator.entity.Material;
import bg.elkabel.calculator.models.bind.ConductorBindModel;
import bg.elkabel.calculator.models.view.ConductorViewModel;
import bg.elkabel.calculator.repository.ConductorRepository;
import bg.elkabel.calculator.repository.CoreRepository;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConductorServiceImpl implements ConductorService {

	private final ModelMapper modelMapper;
	private final ConductorRepository conductorRepository;
	private final CoreRepository coreRepository;

	@Autowired
	public ConductorServiceImpl(ModelMapper modelMapper, ConductorRepository conductorRepository, CoreRepository coreRepository) {
		this.modelMapper = modelMapper;
		this.conductorRepository = conductorRepository;
		this.coreRepository = coreRepository;
	}

	@Override
	public void create(ConductorBindModel conductor) {
		Conductor currentConductor = this.modelMapper.map(conductor, Conductor.class);

		Material material = Material.valueOf(Material.class, conductor.getMaterial());
		Core core = this.coreRepository.findOneByName(conductor.getCore());

		currentConductor.setCore(core);
		currentConductor.setMaterial(material);
		this.conductorRepository.saveAndFlush(currentConductor);
	}

	@Override
	public List<ConductorViewModel> findAll() {
		List<Conductor> allConductors = this.conductorRepository.findAll();
		List<ConductorViewModel> result = new ArrayList<>();

		allConductors.forEach(c -> {
			ConductorViewModel currentConductor = this.modelMapper.map(c, ConductorViewModel.class);
			result.add(currentConductor);
		});
		return result.size() > 0 ? result : null;
	}

}
