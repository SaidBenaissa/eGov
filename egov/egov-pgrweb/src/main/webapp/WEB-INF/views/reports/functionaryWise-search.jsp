<%--
  ~ eGov suite of products aim to improve the internal efficiency,transparency,
  ~    accountability and the service delivery of the government  organizations.
  ~
  ~     Copyright (C) <2015>  eGovernments Foundation
  ~
  ~     The updated version of eGov suite of products as by eGovernments Foundation
  ~     is available at http://www.egovernments.org
  ~
  ~     This program is free software: you can redistribute it and/or modify
  ~     it under the terms of the GNU General Public License as published by
  ~     the Free Software Foundation, either version 3 of the License, or
  ~     any later version.
  ~
  ~     This program is distributed in the hope that it will be useful,
  ~     but WITHOUT ANY WARRANTY; without even the implied warranty of
  ~     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  ~     GNU General Public License for more details.
  ~
  ~     You should have received a copy of the GNU General Public License
  ~     along with this program. If not, see http://www.gnu.org/licenses/ or
  ~     http://www.gnu.org/licenses/gpl.html .
  ~
  ~     In addition to the terms of the GPL license to be adhered to in using this
  ~     program, the following additional terms are to be complied with:
  ~
  ~         1) All versions of this program, verbatim or modified must carry this
  ~            Legal Notice.
  ~
  ~         2) Any misrepresentation of the origin of the material is prohibited. It
  ~            is required that all modified versions of this material be marked in
  ~            reasonable ways as different from the original version.
  ~
  ~         3) This license does not grant any rights to any user of the program
  ~            with regards to rights under trademark law for use of the trade names
  ~            or trademarks of eGovernments Foundation.
  ~
  ~   In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
  --%>

<%@ page contentType="text/html" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="/WEB-INF/taglib/cdn.tld" prefix="cdn" %>
<div class="row"> 
	<div class="col-md-12">
		<div class="" data-collapsed="0">
			<c:if test="${not empty message}">
				<div class="alert alert-success" role="alert">${message}</div>
			</c:if>
			<div class="panel-body">
				<form:form id="functionarywiseReportForm" method="post" class="form-horizontal form-groups-bordered"	
				modelAttribute="reportHelper">
					<div class="panel panel-primary" data-collapsed="0">
						<div class="panel-heading">
							<div class="panel-title">
								<strong><spring:message code="lbl.functionaryWiseReport.heading.search" /></strong>
							</div>
						</div>
						<div class="panel-body custom-form">
							<div class="form-group">
								<label for="field-1" class="col-sm-3 control-label"><spring:message code="lbl.period"/></label>
								<div class="col-sm-6 add-margin">
									<select name="complaintDateType" id="when_date" class="form-control" data-first-option="false" 
									onchange="showChangeDropdown(this);">
										<option value=""><spring:message code="lbl.select"/></option>
										<option value="all" selected><spring:message code="lbl.all"/></option>
										<option value="lastsevendays" ><spring:message code="lbl.last.seven.days"/></option>
										<option value="lastthirtydays"><spring:message code="lbl.last.thirty.days"/></option>
										<option value="lastninetydays"><spring:message code="lbl.last.ninty.days"/></option>
										<option value="custom" data-show=".complaintdur"><spring:message code="lbl.custom"/></option>
									</select>
									<input type="hidden" id="usrid" name="usrid" value="${usrid}"/> 
									<input type="hidden" id="status" name="status" value="${status}"/> 
								</div>
							</div>
						</div>
						<div class="form-group drophide complaintdur" style="display:none;">
							<div class="form-group">
								<label class="col-sm-3 control-label"><spring:message code="lbl.complaintTypeWiseReport.complaintFromDate" /> 
								</label>
								<div class="col-sm-2 add-margin">
										<input type="text" name="reportFromDate" class="form-control datepicker checkdate"
									id="start_date" data-inputmask="'mask': 'd/m/y'"
									placeholder="<spring:message code='lbl.fromDate'/>" required="required"/>
								</div>
								<label class="col-sm-3 control-label"><spring:message code="lbl.complaintTypeWiseReport.complaintToDate" /></label>
								<div class="col-sm-2 add-margin">
									<input type="text" name="reportToDate" class="form-control datepicker checkdate" id="end_date" 
									data-inputmask="'mask': 'd/m/y'" placeholder="<spring:message code='lbl.toDate'/>" />
								</div>
							</div>
						</div>	
						<div class="row">
							<div class="text-center">
								<button type="button" id="functionaryReportSearch" class="btn btn-primary">
									<spring:message code="lbl.search" /></button>
									<a href="javascript:void(0)" class="btn btn-default"
										onclick="self.close()"> <spring:message code="lbl.close" /></a>
							</div>
						</div>
					</div>
				</form:form>
			</div>
			<div class="row display-hide report-section">
			<div class="col-md-6 col-xs-6 table-header"><spring:message code="lbl.functionaryWiseReport.resultHeader" /></div>
				<div class="col-md-12 form-group">
					<table class="table table-bordered datatable dt-responsive table-hover" id="functionaryReport-table">
						<thead>
							<tr>
								<th rowspan="2" style="vertical-align: bottom"></th>
								<th colspan="5" style="text-align: center"><spring:message code="lbl.report.status"/></th>
								<th colspan="2" style="text-align: center"><spring:message code="lbl.report.sla"/></th>
								<th rowspan="2" style="vertical-align: bottom"></th>
							</tr>
							<tr>
								<th></th>
								<th></th>
								<th></th>
								<th></th>
								<th></th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tfoot id="report-footer">
							<tr>
								<td><b><spring:message code="lbl.pagetotal"/></b></td>
						    	<td></td>
						    	<td></td>
						    	<td></td>
						    	<td></td>
						    	<td></td>
						     	<td></td>
						     	<td></td>
						     	<td></td>
							</tr>
						</tfoot>
					</table>
					<table class="table table-bordered datatable dt-responsive table-hover" id="compReport-table"></table>
				</div>
			</div>
			<div id="report-backbutton" class="col-xs-12 text-center">
				<div class="form-group">
					<button class="btn btn-primary" id="backButton" ><spring:message code="lbl.back"/></button>
				</div>
			</div>
		</div>
	</div>
</div>

<link rel="stylesheet" href="<cdn:url  value='/resources/global/js/jquery/plugins/datatables/responsive/css/datatables.responsive.css' context='/egi'/>">
<link rel="stylesheet" href="<cdn:url value='/resources/global/css/jquery/plugins/datatables/jquery.dataTables.min.css' context='/egi'/>"/>
<link rel="stylesheet" href="<cdn:url value='/resources/global/css/jquery/plugins/datatables/dataTables.bootstrap.min.css' context='/egi'/>">
<script type="text/javascript" src="<cdn:url  value='/resources/global/js/jquery/plugins/datatables/jquery.dataTables.min.js' context='/egi'/>"></script>
<script type="text/javascript" src="<cdn:url  value='/resources/global/js/jquery/plugins/datatables/dataTables.bootstrap.js' context='/egi'/>"></script>
<script type="text/javascript" src="<cdn:url  value='/resources/global/js/jquery/plugins/datatables/responsive/js/datatables.responsive.js' context='/egi'/>"></script>
<script type="text/javascript" src="<cdn:url  value='/resources/global/js/jquery/plugins/datatables/dataTables.tableTools.js' context='/egi'/>"></script>
<script type="text/javascript" src="<cdn:url  value='/resources/global/js/jquery/plugins/datatables/TableTools.min.js' context='/egi'/>"></script>
<script type="text/javascript" src="<cdn:url  value='/resources/global/js/bootstrap/bootstrap-datepicker.js' context='/egi'/>"></script>
<script type="text/javascript" src="<cdn:url  value='/resources/js/app/functionarywiseReport.js?rnd=${app_release_no}'/>"></script>
<style>
	.table thead tr th {
		border-bottom: none;
		background: #f2851f;
		color: #fff;
		font-weight: normal;
	}
</style>