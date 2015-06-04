<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="panel panel-default" ng-controller="showAlbumesListController as vm" 
data-ng-init="vm.init('${pageContext.request.contextPath}','${indexView.mapMsgs['userId']}')">
  <div class="table-responsive">
    <table class="table table-striped table-condensed">
          <tr ng-model="vm.jsonObject" ng-repeat="album in vm.jsonObject.items track by $index">
            <td>
              <a ng-href="${pageContext.request.contextPath}/album/details/{{album.id}}">
                <img ng-src='{{album.images[0].url}}' width='64' height='64' alt='Imagen {{album.name}}' title='{{album.name}}'>
              </a>
            </td>
            <td>{{album.name}}</td>
          </tr>
    </table>
  </div>
</div>

