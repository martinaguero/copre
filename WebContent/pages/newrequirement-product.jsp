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
		<h:form id="newrequirement-product">
			<h:panelGrid columns="1">
				<h:outputText value="#{msg.choose_product}" />
				<h:selectOneRadio value="#{requirementBean.selectedProduct}">
					<f:selectItems value="#{requirementBean.products}" />
				</h:selectOneRadio>
			</h:panelGrid>
			<h:commandButton action="selectproduct"
					actionListener="#{requirementBean.selectProduct}"
					value="#{msg.accept_btn}" />
		</h:form>
	</f:view>
</body>
</html>
