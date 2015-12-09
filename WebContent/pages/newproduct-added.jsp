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
		<h3>
			<h:outputText value="#{msg.newproduct_added}" />
			<h:outputText value="#{catalogBean.productName}" />
		</h3>
		<h:outputLink value="#{msg.url_home}">
			<f:verbatim>Home</f:verbatim>
		</h:outputLink>
	</f:view>
</body>
</html>
