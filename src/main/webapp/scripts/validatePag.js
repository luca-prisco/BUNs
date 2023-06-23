let count = 1;
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
	
	let spanIntestatario = document.getElementById("errorIntestatario");
	if (!validateFormElem(form.intestatario, spanIntestatario, intestatarioErrorMessage)){
		valid = false;
	}

	let spanNumeroCarta = document.getElementById("errorNumeroCarta");
	if (!validateFormElem(form.numeroCarta, spanNumeroCarta, numCartaErrorMessage)){
		valid = false;
	}

	let spanDataScadenza = document.getElementById("errorDataScadenza");
	if (!validateFormElem(form.dataScadenza, spanDataScadenza, dataScadenzaErrorMessage)){
		valid = false;
	}

	let spanCVV = document.getElementById("errorCVV");
	if (!validateFormElem(form.CVV, spanCVV, CVVErrorMessage)){
		valid = false;
	}
	return valid;
}