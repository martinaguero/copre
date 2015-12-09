package ar.com.trimatec.copre.gui;

import java.io.IOException;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import ar.com.trimatec.copre.utils.Constants;

public class ErrorBean {

	Throwable ex = null;

	public String getErrorMessage() {
		String msg = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestMap = context.getExternalContext().getRequestMap();
		ex = (Throwable) requestMap.get("javax.servlet.error.exception");

		if (ex != null) {
			msg = ResourceBundle.getBundle(
					"ar.com.trimatec.copre.gui.bundle.messages").getString(
					ex.getCause().getMessage());
		}
		if (msg == null && ex != null) {
			msg = ex.getCause().getMessage();
		}

		return msg;
	}

	public void resetSession(ActionEvent event) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(false);
		session.invalidate();
		ExternalContext eContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		eContext.redirect(eContext.getRequestContextPath() + getPath());
	}

	private String getPath() {
		String path = null;
		String msg = ex.getCause().getMessage();
		if (msg.indexOf("_") > -1) {
			path = "/pages/" + msg.substring(0, msg.indexOf("_"))
					+ Constants.EXT_JSF;
		}
		return path;
	}

}
