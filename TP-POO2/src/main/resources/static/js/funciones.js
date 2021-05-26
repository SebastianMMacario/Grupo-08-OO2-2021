function eliminar(id) {
	swal({
		  title: "Está seguro de que desea eliminar este usuario?",
		  text: "Una vez eliminado, no será posible recuperarlo!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
	})
	.then((OK) => {
		if (OK) {
			$.ajax({
				url:"/delete/"+id,
				success: function(res) {
					console.log(res);
				}
			  });
			swal("El usuario ha sido eliminado con exito!", {
				icon: "success",
			}).then((ok) => {
				if(ok) {
					location.href="/list";
				}
			});
		  } else {
			swal("El usuario no ha sido eliminado");
		}
	  });
}
	  
	/**GENERAR REPORTE DE USUARIOS EN PDF ***/
	const crearPDF = () => {
		$.ajax({
			url: "/generarPDF",
			success: function(res) {
				console.log(res);
			}
		});
		swal("Reporte generado con exito!!!", {
			icon: "success"
		});
	}

document.querySelector("#button-pdf").addEventListener("click", crearPDF);

