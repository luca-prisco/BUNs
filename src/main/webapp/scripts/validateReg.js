let count = 1;
const nomeErrorMessage = "Questo campo dovrebbe contenere solo lettere";
const cognomeErrorMessage = "Questo campo dovrebbe contenere solo lettere";
const emailErrorMessage = "Il campo email dovrebbe essere nella forma username@domain.ext";
const emptyFieldErrorMessage = "Questo campo non puo' essere vuoto";
const passwordErrorMessage = "La password deve essere minimo 8 caratteri";
const viaErrorMessage = "Questo campo dovrebbe essere nella forma Via Capodivilla 75";
const cittaErrorMessage = "Questo campo dovrebbe contenere solo lettere";
const capErrorMessage = "Un CAP valido dovrebbe contenere solo 5 numeri";
const provinciaErrorMessage = "Questo campo dovrebbe contenere solo lettere maiuscole";

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
	let form = document.getElementById("registrazioneForm");
	
	let spanNome = document.getElementById("errorNome");
	if(!validateFormElem(form.nome, spanNome, nomeErrorMessage)){
		valid = false;
	} 
	let spanCognome = document.getElementById("errorCognome");
	if (!validateFormElem(form.cognome, spanCognome, cognomeErrorMessage)){
		valid = false;
	}
	let spanEmail = document.getElementById("errorEmail");
	if (!validateFormElem(form.email, spanEmail, emailErrorMessage)){
		valid = false;
	}
	
	let spanPassword = document.getElementById("errorPassword");
	if (!validateFormElem(form.password, spanPassword, passwordErrorMessage)){
		valid = false;
	}

	let spanVia = document.getElementById("errorVia");
	if (!validateFormElem(form.via, spanVia, viaErrorMessage)){
		valid = false;
	}

	let spanCitta = document.getElementById("errorCitta");
	if (!validateFormElem(form.citta, spanCitta, cittaErrorMessage)){
		valid = false;
	}

	let spanCap = document.getElementById("errorCap");
	if (!validateFormElem(form.cap, spanCap, capErrorMessage)){
		valid = false;
	}
	let spanProvincia = document.getElementById("errorProvincia");
	if (!validateFormElem(form.provincia, spanProvincia, provinciaErrorMessage)){
		valid = false;
	}
	return valid;
}