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
	
	switch (iTipoConsulta) {
	case 1:
		//Caso del Inserta Registro
		
		switch (cFormulario) {
		case 'alumno':
			//Caso del Alumno
			
			
			
			break;
			
		case 'administrativo':
			//Caso del Administrativo
			
			console.log(cNombre);
			
			if(cNombre == "" || cNombre == null){
				swal({
					  type: 'error',
					  title: 'Oops...',
					  text: 'El nombre no puede ir vacío'
					})
				return ;
			}
			
			break;
			
		case 'docente':
			//Caso del Docente
			
			break;
			
		case 'asistencia':
			//Caso del Asitencia
			
			break;

		default:
			break;
		}
		
		break;
		
	case 2:
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
			break;
		}
		
		break;

	default:
		break;
	}
	
	
	
}

