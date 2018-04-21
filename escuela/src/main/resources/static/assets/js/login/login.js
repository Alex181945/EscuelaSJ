/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 10/03/2018
 * Descripcion: Maneja los eventos del lado del
 * cliente al iniciar sesion
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 * 
 */

function validarUsuario(e){
	if (e.keyCode == 13) {
		enviaInfo();
    }
}

function segValidaForm(){
	
	if($('#username').val() == "" && $('#password').val() == ""){
		usuarioVacio();
		passwordVacio();
		return false;
	} else if($('#username').val() == ""){
		usuarioVacio();
	} else if($('#password').val() == ""){
		passwordVacio();
	}
	
	if($('#username').val() != "" && $('#password').val() != ""){
		
		usuarioValor();
		passwordValor();
		return true;
		
	}else if($('#username').val() != ""){
		usuarioValor();
	} else if($('#password').val() != ""){
		passwordValor();
	}

}

function usuarioVacio(){
	$('#username').addClass('form-control is-invalid');
	document.getElementById("errorU").innerHTML = "Ingresa tu usuario";
	$('#errorU').addClass('invalid-feedback');
}

function usuarioValor(){
	$('#username').removeClass('form-control is-invalid');
	$('#username').addClass('form-control is-valid');
	document.getElementById("errorU").innerHTML = "";
	$('#errorU').removeClass('invalid-feedback');
}

function passwordVacio(){
	$('#password').addClass('form-control is-invalid');
	document.getElementById("errorP").innerHTML = "Ingresa tu contraseña";
	$('#errorP').addClass('invalid-feedback');
}

function passwordValor(){
	$('#password').removeClass('form-control is-invalid');
	$('#password').addClass('form-control is-valid');
	document.getElementById("errorP").innerHTML = "";
	$('#errorP').removeClass('invalid-feedback');
}

function enviaInfo(){
	modal();
	if(segValidaForm()){
		$('#formLogin').submit();
	}
}

$(document).ready(function() {
    if(document.getElementById("message").innerHTML != ""){
		swal('Oops...',document.getElementById("message").innerHTML,'error');
	}
    
    $("input[type=text]").on("keypress", function () {
    	segValidaForm();
    });
    $("input[type=password]").on("keypress", function () {
    	segValidaForm();
    });
});