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
			<h:outputText value="#{msg.newproduct_header}" />
		</h1>
		<p>
			<h:messages style="color:darkred" />
		</p>
		<h:form id="newproduct">
			<h:panelGrid columns="2">
				<h:outputText value="#{msg.product_name}" />
				<h:inputText value="#{catalogBean.productName}" size="40">
					<f:validateLength minimum="2" maximum="40" />
				</h:inputText>
				<h:outputText value="#{msg.bar_code}" />
				<h:inputText value="#{catalogBean.barCode}" size="40">
					<f:validateLength minimum="2" maximum="40" />
				</h:inputText>
				<h:outputText value="#{msg.categories}" />
				<h:selectManyListbox value="#{catalogBean.selectedCategories}">
					<f:selectItems value="#{catalogBean.categories}" />
				</h:selectManyListbox>
				<h:outputText value="#{msg.brand}" />
				<h:selectOneMenu id="selectBrand" value="#{catalogBean.selectedBrand}">
					<f:selectItems value="#{catalogBean.brands}" />
				</h:selectOneMenu>
				<h:commandButton action="addnewproduct"
					actionListener="#{catalogBean.addProduct}"
					value="#{msg.accept_btn}" />
			</h:panelGrid>
		</h:form>
	</f:view>
</body>
</html>
