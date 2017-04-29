package bg.elkabel.calculator.controllers;

import bg.elkabel.calculator.models.bind.RequestBindModel;
import bg.elkabel.calculator.models.view.RequestViewModel;
import bg.elkabel.calculator.service.RequestService;
import bg.elkabel.calculator.utils.PDFCreator;
import bg.elkabel.calculator.utils.RequestProperties;
import bg.elkabel.calculator.utils.RequestPropertiesBuilder;
import com.google.gson.Gson;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/request")
public class RequestController {

	private final RequestService requestService;
	private final Gson gsonService;

	@Autowired
	public RequestController(RequestService requestService, Gson gsonService) {
		this.requestService = requestService;
		this.gsonService = gsonService;
	}

	@GetMapping("")
	public String getCorePage(@ModelAttribute("requestModel") RequestBindModel requestModel) {
		return "view/request";
	}

	@PostMapping("")
	public String getCore(@ModelAttribute("cable") RequestBindModel requestModel) {

		this.requestService.createRequest(requestModel);

		return "redirect:/";
	}

	@RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RequestViewModel> findOneById(@PathVariable("id") Long id) throws IOException {
 
		RequestViewModel result = this.requestService.findById(id);

		return ResponseEntity.accepted().body(result);
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/pdf")
	public ResponseEntity<InputStreamResource> downloadPDFFile()
			throws IOException {
		RequestViewModel result = this.requestService.findById(1l);
		PDDocument pdfDDocument = PDFCreator.createRequestDocument(RequestPropertiesBuilder.createRequestProperties(result));
		ClassPathResource pdfFile = new ClassPathResource("my_doc.pdf");
		

		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentLength(pdfFile.contentLength())
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.body(new InputStreamResource(pdfFile.getInputStream()));
	}

	@RequestMapping(value = "/testCase/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RequestProperties> getResult(@PathVariable("id") Long id) throws IOException {
		RequestViewModel result = this.requestService.findById(id);

		PDDocument pdfDDocument = PDFCreator.createRequestDocument(RequestPropertiesBuilder.createRequestProperties(result));

		return ResponseEntity.accepted().body(RequestPropertiesBuilder.createRequestProperties(result));

	}
}
