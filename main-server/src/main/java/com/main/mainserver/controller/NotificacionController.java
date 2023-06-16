/*package com.main.mainserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.mainserver.models.Notificacion;

@RestController
@RequestMapping("/api/notification")
public class NotificacionController {

	@PostMapping
	public ResponseEntity<String> responderBot(@RequestBody Notificacion obj) {
	if (obj.getTopic().equals(("messages")) && obj.getUser_id() == 183426174) {
		if (!inter.existePorResource(obj.getResource())) {
			inter.crear(obj);
			chatBotService.respuestaAutomatica(obj.getResource());
		}
	} else if (obj.getTopic().equals(("shipments")) && obj.getUser_id() == 183426174) {
		if (!inter.existePorResource(obj.getResource())) {
			inter.crear(obj);
			//orderMsjService.Respuesta(obj.getResource());
		}
	} else {
		inter.crear(obj);
	}
	return new ResponseEntity<>("Ok", HttpStatus.OK);
	
}
*/