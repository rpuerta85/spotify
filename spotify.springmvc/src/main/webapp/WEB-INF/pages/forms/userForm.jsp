<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="panel panel-default">
		<div class="panel-body">
			<form class="form-horizontal" action="/admin/usuario/1/update"
				method="post" name="miwspotifybundle_usuario">
				<input type="hidden" value="PUT" name="_method">
				<div id="miwspotifybundle_usuario">
					<div class="form-group">
						<label for="miwspotifybundle_usuario_username"
							class="col-sm-2 control-label required">
							<spring:message code="form.new.user.inputText.user" /></label>
						<div class="col-sm-10">
							<input type="text" value="${newUserFormBean.mapMsgs['formNewUserInputTextUsernameValue']}" class="form-control"
								required="required" name="miwspotifybundle_usuario[username]"
								id="miwspotifybundle_usuario_username">
						</div>
					</div>
					<div class="form-group">
						<label for="miwspotifybundle_usuario_password"
							class="col-sm-2 control-label required"><spring:message code="form.new.user.inputText.password" /></label>
						<div class="col-sm-10">
							<input type="password" class="form-control" required="required"
								name="miwspotifybundle_usuario[password]"
								id="miwspotifybundle_usuario_password" value="${newUserFormBean.mapMsgs['formNewUserInputTextPasswordValue']}">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2"></div>
						<div class="col-sm-10">
							<div class="checkbox">
								<label><input type="checkbox" checked="checked"
									value="${newUserFormBean.mapMsgs['formNewUserInputTextIsAdminValue']}" name="miwspotifybundle_usuario[isAdmin]"
									id="miwspotifybundle_usuario_isAdmin"> <spring:message
										code="form.new.user.inputText.administrador" /> </label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2"></div>
						<div class="col-sm-10">
							<div class="checkbox">
								<label><input type="checkbox" checked="checked"
									value="${newUserFormBean.mapMsgs['formNewUserInputTextIsEnabledValue']}" name="miwspotifybundle_usuario[isActive]"
									id="miwspotifybundle_usuario_isActive"> <spring:message
										code="form.new.user.inputText.activo" /> </label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="miwspotifybundle_usuario_email"
							class="col-sm-2 control-label required"><spring:message code="form.new.user.inputText.mail" /></label>
						<div class="col-sm-10">
							<input type="email" value="${newUserFormBean.mapMsgs['formNewUserInputTextEmailValue']}" class="form-control"
								required="required" name="miwspotifybundle_usuario[email]"
								id="miwspotifybundle_usuario_email">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label required"><spring:message code="form.new.user.inputText.createtime" /></label>
						<div class="col-sm-10">
							<div class="form-inline" id="miwspotifybundle_usuario_createTime">
								<select class="form-control"
									name="miwspotifybundle_usuario[createTime][date][month]"
									id="miwspotifybundle_usuario_createTime_date_month"><option
										value="1">Jan</option>
									<option value="2">Feb</option>
									<option value="3">Mar</option>
									<option value="4">Apr</option>
									<option value="5">May</option>
									<option value="6">Jun</option>
									<option value="7">Jul</option>
									<option value="8">Aug</option>
									<option value="9">Sep</option>
									<option value="10">Oct</option>
									<option value="11">Nov</option>
									<option selected="selected" value="12">Dec</option></select><select
									class="form-control"
									name="miwspotifybundle_usuario[createTime][date][day]"
									id="miwspotifybundle_usuario_createTime_date_day"><option
										value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option selected="selected" value="30">30</option>
									<option value="31">31</option></select><select class="form-control"
									name="miwspotifybundle_usuario[createTime][date][year]"
									id="miwspotifybundle_usuario_createTime_date_year"><option
										value="2010">2010</option>
									<option value="2011">2011</option>
									<option value="2012">2012</option>
									<option value="2013">2013</option>
									<option selected="selected" value="2014">2014</option>
									<option value="2015">2015</option>
									<option value="2016">2016</option>
									<option value="2017">2017</option>
									<option value="2018">2018</option>
									<option value="2019">2019</option>
									<option value="2020">2020</option></select> &nbsp; <select
									class="form-control"
									name="miwspotifybundle_usuario[createTime][time][hour]"
									id="miwspotifybundle_usuario_createTime_time_hour"><option
										value="0">00</option>
									<option value="1">01</option>
									<option value="2">02</option>
									<option value="3">03</option>
									<option value="4">04</option>
									<option value="5">05</option>
									<option value="6">06</option>
									<option value="7">07</option>
									<option value="8">08</option>
									<option value="9">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option selected="selected" value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option></select>:<select class="form-control"
									name="miwspotifybundle_usuario[createTime][time][minute]"
									id="miwspotifybundle_usuario_createTime_time_minute"><option
										value="0">00</option>
									<option value="1">01</option>
									<option value="2">02</option>
									<option value="3">03</option>
									<option value="4">04</option>
									<option value="5">05</option>
									<option value="6">06</option>
									<option value="7">07</option>
									<option value="8">08</option>
									<option value="9">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option selected="selected" value="30">30</option>
									<option value="31">31</option>
									<option value="32">32</option>
									<option value="33">33</option>
									<option value="34">34</option>
									<option value="35">35</option>
									<option value="36">36</option>
									<option value="37">37</option>
									<option value="38">38</option>
									<option value="39">39</option>
									<option value="40">40</option>
									<option value="41">41</option>
									<option value="42">42</option>
									<option value="43">43</option>
									<option value="44">44</option>
									<option value="45">45</option>
									<option value="46">46</option>
									<option value="47">47</option>
									<option value="48">48</option>
									<option value="49">49</option>
									<option value="50">50</option>
									<option value="51">51</option>
									<option value="52">52</option>
									<option value="53">53</option>
									<option value="54">54</option>
									<option value="55">55</option>
									<option value="56">56</option>
									<option value="57">57</option>
									<option value="58">58</option>
									<option value="59">59</option></select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2"></div>
						<div class="col-sm-10">
							<button class="btn" name="miwspotifybundle_usuario[submit]"
								id="miwspotifybundle_usuario_submit" type="submit">
								<spring:message code="form.new.user.button.submit.name" /></button>
						</div>
					</div>
					<input type="hidden"
						value="c0UJLsUldMSKWYEmv3JriNMzs9NnVsaQ0EORm-SOeKA"
						class="form-control" name="miwspotifybundle_usuario[_token]"
						id="miwspotifybundle_usuario__token">
				</div>
			</form>

			<table class="record_actions">
				<tbody>
					<tr>
						<td><a href="/admin/usuario/" title="Listado de Usuarios">
								<span aria-hidden="true" class="glyphicon glyphicon-arrow-left">&nbsp;</span>
						</a></td>
						<td><form class="form-horizontal"
								action="/admin/usuario/1/delete" method="post" name="form">
								<input type="hidden" value="DELETE" name="_method">
								<div id="form">
									<div class="form-group">
										<div class="col-sm-2"></div>
										<div class="col-sm-10">
											<button class="btn" name="form[submit]" id="form_submit"
												type="submit"><spring:message code="form.new.user.button.delete.name" /></button>
										</div>
									</div>
									<input type="hidden"
										value="DC4EMqY5klr9R8NJ92det-IQqb49KZObP6B3xn_gCVk"
										class="form-control" name="form[_token]" id="form__token">
								</div>
							</form></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>