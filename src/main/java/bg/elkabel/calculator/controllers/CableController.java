package bg.elkabel.calculator.controllers;

import bg.elkabel.calculator.models.bind.CableBindModel;
import bg.elkabel.calculator.models.view.CableViewModel;
import bg.elkabel.calculator.service.CableService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
	
        
        @RequestMapping(value = "/getCables", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CableViewModel>> getResult() throws IOException {
		
            List<CableViewModel> cables = this.cableService.allCables();
		return ResponseEntity.ok().body(cables);

	}
}
