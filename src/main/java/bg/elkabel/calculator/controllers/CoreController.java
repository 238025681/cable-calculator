package bg.elkabel.calculator.controllers;

import bg.elkabel.calculator.models.bind.CoreBindModel;
import bg.elkabel.calculator.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Kalin
 */
@Controller
@RequestMapping("/core")
public class CoreController {

	private final CoreService coreService;

	@Autowired
	public CoreController(CoreService coreService) {
		this.coreService = coreService;
	}

	@GetMapping("")
	public String getCorePage(@ModelAttribute("coreModel") CoreBindModel coreModel) {
		return "view/core";
	}

	@PostMapping("")
	public String getCore(@ModelAttribute("coreModel") CoreBindModel coreModel) {

		this.coreService.create(coreModel);

		return "redirect:/";
	}

	
}
