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
			<h:outputText value="#{msg.newbid_header}" />
		</h1>
		<p>
			<h:messages style="color:darkred" />
		</p>
		<h:form id="newbid">
			<h:panelGrid columns="2">
				<h:outputText value="#{msg.requirement_id}" />
				<h:outputText value="#{bidBean.requirement.id}" />
				<h:outputText value="#{msg.price}" />
				<h:inputText value="#{bidBean.price}" size="10" >
					<f:validateLength minimum="1" maximum="30" />
				</h:inputText>
				<h:outputText value="#{msg.comments}" />
				<h:inputTextarea id="textArea" rows="4" cols="17"
					value="#{bidBean.comment}" />
			</h:panelGrid>

			<br />
			<h:commandButton action="savebid" actionListener="#{bidBean.saveBid}"
				value="#{msg.confirm}" />
			<br />
		</h:form>
	</f:view>
</body>
</html>
