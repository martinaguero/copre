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
		<h1>
			<h:outputText value="#{msg.bidadmin_header}" />
			<hr width="35%" align="left">
		</h1>
		<p>
			<h:messages style="color:darkred" />
		</p>
		<h:form id="bidadmin-confirmbid-added">
			<h:panelGrid columns="2">
				<h3>
					<h:outputText value="#{msg.confirmbid_added}" />
					<h:outputText value="#{bidAdminBean.bid.id}" />
				</h3>
			</h:panelGrid>
			<h:outputLink value="#{msg.url_home}">
				<f:verbatim>Home</f:verbatim>
			</h:outputLink>
		</h:form>
	</f:view>
</body>
</html>
