<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/angularjs/controllers.js"></script>
<script>
var app = angular.module('showUsersCntApp',[]);
app.controller('showUsersCntCtrl', showUsersContentController);
var jsonObject = ${showUsersViewBean.mapMsgs['jsonUsers']};
//alert(JSON.stringify(jsonObject));
</script>    
<div ng-app='showUsersCntApp' ng-controller="showUsersCntCtrl as vm" data-ng-init="vm.init('${pageContext.request.contextPath}','${_csrf.token}')" >
  <div class="container">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h1>
            <span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> 
           <spring:message
					code="showUsersView.panel.header.title" /> 
					<small><spring:message
					code="showUsersView.panel.header.subtitle" /></small>
        </h1>
      </div>
      <div class="panel-body">
          <div class="table-responsive">

          
             <!--  Hay usuarios -->
              <div  ng-if="vm.jsonObject.length > 0" class="panel panel-default">
              <table class="table table-striped table-condensed">
                <thead>
                  <tr>
                      <th><spring:message
					code="showUsersView.table.user.field.id" /></th>
                      <th><spring:message
					code="showUsersView.table.user.field.user" /></th>
                      <th><spring:message
					code="showUsersView.table.user.field.role" /></th>
                      <th><spring:message
					code="showUsersView.table.user.field.enabled" /></th>
                      <th><spring:message
					code="showUsersView.table.user.field.email" /></th>
                      <th><spring:message
					code="showUsersView.table.user.field.createdate" /></th>
                      <th><spring:message
					code="showUsersView.table.user.field.actions" /></th>
                  </tr>
                </thead>
             <!--   {% for entity in entities %}
                  {% if (entity.isAdmin == 1) %}
                    {% set admin = '<span class="glyphicon glyphicon-ok verde" aria-hidden="true"></span>' %}
                  {% else %}
                    {% set admin = '<span class="glyphicon glyphicon-ban-circle rojo" aria-hidden="true"></span>' %}
                  {% endif %}
                  {% if (entity.isActive == 1) %}
                    {% set activo = '<span class="glyphicon glyphicon-ok verde" aria-hidden="true"></span>' %}
                  {% else %}
                    {% set activo = '<span class="glyphicon glyphicon-ban-circle rojo" aria-hidden="true"></span>' %}
                  {% endif %}-->
                  <tr ng-model="vm.jsonObject" ng-repeat="user in vm.jsonObject track by $index" >
                      <td><a title='Mostrar' href="">{{user.idUUID}}</a></td>
                      <td>{{user.userName}}  </td>
                      <td>{{user.userRoles[0].role}} </td>
                      <td> {{user.enabled}}</td>
                      <td> {{user.email}} </td>
                      <td> {{user.createTime2 | date:'dd-MM-yyyy'}}</td>
                      <td>
                      <table>
                        <tr>
                         <!--  <td>
                              <a title='Mostrar' ng-href="${pageContext.request.contextPath}/user/show/{{user.idUUID}}" >
                                <span class="glyphicon glyphicon-search" aria-hidden="true">&nbsp;</span>
                              </a>
                          </td>
                          <td>
                              <a title='Editar'  ng-href="${pageContext.request.contextPath}/user/edit/{{user.idUUID}}">
                                <span class="glyphicon glyphicon-edit" aria-hidden="true">&nbsp;</span>
                              </a>
                          </td>
                          -->
                          <td>
                          
                              <a title="<spring:message code="showUsersView.table.action.delete" />" ng-href="${pageContext.request.contextPath}/user/delete/{{user.idUUID}}" >
                                <span class="glyphicon glyphicon-remove" aria-hidden="true" colspan="3">&nbsp;</span>
                              </a>
                          </td>
                        </tr>
                      </table>
                      </td>
                  </tr>
           <!--    {% endfor %} -->
              </table>
              </div>
          <!--   {% else %} -->
               <div ng-if="vm.jsonObject.length == 0">
               
                <div  class="alert alert-danger alert-dismissible fade in" role="alert">
                  <button type="button" class="close" data-dismiss="alert">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span>
                  </button>
                  <h4>¡No se han encontrado resultados!</h4>
                </div>
                <p>
                  <a href="${pageContext.request.contextPath}/">
                    <button type="button" class="btn btn-primary btn-lg">Inicio</button>
                  </a>
                </p>
           </div>

          </div>
      </div>
        
    </div>
  </div>


     
</div>