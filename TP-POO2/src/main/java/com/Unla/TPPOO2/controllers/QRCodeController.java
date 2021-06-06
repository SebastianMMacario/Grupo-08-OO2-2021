package com.Unla.TPPOO2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Unla.TPPOO2.helpers.ViewRouteHelper;
import com.Unla.TPPOO2.services.QRCodeGenerator;

@RestController
public class QRCodeController {
	
	//private static String ruta = System.getProperty(("user.home"));
	private static final String QR_CODE_IMAGE_PATH =  "./src/main/resources/QRCode.png";

	
    @GetMapping(value = "/generateAndDownloadQRCode/{codeText}/{width}/{height}")
		public void download(
				@PathVariable("codeText") String codeText,
				@PathVariable("width") Integer width,
				@PathVariable("height") Integer height)
			    throws Exception {
			        QRCodeGenerator.generateQRCodeImage(codeText, width, height, QR_CODE_IMAGE_PATH);
			    }

    @GetMapping(value = "/generateQRCode/{codeText}/{width}/{height}")
   	public ResponseEntity<byte[]> generateQRCode(
   			@PathVariable("codeText") String codeText,
   			@PathVariable("width") Integer width,
   			@PathVariable("height") Integer height)
   		    throws Exception {
   		        return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage(codeText, width, height));
   		    }
   	
   	@GetMapping(value = "/generateQRCode/" + "{idPermiso}")
   	public String downloadQRCode(
   			//@PathVariable("browserPath") String browserPath)
   			@PathVariable("idPermiso") int idPermiso) 
   			throws Exception {
   		QRCodeGenerator.generarCodigoQR(/*browserPath,*/ idPermiso);
   		return "QR generado con exito";
   		
   		
   	}
}