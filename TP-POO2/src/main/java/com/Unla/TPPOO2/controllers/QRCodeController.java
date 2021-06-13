package com.Unla.TPPOO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.Unla.TPPOO2.helpers.ViewRouteHelper;
import com.Unla.TPPOO2.interfaceService.ILugarService;
import com.Unla.TPPOO2.interfaceService.IPermisoDiarioService;
import com.Unla.TPPOO2.interfaceService.IPermisoPeriodoService;
import com.Unla.TPPOO2.interfaceService.IPermisoService;
import com.Unla.TPPOO2.interfaceService.IPersonaService;
import com.Unla.TPPOO2.interfaceService.IRodadoService;
import com.Unla.TPPOO2.interfaceService.IUserLogueadoService;
import com.Unla.TPPOO2.models.Permiso;
import com.Unla.TPPOO2.services.QRCodeGenerator;

@RestController
public class QRCodeController {
	
	@Autowired
	private IPersonaService personaService;

	@Autowired
	private IRodadoService rodadoService;

	@Autowired
	private ILugarService lugarService;

	@Autowired
	private IPermisoService permisoService;
	
	@Autowired
	private IPermisoDiarioService permisoDiarioService;
	
	@Autowired
	private IPermisoPeriodoService permisoPeriodoService;
	
	@Autowired
	private IUserLogueadoService userLoguadoService;
	
	
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
   	
   	@GetMapping(value = "/generateQRCode/{idPermiso}")
   	public ModelAndView downloadQRCode(
   			@PathVariable("idPermiso") int idPermiso,Model model)
   			throws Exception {
   		
   	    ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISO_TABLA);
   	    
   		Permiso permiso = permisoService.listarId(idPermiso).get();
   	   	QRCodeGenerator.generarCodigoQR(permiso);
   	   	
		mAV.addObject("personas", personaService.listar());
		mAV.addObject("rodados", rodadoService.listar());
		mAV.addObject("permisos", permisoService.listar());
		mAV.addObject("permisosDiarios", permisoDiarioService.listarPermisosDiarios());
		mAV.addObject("permisosPeriodo", permisoPeriodoService.listarPermisosPeriodo());
		mAV.addObject("lugares", lugarService.listar());
		mAV.addObject("usuarioLogueado", userLoguadoService.traerUserLogueado() );
   	   	mAV.addObject("Msg", "QR creado con exito en el escritorio!");
   	   	return mAV;
   	}
   	
}