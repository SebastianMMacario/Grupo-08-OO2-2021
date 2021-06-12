package com.Unla.TPPOO2.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Iterator;

import com.Unla.TPPOO2.models.Lugar;
import com.Unla.TPPOO2.models.Permiso;
import com.Unla.TPPOO2.models.PermisoDiario;
import com.Unla.TPPOO2.models.PermisoPeriodo;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import net.bytebuddy.asm.Advice.Local;

public class QRCodeGenerator {

		public static void generateQRCodeImage(String text, int width, int height, String filePath)
	            throws WriterException, IOException {
	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

	        Path path = FileSystems.getDefault().getPath(filePath);
	        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	       
	    }
		
		
		public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
		    QRCodeWriter qrCodeWriter = new QRCodeWriter();
		    BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
		    
		    ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
		    byte[] pngData = pngOutputStream.toByteArray(); 
		    return pngData;
		}

		
		public static void generarCodigoQR(/*String browserPath ,*/Permiso permiso) throws Exception {
			String QRdata= "https://sebastianmmacario.github.io/Grupo-08-OO2-2021";
			
			String desdeHasta="&desdeHasta=[";
			Iterator<Lugar> iterator = permiso.getDesdeHasta().iterator();
			while(iterator.hasNext()) {
				Lugar l = iterator.next();
				if(iterator.hasNext()) {
					desdeHasta+=l.getLugar().replace(" ", "-") + ",";
				}else desdeHasta+=l.getLugar().replace(" ", "-") + "]";
			}
			
			if(permiso instanceof PermisoDiario) {
				PermisoDiario pd = (PermisoDiario)permiso;
				QRdata += "?tipoPermiso=diario&idPermiso="+pd.getIdPermiso()+"&apellido="+pd.getPersona().getApellido().replace(" ","-")+
						"&nombre="+pd.getPersona().getNombre().replace(" ", "-")+"&fecha="+pd.getFecha().toString()
						+ desdeHasta+"&motivo="+pd.getMotivo().replace(" ", "-");
			}
			else {
				PermisoPeriodo pp =(PermisoPeriodo)permiso;
				QRdata += "?tipoPermiso=periodo&idPermiso="+pp.getIdPermiso()+"&apellido="+pp.getPersona().getApellido().replace(" ","-")
						+"&nombre="+pp.getPersona().getNombre().replace(" ","-")+"&fecha="+pp.getFecha().toString()
						+desdeHasta+"&cantDias="+pp.getCantDias()+"&vacaciones="+pp.isVacacion()
							+"&rodado="+pp.getRodado().getVehiculo().replace(" ","-");
			}
			String PC_username = System.getProperty("user.name");
			System.out.println(PC_username);
			
			String downloadPath = "C:\\Users\\"+PC_username+"\\Desktop\\QRCode.jpg";
			System.out.println(QRdata);
			
//			 if (QRdata.contains("http://")) {
//			        QRdata = QRdata.replace("http://", "");
//			 }
			
			BitMatrix matrix = new MultiFormatWriter()
					.encode(QRdata, BarcodeFormat.QR_CODE, 500, 500);
			
			MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(downloadPath));
		}
}