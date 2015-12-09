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
		<h:form id="requirement-history-listhistory">
			<h:dataTable id="nodes" value="#{requirementBean.workflowNodes}"
				var="status">
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msg.id}" />
					</f:facet>
					<h:outputText value="#{status.requirementId}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msg.init_date}" />
					</f:facet>
					<h:outputText value="#{status.initDate}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msg.end_date}" />
					</f:facet>
					<h:outputText value="#{status.endDate}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msg.status}" />
					</f:facet>
					<h:outputText value="#{status.status}" />
				</h:column>
			</h:dataTable>
			<br />
			<hr>
			<h:commandButton action="newhistory" value="#{msg.new_request}" />
		</h:form>
	</f:view>
</body>
</html>
