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
			<h:outputText value="#{msg.newrequirement_header}" />
		</h1>
		<p>
			<h:messages style="color:darkred" />
		</p>
		<h:form id="newrequirement">
			<h:dataTable id="items" value="#{requirementBean.items}"
				var="item">				
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msg.product}" />
					</f:facet>
					<h:outputText value="#{item.product.name}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msg.brand}" />
					</f:facet>
					<h:outputText value="#{item.product.brand.name}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msg.quantity}" />
					</f:facet>
					<h:outputText value="#{item.quantity}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msg.measure}" />
					</f:facet>
					<h:outputText value="#{item.measure.name}" />
				</h:column>
			</h:dataTable>
			<h:commandButton action="saverequirement"
					actionListener="#{requirementBean.saveRequirement}"
					value="#{msg.confirm}" />
		</h:form>
	</f:view>
</body>
</html>
