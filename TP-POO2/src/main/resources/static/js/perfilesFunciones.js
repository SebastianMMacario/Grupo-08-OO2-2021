function eliminarPerfil(id) {
	swal({
		  title: "Está seguro de que desea eliminar este perfil?",
		  text: "Una vez eliminado, no será posible recuperarlo!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
	})
	.then((OK) => {
		if (OK) {
			$.ajax({
				url:"/deletePerfil/"+id,
				success: function(res) {
					console.log(res);
				}
			  });
			swal("El perfil ha sido eliminado con exito!", {
				icon: "success",
			}).then((ok) => {
				if(ok) {
					location.href="/listaPerfiles";
				}
			});
		  } else {
			swal("El perfil no ha sido eliminado");
		}
	  });
}
	

	/**GENERAR REPORTE DE PERFILES EN PDF ***/
	const crearPerfilPDF = () => {
		$.ajax({
			url: "/generarPerfilesPDF"
		});
		swal("Reporte de perfiles generado con exito!!!", {
			icon: "success"
		});
	}
	
	document.querySelector("#botonPerfil").addEventListener("click",crearPerfilPDF);