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
			<h:outputText value="#{msg.software_name}" />
			<hr>
		</h1>
		<p>
			<h:messages style="color:darkred" />
		</p>
		<h:form id="author">
			<h:panelGrid columns="2">
				<h:outputText value="#{msg.author}" />
				<h:outputText value="#{msg.author_name}" />
				<h:outputText value="#{msg.for}" />
				<h:outputText value="#{msg.course}" />
				<h:outputText value="#{msg.professor}" />
				<h:outputText value="#{msg.professor_name}" />
			</h:panelGrid>
			<h:panelGrid columns="1">
				<br />
				<h:outputText value="#{msg.university}" />
				<h:outputText value="#{msg.date}" />
			</h:panelGrid>
			<br />
			<h:outputLink value="#{msg.url_home}">
				<f:verbatim>Home</f:verbatim>
			</h:outputLink>
		</h:form>
	</f:view>
</body>
</html>
