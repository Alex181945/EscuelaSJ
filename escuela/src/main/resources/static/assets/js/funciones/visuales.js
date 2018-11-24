/**
 * 
 * Autor: Alejandro Estrada
 * Fecha: 06/04/2018
 * Descripcion: Maneja los eventos del lado del
 * cliente visuales
 *  
 * Modificaciones:
 * <Quien modifico:> <Cuando modifico:> <Donde modifico:>
 * Ejemplo: Alejandro Estrada 09/09/2017 In-15 Fn-19 
 * 
 */

function modal() {
	$('.modal').modal('show');
}

$(document).ready(function() {
    if(document.getElementById("messageError").innerHTML != ""){
		swal('Oops...',document.getElementById("messageError").innerHTML,'error');
	}
    
    if(document.getElementById("messageExito").innerHTML != ""){
		swal('Exito...',document.getElementById("messageExito").innerHTML,'success');
	}

});