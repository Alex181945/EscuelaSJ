/**
 * 
 */

function validaCampos(iTipoConsulta, cFormulario){
	
	//Encabezado
	var iPersona       = $('#iPersona').val();
	var iIDTipoPersona = $('#iIDTipoPersona').val();
	var cNombre        = $('#cNombre').val();
	var cAPaterno      = $('#cAPaterno').val();
	var cAMaterno      = $('#cAMaterno').val();
	var lGenero        = $('#lGenero').val();
	var dtFechaNac     = $('#cNombre').val();
	
	//Detalle
	var opAtributo = new Object();
	opAtributo.iAtributoPer;
	opAtributo.iAtributo;
	opAtributo.iIDTipoPersona;
	opAtributo.iPersona;
	opAtributo.cValor;
	opAtributo.cObs;
	
	//Array para el detalle
	arrayAtributo = [];
	
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
			validaComunes('String', cNombre);			
			//Para Paterno
			validaComunes('String', cAPaterno);			
			//Para Materno
			validaComunes('String', cAMaterno);
			
			/*Para el caso particular*/
			//Fecha de ingreso
			validaComunes('String', $('#fechaIngreso').val());
			opAtributo.iAtributoPer = 0;
			opAtributo.iAtributo = 1;
			opAtributo.iIDTipoPersona = 1;
			opAtributo.iPersona = 0;
			opAtributo.cValor = $('#fechaIngreso').val();
			opAtributo.cObs = "";			
			arrayAtributo.push(opAtributo);
			
			//Fecha de ingreso
			validaComunes('String', $('#area').val());
			opAtributo.iAtributoPer = 0;
			opAtributo.iAtributo = 2;
			opAtributo.iIDTipoPersona = 1;
			opAtributo.iPersona = 0;
			opAtributo.cValor = $('#area').val();
			opAtributo.cObs = "";			
			arrayAtributo.push(opAtributo);
			
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
	
}

function validaComunes(cTipoValida, cValor){
	if(cTipoValida == 'String'){
		if(cValor == "" || cValor == null){
			swal({
				  type: 'error',
				  title: 'Oops...',
				  text: 'El nombre no puede ir vacío'
				})
			return ;
		}
	}
	
	if(cTipoValida == 'Integer'){
		if(cValor == 0 || cValor == null){
			swal({
				  type: 'error',
				  title: 'Oops...',
				  text: 'El nombre no puede ir vacío'
				})
			return ;
		}
	}		
	
}