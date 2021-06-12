
		const queryString = window.location.search; //obtengo la url
		const urlParams = new URLSearchParams(queryString); //obtengo los parametros de la url

        if(urlParams.get("tipoPermiso") === "diario" ){ 
            document.querySelector("#periodo").style.display = "none";

            document.querySelector("#idPermiso").innerHTML =urlParams.get("idPermiso");
            document.querySelector("#nombre").innerHTML = urlParams.get("nombre");
            document.querySelector("#apellido").innerHTML = urlParams.get("apellido");
            document.querySelector("#fecha").innerHTML = urlParams.get("fecha");
            document.querySelector("#desdeHasta").innerHTML =urlParams.get("desdeHasta");

            document.querySelector("#desdeHasta").innerHTML =urlParams.get("desdeHasta");  
        }
        else{
            document.querySelector("#diario").style.display = "none";
   
            document.querySelector("#idPermiso").innerHTML =urlParams.get("idPermiso");
            document.querySelector("#nombre").innerHTML = urlParams.get("nombre");
            document.querySelector("#apellido").innerHTML = urlParams.get("apellido");
            document.querySelector("#fecha").innerHTML = urlParams.get("fecha");
            document.querySelector("#desdeHasta").innerHTML =urlParams.get("desdeHasta");

            document.querySelector("#cantDias").innerHTML =urlParams.get("cantDias");
            document.querySelector("#vacaciones").innerHTML =urlParams.get("vacaciones");
            document.querySelector("#rodado").innerHTML =urlParams.get("rodado");

        }



