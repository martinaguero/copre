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
			<hr width="35%" align="left">
		</h1>
		<p>
			<h:messages style="color:darkred" />
		</p>
		<h:form id="newbid-listrequirements">
			<h:panelGrid columns="2">
				<h:outputText value="#{msg.requirement_id}" />
				<h:outputText value="#{bidBean.requirement.id}" />
			</h:panelGrid>
			<h:dataTable id="items" value="#{bidBean.items}" var="item">
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msg.id}" />
					</f:facet>
					<h:outputText value="#{item.id}" />
				</h:column>
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
			<br />
			<h:commandButton action="bid" value="#{msg.bid}" />
			<br />
			<hr>
			<h:panelGrid columns="4">
				<h:outputText value="#{msg.displaying} " />
				<h:outputText value="#{bidBean.index}" />
				<h:outputText value="#{msg.of} " />
				<h:outputText value="#{bidBean.reqListSize}" />
			</h:panelGrid>
			<h:commandButton action="previous"
				actionListener="#{bidBean.previous}" value="#{msg.previous}" />
			<h:commandButton action="refresh"
				actionListener="#{bidBean.refresh}" value="#{msg.refresh}" />
			<h:commandButton action="next" actionListener="#{bidBean.next}"
				value="#{msg.next}" />
			<br/>
			<br/>
			<h:outputLink value="#{msg.url_home}">
				<f:verbatim>Home</f:verbatim>
			</h:outputLink>
		</h:form>
	</f:view>
</body>
</html>
