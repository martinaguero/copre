<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:loadBundle basename="ar.com.trimatec.copre.gui.bundle.messages" var="msg"/>

<html>
 <head>
  <title>COPRE</title>
 </head>
 <body>
   <f:view>
     <h1>
      <h:outputText value="#{msg.inputname_header}"/>
     </h1>
     <p>
     <h:messages style="color:darkred"/>
     </p>
     <h:form id="newparticipant">
    	<h:panelGrid columns="2" >
	     	<h:outputText value="#{msg.company_name}"/>
    	 		<h:inputText value="#{participantBean.companyName}" size="40" required="true" >
     				<f:validateLength minimum="2" maximum="40" />
				</h:inputText>
			<h:outputText value="#{msg.cuit}"/>
    	 		<h:inputText value="#{participantBean.cuit}" size="30" required="true" >
     				<f:validateLength minimum="10" maximum="20" />
				</h:inputText>
			<h:outputText value="#{msg.email}"/>
    	 		<h:inputText value="#{participantBean.email}" size="30" >
     				<f:validateLength minimum="5" maximum="30" />
				</h:inputText>
			<h:outputText value="#{msg.telephone}"/>
    	 		<h:inputText value="#{participantBean.telephone}" size="30" >
     				<f:validateLength minimum="5" maximum="30" />
				</h:inputText>
			<h:outputText value="#{msg.address}"/>
    	 		<h:inputText value="#{participantBean.address}" size="30" >
     				<f:validateLength minimum="5" maximum="30" />
				</h:inputText>
			<h:outputText value="#{msg.password}"/>
    	 		<h:inputText value="#{participantBean.password}" size="30" >
     				<f:validateLength minimum="5" maximum="30" />
				</h:inputText>
			<h:outputText value="#{msg.categories}"/>	
				<h:selectManyListbox value="#{participantBean.selectedCategories}">
   					<f:selectItems value="#{participantBean.categories}" />
   				</h:selectManyListbox>	
					
			<h:commandButton action="addnewparticipant" actionListener="#{participantBean.addParticipant}" value="#{msg.accept_btn}" />
    	</h:panelGrid>
     </h:form>
   </f:view>
 </body>
</html>  