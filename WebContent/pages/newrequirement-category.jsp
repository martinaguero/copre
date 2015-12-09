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
		<h:form id="newrequirement-category">
			<h:panelGrid columns="2">
				<h:outputText value="#{msg.choose_category}" />
				<h:selectOneMenu value="#{requirementBean.selectedCategory}">
					<f:selectItems value="#{requirementBean.categories}" />
				</h:selectOneMenu>
				<h:commandButton action="selectcategory"
					actionListener="#{requirementBean.selectCategory}"
					value="#{msg.accept_btn}" />
			</h:panelGrid>
		</h:form>
	</f:view>
</body>
</html>
