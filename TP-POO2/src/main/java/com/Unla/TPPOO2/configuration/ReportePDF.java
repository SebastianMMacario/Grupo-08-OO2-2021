package com.Unla.TPPOO2.configuration;

import java.io.FileOutputStream;

import com.Unla.TPPOO2.models.Usuario;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.pdf.PdfPTable;
 
public class ReportePDF {
	

	public static void generarReportePDF(java.util.List<Usuario> usuarios) {
		Document document = new Document();
		
		try {
			String ruta = System.getProperty(("user.home"));
			PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/Reporte_Usuarios.pdf"));
			
			document.open();
			PdfPTable tabla = new PdfPTable(7);
			tabla.addCell("Id");
			tabla.addCell("Apellido");
			tabla.addCell("Nombre");
			tabla.addCell("Tipo de Documento");
			tabla.addCell("Numero de Documento");
			tabla.addCell("Email");
			tabla.addCell("Nombre de usuario");

		
			if(!usuarios.isEmpty()) {
				for (Usuario usuario : usuarios) {
					
					tabla.addCell(String.valueOf( usuario.getIdUsuario() ));
					tabla.addCell(String.valueOf( usuario.getApellido() ));
					tabla.addCell(String.valueOf( usuario.getNombre() ));
					tabla.addCell(String.valueOf( usuario.getTipoDocumento() ));
					tabla.addCell(String.valueOf( usuario.getNroDocumento() ));
					tabla.addCell(String.valueOf( usuario.getEmail() ));
					tabla.addCell(String.valueOf( usuario.getNombreUsuario() ));
				}
				document.add(tabla);			
			}
			else {
				throw new Exception("La BD no tiene usuarios cargados");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			document.close();
		}
	
	}
	
}

