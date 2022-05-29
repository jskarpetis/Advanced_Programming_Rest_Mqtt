package gr.upatras.rest.mqtt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;

@RestController
public class MessageController {
	@Autowired
	private IMessageService messageService;

	private static final Logger log = LoggerFactory.getLogger(MessageController.class);

	@RequestMapping(value = "/send-message/", produces = { "application/json;charset=utf-8" }, consumes = {
			"application/json;charset=utf-8" }, method = RequestMethod.POST)
	public ResponseEntity<Message> createProduct(
			@ApiParam(value = "The Message to be transmitted", required = true) @RequestBody Message m) {
		log.info("Will add a new message");
		Message message = messageService.addMessage(m);
		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}

}
