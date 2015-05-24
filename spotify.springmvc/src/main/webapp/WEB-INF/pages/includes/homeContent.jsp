<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <div class="jumbotron">

      <h1>¡Bienvenido!</h1>
      <p>${attributoInyectadoDesdeElProperties}  Esta aplicación pretende ser un ejemplo de uso de varias técnicas:      
        </p><ul>
          <li>Por un lado, accede a datos externos empleando la
              <a title="Web API Endpoint Reference" target="_blank" href="https://developer.spotify.com/web-api/endpoint-reference/">API REST de Spotify</a></li>                
          <li>Por otro accede a datos locales a los que se accede empleando la capa de
          abstracción <a title="Doctrine Database Abstraction Layer" target="_blank" href="http://www.doctrine-project.org/projects/dbal.html">Doctrine DBAL</a></li>
          <li>Además, también se emplea el framework HTML, CSS y JS <a title="Bootstrap framework" target="_blank" href="http://getbootstrap.com/">Bootstrap</a></li>
        </ul>
      <p></p>

      <p><a role="button" href="" class="btn btn-primary btn-lg">Seguir leyendo</a></p>


    </div>
    
    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2><span aria-hidden="true" class="glyphicon glyphicon-user"></span> Artistas</h2>
          <p>A través de esta opción puede obtener información de sus artistas preferidos,
              escuchar sus trabajos y marcarlos como favoritos para poder recuperarlos cuando desee.
          </p>
          <p><a role="button" href="${pageContext.request.contextPath}/${homeViewBean.mapMsgs['buttonFindArtistUrl']}" class="btn btn-primary">Buscar Artistas »</a></p>
        </div>
        <div class="col-md-4">
          <h2><span aria-hidden="true" class="glyphicon glyphicon-folder-open"></span> Álbumes
              <a target="_blank" href="http://lema.rae.es/dpd/srv/search?id=Kj74deVh7D6N8n0ZkD"><sup>*</sup></a></h2>
          <p>También podrá realizar búsquedas a traves de los nombre de los álbumes que más
              le gusten, ver la información del mismo y guardar sus álbumes favoritos.
          </p>
          <p><a role="button" href="${pageContext.request.contextPath}/${homeViewBean.mapMsgs['buttonFindAlbumUrl']}"  class="btn btn-primary">Buscar Álbumes »</a></p>
        </div>
        <div class="col-md-4">
          <h2><span aria-hidden="true" class="glyphicon glyphicon-music"></span> Temas</h2>
          <p>De igual forma, podrá buscar toda la información relativa a sus temas favoritos,
              así como escucharlos desde aquí mismo.
          </p>
          <p><a role="button" href="${pageContext.request.contextPath}/${homeViewBean.mapMsgs['buttonFindTrackUrl']}" class="btn btn-primary">Buscar Temas »</a></p>
        </div>
      </div>

    </div> 
