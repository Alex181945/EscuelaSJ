/**
 * 
 */

function opAtributo(iAtributoPer, iAtributo, iIDTipoPersona, iPersona, cValor, cObs){
	this.iAtributoPer = iAtributoPer;
	this.iAtributo = iAtributo;
	this.iIDTipoPersona = iIDTipoPersona;
	this.iPersona = iPersona;
	this.cValor = cValor;
	this.cObs = cObs;
}

function iPersona(iPersona, iIDTipoPersona, cNombre, cAPaterno, cAMaterno, lGenero, dtFechaNac) {
	this.iPersona = iPersona;
	this.iIDTipoPersona = iIDTipoPersona;
	this.cNombre = cNombre;
	this.cAPaterno = cAPaterno;
	this.cAMaterno = cAMaterno;
	this.lGenero = lGenero;
	this.dtFechaNac = dtFechaNac;
}

function Carrera(iCarrera, cCarrera, lActivo, dtCreado, dtModificado) {
	this.iCarrera = iCarrera;
	this.cCarrera = cCarrera;
	this.lActivo  = lActivo;
	this.dtCreado = dtCreado;
	this.dtModificado = dtModificado;
}

function Periodo(iPeriodo, iCarrera, cPeriodo, lActivo, dtCreado, dtModificado) {
	this.iPeriodo = iPeriodo;
	this.iCarrera = iCarrera;
	this.cPeriodo = cPeriodo;
	this.lActivo  = lActivo;
	this.dtCreado = dtCreado;
	this.dtModificado = dtModificado;
}

function validaCampos(iTipoConsulta, cFormulario){
	
	var objPersona;
	//Array para el detalle
	var arrayAtributo = [];
	
	switch (iTipoConsulta) {
	case '1':
		//Caso del Inserta Registro
		
		switch (cFormulario) {
		case 'alumno':
			//Caso del Alumno
			
			
			
			break;
			
		case 'administrativo':
			//Caso del Administrativo
			
			/*Para el caso general*/
			//Para Nombre
			if(validaComunes('String', $('#cNombre').val())){ break; }			
			//Para Paterno
			if(validaComunes('String', $('#cAPaterno').val())){ break; }			
			//Para Materno
			if(validaComunes('String', $('#cAMaterno').val())){ break; }
			//Para Fecha de Nacimiento
			if(validaComunes('String', $('#dtFechaNac').val())){ break; }
			//Para Genero
			if(validaComunes('String',$('#lGenero').val())){ break; }

			objPersona = new iPersona($('#iPersona').val(), 1, $('#cNombre').val(), $(
				'#cAPaterno').val(), $('#cAMaterno').val(), $('#lGenero').val(), 
				$('#dtFechaNac').val());
			
			/*Para el caso particular*/
			
			//Fecha de ingreso
			if(validaComunes('String', $('#fechaIngreso').val())){ break; }
			arrayAtributo.push(new opAtributo(0, 1, 1, 0, $('#fechaIngreso').val(), ""));
			
			//Fecha de ingreso
			if(validaComunes('String', $('#area').val())){ break; }
			arrayAtributo.push(new opAtributo(0,2,1,0,$('#area').val(),""));
			
			//Telefono
			if(validaComunes('String', $('#telefono').val())){ break; }
			arrayAtributo.push(new opAtributo(0, 3, 1, 0, $('#telefono').val(), ""));
			
			//Telefono Movil
			if(validaComunes('String', $('#telefonoCelular').val())){ break; }
			arrayAtributo.push(new opAtributo(0, 4, 1, 0, $('#telefonoCelular').val(), ""));
			
			//Email
			
			break;
			
		case 'docente':
			//Caso del Docente
			
			break;
			
		case 'asistencia':
			//Caso del Asitencia
			
			break;

		default:
			console.log("Ninguna opcion valida, Inserta Formulario");
			break;
		}
		
		break;
		
	case '2':
		//Caso del Actualiza Registro
		
		switch (cFormulario) {
		case 'alumno':
			//Caso del Alumno
			
			break;
			
		case 'administrativo':
			//Caso del Administrativo
			
			break;
			
		case 'docente':
			//Caso del Docente
			
			break;
			
		case 'asistencia':
			//Caso del Asitencia
			
			break;

		default:
			console.log("Ninguna opcion valida, Actualiza Formulario");
			break;
		}
		
		break;

	default:
		console.log("Ninguna opcion valida, Tipo Formulario");
		break;
	}
	
	//Funcion Ajax
	
	var json1 = JSON.stringify(objPersona);
	var json2 = JSON.stringify(arrayAtributo);
	
	if(typeof objPersona === "undefined" || typeof arrayAtributo === "undefined" ||
		typeof json1 === "undefined" || typeof json2 === "undefined"){
		return;
	}
	
	$.ajax({
		url : "/catalogo/administrativo/inserta",
		data : {
			objPersona : json1,
			arrayAtributo : json2,
		},
		type : 'POST',
		success : function(data) {

			console.log(data);
			if(data == "sucess"){
				swal('Exito...','Exito al registrar','success');
				limpia();
			} else{
				swal('Oops...',data,'error');
			}
			
		},
		error : function(xhr, status) {
			swal('Disculpe, existió un problema');
		},
		// código a ejecutar sin importar si la petición
		// falló o no
		complete : function(xhr, status) {
			//alert('Petición realizada');
		}
	});
	
}

function validaComunes(cTipoValida, cValor){
	
	if(cTipoValida == 'String'){
		if(cValor == "" || cValor == null){
			swal({
				  type: 'error',
				  title: 'Oops...',
				  text: 'El campo no puede ir vacío'
				})
			return true;
		}
	}
	
	if(cTipoValida == 'Integer'){
		if(cValor == 0 || cValor == null){
			swal({
				  type: 'error',
				  title: 'Oops...',
				  text: 'El campo no puede ir vacío'
				})
			return true;
		}
	}		
	
	return false;
	
}

function limpia(){
	$('#cNombre').val()         = "";
	$('#cAPaterno').val()       = "";
	$('#cAMaterno').val()       = "";
	$('#dtFechaNac').val()      = "";
	$('#lGenero').val()         = "";
	$('#fechaIngreso').val()    = "";
	$('#area').val()            = "";
	$('#telefono').val()        = "";
	$('#telefonoCelular').val() = "";
}


function eliminar(urlLocal,ID){
	
	$("#Listas").on('click', '#btnEliminar', function() {
		var row = $(this).closest('tr');
		swal({
			title : 'Eliminar',
			text : "¿Desea eliminar el registro seleccionado?",
			type : 'warning',
			showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'SI',
			  cancelButtonText:  'NO', 
			  closeOnConfirm : false	  
		},function() {

			$.ajax({
				url : urlLocal,
				data : {
					ID : ID
				},
				type : 'POST',
				success : function(data) {

					if (data == "success") {
						row.remove();
						//swal.close();
						swal('Exito...','Exito al eliminar','success');
					} else {
						swal('Error!', data, 'error');
					}
				},
				error : function(xhr, status) {
					swal('Disculpe, existió un problema');
				},
				// código a ejecutar sin importar si la petición
				// falló o no
				complete : function(xhr, status) {
					//alert('Petición realizada');
				}
			});

		});

	});
	
}

function cargaKardex(){
	
}

function enviaInfoCarreraYPeriodo(url){
	
	var objCarrera = new Carrera($('#iCarrera').val(), $('#cCarrera').val(), $(
	'#activoCarrera').val(), "", "");
	
	var arrayPeriodo = [];
	var texto = "#texto";
	var activ = "#activo";
	
	if($("#formPeriodo").find($("input")).length > 0){
		
		for (var i = 0; i < $("#formPeriodo").find($("p")).length; i++) {
			var objPeriodo = new Periodo($("#iCarrera"+(i+1)).val(), $("#iPeriodo"+(i+1)).val(), $(texto+(i+1)).val(), $(activ+(i+1)).val(), "", "");
			arrayPeriodo.push(objPeriodo);
		}
		
		$.ajax({
		       type: "POST",
		       url: url,
		       data: {
		    	   objCarrera : JSON.stringify(objCarrera),
		    	   arrayPeriodo : JSON.stringify(arrayPeriodo)
		       },
		       success: function(data) {
		    	   
		    	   if(data == "sucess"){
						swal('Exito...','Exito al registrar','success');
						limpia();
					} else{
						swal('Oops...',data,'error');
					}
		    	   
		       },
				error : function(xhr, status) {
					swal('Disculpe, existió un problema');
				},
				// código a ejecutar sin importar si la petición
				// falló o no
				complete : function(xhr, status) {
					//alert('Petición realizada');
				}
		});
	}
}

function guardaPeriodos(){
	
}
