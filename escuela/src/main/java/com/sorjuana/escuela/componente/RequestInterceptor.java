package com.sorjuana.escuela.componente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sorjuana.escuela.configuracion.Vistas;
import com.sorjuana.escuela.modelo.seg.Usuario;

public class RequestInterceptor extends HandlerInterceptorAdapter {

	/**
	 * This is not a good practice to use sysout. Always integrate any logger with
	 * your application. We will discuss about integrating logger with spring boot
	 * application in some later article
	 */
	private static final Log LOG = LogFactory.getLog(RequestInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

		String cURL = request.getRequestURI();
		request.setAttribute("iniTiempo", System.currentTimeMillis());

		if (!cURL.equals("/") && !cURL.equals("/login") && !cURL.equals("/validausuario")) {
			
			Usuario user = (Usuario) request.getSession().getAttribute("Persona");
			
			if(user == null) {
				response.sendRedirect("/"); 
				return false;
			}
		}
		
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView == null || !modelAndView.hasView()) {
			return;
		}
		String originalViewName = modelAndView.getViewName();
		if (isRedirectOrForward(originalViewName)) {
			return;
		}
		modelAndView.setViewName(Vistas.getDefaultLayout());
		modelAndView.addObject(Vistas.getDefaultViewAttributeName(), originalViewName);
	}

	private boolean isRedirectOrForward(String viewName) {
		return viewName.startsWith("redirect:") || viewName.startsWith("forward:");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3)
			throws Exception {

		long startTime = (long) request.getAttribute("iniTiempo");
		LOG.info("URL:" + request.getRequestURL().toString() + " TIEMPO: "
				+ (System.currentTimeMillis() - startTime + " ms"));

	}
	
}
