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
			validaComunes('String', $('#cNombre').val());			
			//Para Paterno
			validaComunes('String', $('#cAPaterno').val());			
			//Para Materno
			validaComunes('String', $('#cAMaterno').val());
			

			objPersona = new iPersona($('#iPersona').val(), $(
				'#iIDTipoPersona').val(), $('#cNombre').val(), $(
				'#cAPaterno').val(), $('#cAMaterno').val(), $('#lGenero').val(), 
				$('#dtFechaNac').val());
			
			/*Para el caso particular*/
			
			//Fecha de ingreso
			validaComunes('String', $('#fechaIngreso').val());
			arrayAtributo.push(new opAtributo(0, 1, 0, 0, $('#fechaIngreso').val(), ""));
			
			//Fecha de ingreso
			validaComunes('String', $('#area').val());
			arrayAtributo.push(new opAtributo(0,2,0,0,$('#area').val(),""));
			
			//Telefono
			validaComunes('String', $('#telefono').val());
			arrayAtributo.push(new opAtributo(0, 3, 0, 0, $('#telefono').val(), ""));
			
			//Telefono Movil
			validaComunes('String', $('#telefonoCelular').val());
			arrayAtributo.push(new opAtributo(0, 4, 0, 0, $('#telefonoCelular').val(), ""));
			
			//Email
			
			console.log(objPersona);
			console.log(arrayAtributo);
			
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
	
	$.ajax({
		url : "/catalogo/administrativo/inserta",
		data : {
			objPersona : json1,
			arrayAtributo : json2,
		},
		type : 'POST',
		success : function(data) {

			console.log(data);
			
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
			return ;
		}
	}
	
	if(cTipoValida == 'Integer'){
		if(cValor == 0 || cValor == null){
			swal({
				  type: 'error',
				  title: 'Oops...',
				  text: 'El campo no puede ir vacío'
				})
			return ;
		}
	}		
	
}