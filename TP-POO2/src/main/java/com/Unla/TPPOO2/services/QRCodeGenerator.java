package com.Unla.TPPOO2.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

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

		
		public static void generarCodigoQR(/*String browserPath ,*/ int idPermiso) throws Exception {
			String QRdata = "localhost:9090/listPermisoPorQR?idPermiso=" + idPermiso /*+ String.valueOf(idPermiso)*/;
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