
//Solo letras en HTML con erta 
function soloLetras(e){
	key = e.keyCode || e.which;
	tecla = String.fromCharCode(key).toLowerCase();
	letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
	especiales = "8-37-39-46";

	tecla_especial = false
	for(var i in especiales){
		 if(key == especiales[i]){
			 tecla_especial = true;
			 break;
		 }
	 }

	 if(letras.indexOf(tecla)==-1 && !tecla_especial){
		 //alert("Campo solo para ingresar Letras");
		 swal('Solo permite letras',document.getElementById("message").innerHTML,'error');
		 return false;
	 }
 }//Fin de funcion solo letras

 function soloNumeros(e){
	key = e.keyCode || e.which;
	tecla = String.fromCharCode(key).toLowerCase();
	numeros = " 0123456789.";

	if(numeros.indexOf(tecla)==-1){
		 //alert("Campo solo para ingresar Numeros");
		 swal('Solo permite numeros',document.getElementById("message").innerHTML,'error');
		 return false;
	 }
 }//Fin de funcion solo numeros
