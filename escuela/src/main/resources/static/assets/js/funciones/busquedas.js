/**
 * 
 */


function buscaEnter(e, formType){

	//FormType 1 solo numeros 2 solo letras
	if(formType === 1){
		soloNumeros(e);
	}
	
	if(formType === 2){
		soloLetras(e)
	}
	
	busquedaAlumnoKardex();
	
}


function busquedaAlumnoKardex(){
	
	var elementoBusqueda;
	var tipoBusqueda;
	var numeroAlumno = $('#numAlum').val();
	var nombreAlumno = $('#nombreAlum').val();

	if(numeroAlumno != "" && numeroAlumno != null ){
		$('#nombreAlum').val('');
		tipoBusqueda = "numero";
		elementoBusqueda = numeroAlumno;
	}else if( nombreAlumno != "" &&  nombreAlumno != null ){
		$('#numAlum').val('');
		tipoBusqueda = "caracter";
		elementoBusqueda =  nombreAlumno;
	}

	$.ajax({
     	url : '/historial/alumno/busqueda', // cambiar a busqueda de alumno
		 	data : {
		 		 tipoBusqueda        :  tipoBusqueda,
		 		 elementoBusqueda    :  elementoBusqueda		 		 
		 	},
		 	type : 'POST',
		 	success : function(data) {	 		 		 		 		
		 	/*	ListVehiculos(data);	 */		 		
		 		if(data != ""){
		 			
		 			var dataMod = [];
		 			var control;
		 			listaAlumno(data);
		 			
		 		}
		 		
		 	},
		 	error : function(xhr, status) {
		 		
		 
		 		swal('Disculpe, existió un problema');
		 		
		 	}

		});
}

function listaAlumno(dataSet){
	
	//Reinicializa la tabla
	var tVehiculos = $('#Listas').DataTable( {
		 retrieve: true,
		 paging: false
	 } );
	 
	 tVehiculos.destroy();
	
	var myObject = JSON.parse(dataSet);
	
	var uniqueNames = [];
	var iPersonaTemp = 0;
	for (var i = 0; i < myObject.length; i++) {
		if(iPersonaTemp != myObject[i].iPersona){
			uniqueNames.push(myObject[i])
		}
		iPersonaTemp = myObject[i].iPersona;
	}
	
	//uniqueNames = JSON.stringify(uniqueNames);
	console.log(uniqueNames);
	
	$('#Listas').DataTable( {
        data: uniqueNames,
        "columns" : [
        	{ "data" : "iPersona" },
            { "data" : "cNombre" },
            { "data": null,
                "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {                                  	
                	$(nTd).html(" <button type='button' id='btnEliminarCli' class='btn btn-info' onclick='consultaHistorial(" + oData.iPersona +  ")' >" + "<span class='fas fa-search'  aria-hidden='true'></span> </button>");
                }
            },
			
		],
		"pageLength": 5,
		 "lengthMenu": [ 5 , 10 ],
	
		 "language": {

				"sProcessing":     "Procesando...",
				"sLengthMenu":     "Mostrar _MENU_ registros",
				"sZeroRecords":    "No se encontraron resultados",
				"sEmptyTable":     "Ningún dato disponible en esta tabla",
				"sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
				"sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
				"sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
				"sInfoPostFix":    "",
				"sSearch":         "Buscar:",
				"sUrl":            "",
				"sInfoThousands":  ",",
				"sLoadingRecords": "Cargando...",
				"oPaginate": {
					"sFirst":    "Primero",
					"sLast":     "Último",
					"sNext":     "Siguiente",
					"sPrevious": "Anterior"
				},
				"oAria": {
					"sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
					"sSortDescending": ": Activar para ordenar la columna de manera descendente"
				}
		 }
    } );	
}