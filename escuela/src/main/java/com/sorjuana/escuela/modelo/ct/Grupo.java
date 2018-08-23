package com.sorjuana.escuela.modelo.ct;

public class Grupo {
		private Integer iPersona;
		private Integer iIDTipoPersona;
		private String cNombre;
		private String cAPaterno;
		private String cAMaterno;
		private Integer lGenero;
		private String dtFechaNac;
		private Integer lActivo;
		private String dtCreado;
		private String dtModificado;
		
		private String cSalon;
		private String cGrado;
		private String cNivelE;
		private String cAlumno;
		private String cProfesor;
		private String cObs;
		
		public Integer getiPersona() {
			return iPersona;
		}
		public void setiPersona(Integer iPersona) {
			this.iPersona = iPersona;
		}
		public Integer getiIDTipoPersona() {
			return iIDTipoPersona;
		}
		public void setiIDTipoPersona(Integer iIDTipoPersona) {
			this.iIDTipoPersona = iIDTipoPersona;
		}
		public String getcNombre() {
			return cNombre;
		}
		public void setcNombre(String cNombre) {
			this.cNombre = cNombre;
		}
		public String getcAPaterno() {
			return cAPaterno;
		}
		public void setcAPaterno(String cAPaterno) {
			this.cAPaterno = cAPaterno;
		}
		public String getcAMaterno() {
			return cAMaterno;
		}
		public void setcAMaterno(String cAMaterno) {
			this.cAMaterno = cAMaterno;
		}
		public Integer getlGenero() {
			return lGenero;
		}
		public void setlGenero(Integer lGenero) {
			this.lGenero = lGenero;
		}
		public String getDtFechaNac() {
			return dtFechaNac;
		}
		public void setDtFechaNac(String dtFechaNac) {
			this.dtFechaNac = dtFechaNac;
		}
		public Integer getlActivo() {
			return lActivo;
		}
		public void setlActivo(Integer lActivo) {
			this.lActivo = lActivo;
		}
		public String getDtCreado() {
			return dtCreado;
		}
		public void setDtCreado(String dtCreado) {
			this.dtCreado = dtCreado;
		}
		public String getDtModificado() {
			return dtModificado;
		}
		public void setDtModificado(String dtModificado) {
			this.dtModificado = dtModificado;
		}
		public String getcSalon() {
			return cSalon;
		}
		public void setcSalon(String cSalon) {
			this.cSalon = cSalon;
		}
		public String getcAlumno() {
			cAlumno = cNombre + " " + cAPaterno + " " + cAMaterno;
			return cAlumno;
		}
		public String getcGrado() {
			return cGrado;
		}
		public void setcGrado(String cGrado) {
			this.cGrado = cGrado;
		}
		public String getcNivelE() {
			return cNivelE;
		}
		public void setcNivelE(String cNivelE) {
			this.cNivelE = cNivelE;
		}
		public String getcProfesor() {
			return cProfesor;
		}
		public void setcProfesor(String cProfesor) {
			this.cProfesor = cProfesor;
		}
		public String getcObs() {
			return cObs;
		}
		public void setcObs(String cObs) {
			this.cObs = cObs;
		}

	}

