package bg.elkabel.calculator.controllers;

import bg.elkabel.calculator.models.bind.CableBindModel;
import bg.elkabel.calculator.service.CableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cable")
public class CableController {
	
	
	private final CableService cableService;

	@Autowired
	public CableController(CableService cableService) {
		this.cableService = cableService;
	}
	
	
	
	@GetMapping("")
	public String getCorePage(@ModelAttribute("cable") CableBindModel cable) {
		return "view/cable";
	}
	
	@PostMapping("")
	public String getCore(@ModelAttribute("cable") CableBindModel cable) {

		this.cableService.createCable(cable);

		return "redirect:/";
	}
	
}
