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
		<h:form id="newrequirement-product-item">
			<h:panelGrid columns="2">
				<h:outputText value="#{msg.product_name}" />
				<h:outputText value="#{requirementBean.product.name}" />
				<h:outputText value="#{msg.bar_code}" />
				<h:outputText value="#{requirementBean.product.barCode}" />
				<h:outputText value="#{msg.brand}" />
				<h:outputText value="#{requirementBean.product.brand.name}" />
				<h:outputText value="#{msg.quantity}" />
				<h:inputText value="#{requirementBean.quantity}" size="10">
					<f:validateLength minimum="1" maximum="10" />
				</h:inputText>
				<h:outputText value="#{msg.choose_measure}" />
				<h:selectOneMenu value="#{requirementBean.selectedMeasure}">
					<f:selectItems value="#{requirementBean.measures}" />
				</h:selectOneMenu>
			</h:panelGrid>
			<br/>
			<h:commandButton action="newitem"
				actionListener="#{requirementBean.saveItem}"
				value="#{msg.add_item}" />
			<h:commandButton action="displayrequirement"
				actionListener="#{requirementBean.saveItem}"
				value="#{msg.continue}" />
		</h:form>
	</f:view>
</body>
</html>
