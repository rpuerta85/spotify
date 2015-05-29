<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

 <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true"
 ng-controller="showTracksListController as vm" 
data-ng-init="vm.init('${pageContext.request.contextPath}')"
 >
          <div class="panel panel-default" ng-model="vm.jsonObject" ng-repeat="tema in vm.jsonObject.items track by $index">
                <div id="heading{{ $index }}" class="panel-heading" role="tab">
                <h4 class="panel-title">
                  Disco {{ tema.disc_number }} -  
                  <a data-toggle="collapse" data-parent="#accordion" href="#collapse{{ $index }}"
                     aria-expanded="true" aria-controls="collapse{{ $index }}">
                    [{{ tema.track_number }}]: {{ tema.name }} <span class="caret"></span>
                  </a>
                </h4>
             </div>
           
            <div id="collapse{{ $index }}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading{{ $index }}">
                <div class="panel-body">
                  <div class='row'>
                    <div class='col-sm-1'>
                    
                        <button id="btnGuardarCorreo" type="button" class="btn-link" onclick="crearContenidoCapaCorreoOrdinario('Tema');">
                            <big> <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span></big>
                        </button>
            
                     </div>
                     <div class='col-sm-3'>
                    
                       Duración: {{tema.duration_ms / 60000 | noFractionCurrency }}:{{(tema.duration_ms /1000)%60 | noFractionCurrency }}
                     
                     </div>
                     <div class='col-sm-2'>
                       <a ng-href='{{ tema.external_urls.spotify }}' target='_blank' title='Escuchar en Spotify'>
                  			 <img src="${pageContext.request.contextPath}/resources/images/logoSpotify.png" class="img-responsive" alt="Spotify"><br>
                        
                       </a>
                     </div>
                     <div class='col-sm-3'>
                        <button ng-click="vm.kk(tema.preview_url)" type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-modal-sm" title="Escuchar">
                          Preview &raquo;
                        </button>
                        <div class="modal fade bs-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel{{ $index }}" aria-hidden="true">
                          <div class="modal-dialog modal-sm">
                            <div class="modal-content">
                               <video id="video" controls>
                               
                               </video> 
                            <!--    <video controls="controls" name="media">
                                 <source ng-src="{{ vm.songSelect(tema.preview_url) }}" type="audio/mpeg">
                             
                              </video>  -->
                              <audio controls="controls" preload="none">
 
							</audio>
                           </div>
                          </div>
                        </div>
                     </div>
                     <div class="col-sm-3">
                       <a class="btn btn-primary" 
                          ng-href="/tema/mostrar/{{tema.id}}" role="button"> 
                        Detalles &raquo;
                       </a>
                     </div>
                  </div>
                </div>
              </div>
               </div>
            </div>
   




