const expresiones = {
	dominio: /^[a-zA-Z]{3}\d{3}$/ ,//Patente => 3 letras y 3 numeros .
	vehiculo: /^[a-zA-Z\s]{1,20}$/, // Solor letras con un maximo de 20 caracteres
};

const campos = {
	dominio: false,
    vehiculo: false,
};

const formulario = document.getElementById("form");
const inputs = document.querySelectorAll("#form input");

const validarFormulario = (evento)=>{

    switch(evento.target.name){
        case "dominio":
            validarCampo(expresiones.dominio , evento.target , "dominio");
            break;
        case "vehiculo":
            validarCampo(expresiones.vehiculo , evento.target , "vehiculo");
            break;             
    }
}

const validarCampo=(expresion, input, campo) =>{
    if(expresion.test(input.value)){
        document.getElementById(`grupo__${campo}`).classList.remove("form__grupo-incorrecto");
        document.getElementById(`grupo__${campo}`).classList.add("form__grupo-correcto");
        document.querySelector(`#grupo__${campo} i`).classList.remove("fa-times-circle");
        document.querySelector(`#grupo__${campo} i`).classList.add("fa-check-circle");

        document.querySelector(`#grupo__${campo} .form__error-input-msg`).classList.remove("form__error-input-msg-activo");
        campos[campo] = true;
    }
    else{
        document.getElementById(`grupo__${campo}`).classList.remove("form__grupo-correcto");
        document.getElementById(`grupo__${campo}`).classList.add("form__grupo-incorrecto");
        document.querySelector(`#grupo__${campo} i`).classList.remove("fa-check-circle");
        document.querySelector(`#grupo__${campo} i`).classList.add("fa-times-circle");

        document.querySelector(`#grupo__${campo} .form__error-input-msg`).classList.add("form__error-input-msg-activo");
        campos[campo] = false;
    }
}


inputs.forEach( (input) =>{
    input.addEventListener("keyup",validarFormulario);
    input.addEventListener("blur",validarFormulario);
});



formulario.addEventListener("submit", (e) =>{
 
    if(!campos.dominio || !campos.vehiculo){
	
	    e.preventDefault();
        
        document.getElementById("form__msg-error").classList.add("form__msg-erro-activo");
        setTimeout( ()=>{
            document.getElementById("form__msg-error").classList.remove("form__msg-erro-activo");
        } , 5000); //serian 5000 milisegundos es decir 5 segundos para que desaparezca el msg de exito
    }
   
});