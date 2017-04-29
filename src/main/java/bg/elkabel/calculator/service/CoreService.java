/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.elkabel.calculator.service;

import bg.elkabel.calculator.entity.Core;
import bg.elkabel.calculator.models.bind.CoreBindModel;
import bg.elkabel.calculator.models.view.ChooseCoreView;
import bg.elkabel.calculator.models.view.TestCore;
import java.util.List;

/**
 *
 * @author Kalin
 */
public interface CoreService {

	void create(CoreBindModel coreModel);

	List<ChooseCoreView> findAll();

	List<String> findAllNames();

	void createAllCores(List<Core> cores);

}
