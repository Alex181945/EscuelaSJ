package com.sorjuana.escuela.modelo.ct;

public class Docente { 
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
		
		private Integer iNumEmp;
		private String cNomDoc;
		private String cCedPro;
		private String cFecIng;
		private String cTel;
		private String cEmail;
		
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
		public Integer getiNumEmp() {
			return iNumEmp;
		}
		public void setiNumEmp(Integer iNumEmp) {
			this.iNumEmp = iNumEmp;
		}
		public String getcNomDoc() {
			cNomDoc = cNombre + " " + cAPaterno + " " + cAMaterno;
			return cNomDoc;
		}
		public void setcNomDoc(String cNomDoc) {
			this.cNomDoc = cNomDoc;
		}
		public String getcCedPro() {
			return cCedPro;
		}
		public void setcCedPro(String cCedPro) {
			this.cCedPro = cCedPro;
		}
		public String getcFecIng() {
			return cFecIng;
		}
		public void setcFecIng(String cFecIng) {
			this.cFecIng = cFecIng;
		}
		public String getcTel() {
			return cTel;
		}
		public void setcTel(String cTel) {
			this.cTel = cTel;
		}
		public String getcEmail() {
			return cEmail;
		}
		public void setcEmail(String cEmail) {
			this.cEmail = cEmail;
		}
		
}
