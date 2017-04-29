/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.elkabel.calculator.service;

import bg.elkabel.calculator.entity.Core;
import bg.elkabel.calculator.entity.Material;
import bg.elkabel.calculator.models.bind.CoreBindModel;
import bg.elkabel.calculator.models.view.ChooseCoreView;
import bg.elkabel.calculator.models.view.TestCore;
import bg.elkabel.calculator.repository.CoreRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CoreServiceImpl implements CoreService {

	private final ModelMapper modelMapper;
	private final CoreRepository coreRepository;

	@Autowired
	public CoreServiceImpl(ModelMapper modelMapper, CoreRepository coreRepository) {
		this.modelMapper = modelMapper;
		this.coreRepository = coreRepository;
	}

	@Override
	public void create(CoreBindModel coreModel) {
		Core core = this.modelMapper.map(coreModel, Core.class);
		Material material = Material.valueOf(Material.class, coreModel.getMaterial());
		core.setMaterial(material);
		this.coreRepository.saveAndFlush(core);
	}

	@Override
	public List<ChooseCoreView> findAll() {

		List<Core> core = this.coreRepository.findAll();
		List<ChooseCoreView> result = new ArrayList();
		core.forEach(c -> {
			ChooseCoreView currentCore = this.modelMapper.map(c, ChooseCoreView.class);
			result.add(currentCore);
		});

		return result.size() > 0 ? result : null;
	}

	@Override
	public void createAllCores(List<Core> cores) {
		cores.forEach(c -> {
			double weight = calculateWeight(c.getMaterial(), c.getCoreSize());
			c.setWeight(weight);

			this.coreRepository.saveAndFlush(c);
		});
	}

	private double calculateWeight(Material material, double coreSize) {
		double result = 0.0;
		switch (material.ordinal()) {
			case 0:
				result = Math.pow(coreSize, 2) * Math.PI / 4 * 2.7 * 1 / 1000;
				break;
			case 1:
				result = Math.pow(coreSize, 2) * Math.PI / 4 * 8.9 * 1 / 1000;
				break;
		}

		return BigDecimal.valueOf(result).setScale(6, RoundingMode.HALF_UP).doubleValue();
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<String> findAllNames() {
		return this.coreRepository.getAllNames().collect(Collectors.toList());
	}

}
