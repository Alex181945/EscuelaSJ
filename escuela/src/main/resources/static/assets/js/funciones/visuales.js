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

var contador = 1;

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

function agregaPeriodo(){
	
    var campo = "<div class='form-row align-items-center'>";
    campo += "<p></p>";
    campo += "<div class='col-auto'>";
    campo += "<label class='sr-only' for='inlineFormInput'>Grado</label>" ;
    campo += "<input type='hidden' class='form-control mb-2' id='iCarrera"+contador+"' placeholder='Grado' />" ;
    campo += "<input type='hidden' class='form-control mb-2' id='iPeriodo"+contador+"' placeholder='Grado' />" ;
    campo += "<input type='text' class='form-control mb-2' id='texto"+contador+"' placeholder='Grado' value='Grado Genérico' />" ;
    campo += "<input type='hidden' class='form-control mb-2' id='activo"+contador+"' placeholder='Grado' />" ;
    campo += "</div>" ;
    campo += "<div class='col-auto'>";
    campo += "<button type='button' class='btn btn-primary mb-2' onclick='eliminaPeriodo((myfieldid" + contador + "), "+ contador +");'>Eliminar</button>" ;
    campo += "</div>" ;
    campo += "</div>" ;

    // append input control at end of form
    $(campo)
        .attr("id", ("myfieldid" + contador))
        .attr("name", ("myfieldid" + contador))
        .appendTo("#formPeriodo");
    
    contador ++;

}

function eliminaPeriodo(id, cont){
	$(("#activo"+cont)).val(0);
	id.hide();
}