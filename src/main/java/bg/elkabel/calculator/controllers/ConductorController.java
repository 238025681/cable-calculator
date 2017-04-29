package bg.elkabel.calculator.controllers;

import bg.elkabel.calculator.models.bind.ConductorBindModel;
import bg.elkabel.calculator.service.ConductorService;
import bg.elkabel.calculator.service.CoreService;
import com.google.gson.Gson;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/conductor")
public class ConductorController {

	private final Gson gsonService;
	private final ConductorService conductorService;
	private final CoreService coreService;

	@Autowired
	public ConductorController(Gson gsonService, ConductorService conductorService, CoreService coreService) {
		this.conductorService = conductorService;
		this.gsonService = gsonService;
		this.coreService = coreService;
	}

	@GetMapping("")
	public String getConductorPage(@ModelAttribute("cableModel") ConductorBindModel cableModel) {
		return "view/conductor";
	}

	@PostMapping("/create")
	public String createNewConductor(@ModelAttribute ConductorBindModel cableModel, BindingResult bindingResult) {

		this.conductorService.create(cableModel);

		return "redirect:/";
	}

	@GetMapping("/choose")
	@ResponseBody
	public String getAllCores() throws IOException {

		return 
				this.gsonService
				.toJson(this.coreService.findAllNames());
	}
	@GetMapping("/getAll")
	@ResponseBody
	public String getAllConductor() throws IOException {

		return 
				this.gsonService
				.toJson(this.conductorService.findAll());
	}

}
