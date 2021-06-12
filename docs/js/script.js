
		const queryString = window.location.search; //obtengo la url
		const urlParams = new URLSearchParams(queryString); //obtengo los parametros de la url

        if(urlParams.get("tipoPermiso") === "diario" ){ 
            document.querySelector("#periodo").style.display = "none";

            document.querySelector("#idPermisoDiario").innerHTML =urlParams.get("idPermiso");
            document.querySelector("#nombreDiario").innerHTML = urlParams.get("nombre");
            document.querySelector("#apellidoDiario").innerHTML = urlParams.get("apellido");
            document.querySelector("#fechaDiario").innerHTML = urlParams.get("fecha");
            document.querySelector("#desdeHastaDiario").innerHTML =urlParams.get("desdeHasta");

            document.querySelector("#motivoDiario").innerHTML =urlParams.get("motivo");  
        }
        else{
            document.querySelector("#diario").style.display = "none";
   
            document.querySelector("#idPermisoPeriodo").innerHTML =urlParams.get("idPermiso");
            document.querySelector("#nombrePeriodo").innerHTML = urlParams.get("nombre");
            document.querySelector("#apellidoPeriodo").innerHTML = urlParams.get("apellido");
            document.querySelector("#fechaPeriodo").innerHTML = urlParams.get("fecha");
            document.querySelector("#desdeHastaPeriodo").innerHTML =urlParams.get("desdeHasta");

            document.querySelector("#cantDiasPeriodo").innerHTML =urlParams.get("cantDias");
            document.querySelector("#vacacionesPeriodo").innerHTML =urlParams.get("vacaciones");
            document.querySelector("#rodadoPeriodo").innerHTML =urlParams.get("rodado");

        }
