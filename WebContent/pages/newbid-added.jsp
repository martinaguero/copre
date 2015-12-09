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
		<h:form id="newbid-added">
			<h:panelGrid columns="2">
				<h3>
					<h:outputText value="#{msg.newbid_added}" />
					<h:outputText value="#{bidBean.bid.id}" />
				</h3>
				<h:outputLink value="#{msg.url_home}">
					<f:verbatim>Home</f:verbatim>
				</h:outputLink>
			</h:panelGrid>
		</h:form>
	</f:view>
</body>
</html>
