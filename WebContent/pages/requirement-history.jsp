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
			<h:outputText value="#{msg.requirement_history_header}" />
			<hr width="35%" align="left">
		</h1>
		<p>
			<h:messages style="color:darkred" />
		</p>
		<h:form id="requirement-history">
			<h:panelGrid columns="2">
				<h:outputText value="#{msg.input_requirement_id}" />
				<h:inputText value="#{requirementBean.id}" />
				<h:commandButton action="displayhistory"
					actionListener="#{requirementBean.displayHistory}"
					value="#{msg.display_history}" />
			</h:panelGrid>
			<br />
			<h:outputLink value="#{msg.url_home}">
				<f:verbatim>Home</f:verbatim>
			</h:outputLink>
			<hr>
		</h:form>
	</f:view>
</body>
</html>
