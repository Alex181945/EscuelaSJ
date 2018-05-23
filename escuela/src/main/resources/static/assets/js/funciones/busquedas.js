/**
 * 
 */
function busquedaAlumnoKardex(){
	var elementoBusqueda;
	var numeroAlumno = document.getElementById("NumeroAlumno");
	var nombreAlumno = document.getElementById("NombreAlumno");
	console.log("entre aqui");
	if(numeroAlumno != "" || numeroAlumno != null ){
		elementoBusqueda = numeroAlumno;
	}
	if( nombreAlumno != "" ||  nombreAlumno != null ){
		elementoBusqueda =  nombreAlumno;
	}

	$.ajax({
     	url : '/historial/alumno/busqueda', // cambiar a busqueda de alumno
         dataType : "json",
		 	contentType : "application/json",
		 	data : {
		 		 elementoBusqueda    :  elementoBusqueda
		 	},
		 	type : 'POST',
		 	success : function(data) {	 		 		 		 		
		 	/*	ListVehiculos(data);	 */
		 		console.log("pase por aqui");
		 		console.log(data);
		 	},
		 	error : function(xhr, status) {
		 		
		 
		 		swal('Disculpe, existió un problema');
		 		
		 	}

		});
}