package bg.elkabel.calculator.controllers;

import bg.elkabel.calculator.service.RequestService;
import com.google.gson.Gson;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

	private final RequestService requestService;
	private final Gson gsonService;

	@Autowired
	public HomeController(RequestService requestService, Gson gsonService) {
		this.requestService = requestService;
		this.gsonService = gsonService;
	}

	@GetMapping("")
	public String getHomePage() {
		return "view/home";
	}

	@GetMapping("/allRequest")
	@ResponseBody
	public String getAllCores() throws IOException {

		return this.gsonService
				.toJson(this.requestService.getAllRequest());
	}
	
	
}
