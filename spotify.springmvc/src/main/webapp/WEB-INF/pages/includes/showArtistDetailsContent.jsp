<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
 <div class="panel panel-default">
      
      <div class="panel-heading">
                    <h1>
              <small><span aria-hidden="true" class="glyphicon glyphicon-user"></span>  <spring:message code="showArtistDetails.panel.header.title" /></small>
              <mark> a rellenar<!-- ${findFavoriteFormBean.mapMsgs['formFindFavoriteNameMsgError']} --></mark>
             <!-- <a href="">
                  <span class="glyphicon glyphicon-star-empty" aria-hidden="true" title="Marcar Artista Favorito"></span>
              </a>-->
            
                           <button onclick="crearContenidoCapaCorreoOrdinario('Intérprete','Pink Floyd','/rusuariofavoritos/0k17h0D3J5VfsdmQ1iZtE9/1/new','0k17h0D3J5VfsdmQ1iZtE9' );" class="btn-link" type="button" id="btnGuardarCorreo">
                  <span aria-hidden="true" class="glyphicon glyphicon-star-empty"></span>
             </button>
                         </h1>
          </div>

        <div class="panel-body">

          <div class="row">
            <div class="col-md-4">
              <p class="text-left">
                <img alt="Imagen Pink Floyd" class="img-responsive" src="https://i.scdn.co/image/b954149fed21dcbafe1cee4c30454eb934c384ee"><br>
                <a title="Escuchar en Spotify" target="_blank" href="https://open.spotify.com/artist/0k17h0D3J5VfsdmQ1iZtE9">
                                      <img alt="Spotify" class="img-responsive" src="/images/1c538cc_logoSpotify_1.png">
                                  </a>
              </p>
            </div>
            <div class="col-md-8">
              <div class="panel panel-default">
  <div class="table-responsive">
    <table class="table table-striped table-condensed">
                                                <tbody><tr>
            <td>
              <a href="/album/mostrar/0fXAlQ9wTG2glNJvZEkBZc">
                <img width="64" height="64" title="The Endless River" alt="Imagen The Endless River" src="https://i.scdn.co/image/2846edccb21549e6e76422557ffdce538c63229e">
              </a>
            </td>
            <td>The Endless River</td>
          </tr>
                                                <tr>
            <td>
              <a href="/album/mostrar/3tF21h9x3rP8G8C3S7hv3S">
                <img width="64" height="64" title="Darkside, Tom Stoppard incorporating The Dark Side of The Moon by Pink Floyd" alt="Imagen Darkside, Tom Stoppard incorporating The Dark Side of The Moon by Pink Floyd" src="https://i.scdn.co/image/9a5ce7d2b418db65097c08c4a6a61def8758c9d1">
              </a>
            </td>
            <td>Darkside, Tom Stoppard incorporating The Dark Side of The Moon by Pink Floyd</td>
          </tr>
                                                <tr>
            <td>
              <a href="/album/mostrar/3NQJAg6DHRY2x2GsRT3WwQ">
                <img width="64" height="64" title="Pulse" alt="Imagen Pulse" src="https://i.scdn.co/image/e713eea64698fd5ce9cb111b7e2b535fa5db33f2">
              </a>
            </td>
            <td>Pulse</td>
          </tr>
                                                <tr>
            <td>
              <a href="/album/mostrar/1J0NAouKjVtJKHDHzZcaT5">
                <img width="64" height="64" title="The Division Bell [2011 - Remaster] (2011 Remastered Version)" alt="Imagen The Division Bell [2011 - Remaster] (2011 Remastered Version)" src="https://i.scdn.co/image/cd201cdf59c5a075a31e23c3f1752da2ecafc608">
              </a>
            </td>
            <td>The Division Bell [2011 - Remaster] (2011 Remastered Version)</td>
          </tr>
                                                <tr>
            <td>
              <a href="/album/mostrar/5pGiFKbY49I0srddXPIBck">
                <img width="64" height="64" title="Delicate Sound Of Thunder" alt="Imagen Delicate Sound Of Thunder" src="https://i.scdn.co/image/2fe2624c2663371b8c8da9b6f312314311e55657">
              </a>
            </td>
            <td>Delicate Sound Of Thunder</td>
          </tr>
          </tbody></table>
  </div>
</div>

                              <a role="button" class="btn btn-info" href="/artista/mostrar/0k17h0D3J5VfsdmQ1iZtE9/50">
                  Más resultados »
                </a>
                          </div>
          </div>
                
      </div>
    </div>
