/**
 * 
 */
function busquedaAlumnoKardex(){
	var elementoBusqueda;
	var numeroAlumno = $('#numAlum').val();
	var nombreAlumno = $('#nombreAlum').val();

	if(numeroAlumno != "" || numeroAlumno != null ){
		elementoBusqueda = numeroAlumno;
	}else if( nombreAlumno != "" ||  nombreAlumno != null ){
		elementoBusqueda =  nombreAlumno;
	}

	$.ajax({
     	url : '/historial/alumno/busqueda', // cambiar a busqueda de alumno
		 	data : {
		 		 elementoBusqueda    :  elementoBusqueda
		 	},
		 	type : 'POST',
		 	success : function(data) {	 		 		 		 		
		 	/*	ListVehiculos(data);	 */
		 		console.log(data);
		 		
		 		if(data == "" || data != "success"){
		 			
		 		}
		 		
		 	},
		 	error : function(xhr, status) {
		 		
		 
		 		swal('Disculpe, existió un problema');
		 		
		 	}

		});
}