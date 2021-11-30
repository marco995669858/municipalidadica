function validar() {

	var nombre = document.getElementById('idNombre').value;
	var paterno = document.getElementById('idapellido').value;
	var materno = document.getElementById('idmaterno').value;
	var dni = document.getElementById('iddni').value;
	var correo = document.getElementById('idcorreo').value;
	var contrsenia = document.getElementById('idpassword').value;
	var celular = document.getElementById('idcelular').value;
	var fecha = document.getElementById('idfecha').value;
	var genero = document.getElementById('idgenero').value;

	var regexemail = /^\w+@\w+\.+[a-z]{2,3}$/;
	var regexnombre = /^[A-Za-zƒŠŒŽšœžŸÀÁÂÃÄÅÆÈÉÊËÌÍÎÏÑÒÓÔÕÖØÙÚÛÜÝàáâãäåæçèé êëìíîïðñòóôõöùúûüýþÿ]*$/;
	var regexapellido = /^[a-zA-ZžŸÀÁÂÃÄÅÆÈÉÊËÌÍÎÏÑÒÓÔÕÖØÙÚÛÜÝÑàáâãäåæçèéêëìíîïðñòóôõöùúûüýþñÿ]*$/;

	if (nombre === '') {
		alert('El campo nombre es obligatorio.');
		return false;
	} else if (nombre.length < 3 || nombre.length >= 30) {
		alert('El nombre solo acepta como minimo 3 y maximo 30.');
		return false;
	} else if (!regexnombre.test(nombre)) {
		alert('Ingrese solo letras.');
		return false;
	} else if (paterno === '') {
		alert('El campo apellido paterno es obligatorio.');
		return false;
	} else if (paterno.length < 3 || paterno.length >= 30) {
		alert('El apellido paterno solo acepta como minimo 3 y maximo 30.');
		return false;
	} else if (!regexapellido.test(paterno)) {
		alert('Ingrese solo un apellido paterno, tampoco se acepta espacios en blanco.');
		return false;
	} else if (materno === '') {
		alert('El campo apellido materno es obligatorio.');
		return false;
	} else if (materno.length < 3 || materno.length >= 30) {
		alert('El apellido materno solo acepta como minimo 3 y maximo 30.');
		return false;
	} else if (!regexapellido.test(materno)) {
		alert('Ingrese solo un apellido materno, tampoco se acepta espacios en blanco.');
		return false;
	} else if (dni === '') {
		alert('El campo dni es obligatorio.');
		return false;
	} else if (dni.length < 8 || dni.length > 8) {
		alert('El dni no tiene que ser menor a 8 o mayor a 8 digitos.');
		return false;
	} else if (isNaN(dni)) {
		alert('El dni solo acepta numeros no letras.');
		return false;
	} else if (correo === '') {
		alert('El campo correo es obligatorio.');
		return false;
	} else if (correo.length < 20 || correo.length >= 50) {
		alert('El correo solo acepta como minimo 20 y maximo 50.');
		return false;
	} else if (!regexemail.test(correo)) {
		alert('El correo no es valido, ejemplo : example123@example.com');
		return false;
	} else if (contrsenia === '') {
		alert('El campo password es obligatorio.');
		return false;
	} else if (contrsenia.length < 8 || contrsenia.length >= 20) {
		alert('El password solo acepta como minimo 8 y maximo 20.');
		return false;
	} else if (celular === '') {
		alert('El campo celular es requerido.');
		return false;
	} else if (celular.length < 9 || celular.length > 9) {
		alert('El celular  no tiene que ser menor a 9 digitos.');
		return false;
	} else if (isNaN(celular)) {
		alert('El celular solo acepta numeros, mas no letras.');
		return false;
	} else if (fecha === '') {
		alert('El campo fecha es requerido.');
		return false;
	} else if (genero === '0') {
		alert('El campo genero es requerido.')
		return false;
	}
	return true;
}
