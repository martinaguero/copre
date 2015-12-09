<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:loadBundle basename="ar.com.trimatec.copre.gui.bundle.messages"
	var="msg" />

<html>
<head>
<title>COPRE</title>
</head>
<body>
	<f:view>
		<h:form id="error">
			<h3>
			<h:panelGrid columns="1">
				<h:outputText value="#{errorBean.errorMessage}" />
				<h:commandLink actionListener="#{errorBean.resetSession}" value="#{msg.back}" />
			</h:panelGrid>
			</h3>
			</h:form>
	</f:view>
</body>
</html>
