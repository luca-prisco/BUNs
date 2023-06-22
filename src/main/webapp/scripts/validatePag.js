const nameOrLastnamePattern = /^[A-Z a-z]+$/;
const emailPattern = /^\S+@\S+\.\S+$/;
const phonePattern = /^([0-9]{3}-[0-9]{7})$/;
const intestatarioPattern = /^[A-Za-z]+$/;
const numeroCartaPattern = /^(?:5[1-5][0-9]{2}) [0-9]{4} [0-9]{4} [0-9]{4}$/;
const dataScadenzaPattern = /^(0[1-9]|1[0-2])\/?([0-9]{2})$/;
const CVVPattern = /^([0-9]{3})$/;
let count = 1;
const nameOrLastnameErrorMessage = "This field should contain only letters";
const emailErrorMessage = "The email field should be in the form username@domain.ext";
const emptyFieldErrorMessage = "This field cannot be empty"
const intestatarioErrorMessage = "Questo campo non puo' contenere numeri";
const numCartaErrorMessage = "Questo campo contiene solo numeri";
const dataScadenzaErrorMessage = "Una data di scadenza valida dovrebbe essere nella forma mm/yy";
const CVVErrorMessage = "Un CVV valido dovrebbe contenere solo numeri";

function validateFormElem(formElem, span, errorMessage) {
	if(formElem.checkValidity()){
		formElem.classList.remove("error");
		span.style.color = "black";
		span.innerHTML = "";
		return true;
	}
	formElem.classList.add("error");
	span.style.color = "red";
	if (formElem.validity.valueMissing){
		span.innerHTML = emptyFieldErrorMessage;
	} else {
		span.innerHTML = errorMessage;
	}
	return false;
}


function validate() {
	let valid = true;	
	let form = document.getElementById("pagamentoForm");
	
	let spanName = document.getElementById("errorName");
	if(!validateFormElem(form.firstname, spanName, nameOrLastnameErrorMessage)){
		valid = false;
	} 
	let spanLastname = document.getElementById("errorLastname");
	if (!validateFormElem(form.lastname, spanLastname, nameOrLastnameErrorMessage)){
		valid = false;
	}
	let spanEmail = document.getElementById("errorEmail");
	if (!validateFormElem(form.email, spanEmail, emailErrorMessage)){
		valid = false;
	}
	
	let spanIntestatario = document.getElementById("errorIntestatario");
	if (!validateFormElem(form.intestatario, intestatarioPattern, spanIntestatario, intestatarioErrorMessage)){
		valid = false;
	}

	let spanNumeroCarta = document.getElementById("errorNumeroCarta");
	if (!validateFormElem(form.numeroCarta, numeroCartaPattern, spanNumeroCarta, numCartaErrorMessage)){
		valid = false;
	}

	let spanDataScadenza = document.getElementById("errorDataScadenza");
	if (!validateFormElem(form.dataScadenza, dataScadenzaPattern, spanDataScadenza, dataScadenzaErrorMessage)){
		valid = false;
	}

	let spanCVV = document.getElementById("errorCVV");
	if (!validateFormElem(form.CVV, CVVPattern, spanCVV, CVVErrorMessage)){
		valid = false;
	}
	return valid;
}