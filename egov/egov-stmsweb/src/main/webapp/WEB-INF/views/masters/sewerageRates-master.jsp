<!--
	eGov suite of products aim to improve the internal efficiency,transparency, 
    accountability and the service delivery of the government  organizations.
 
    Copyright (C) <2016>  eGovernments Foundation
 
	The updated version of eGov suite of products as by eGovernments Foundation 
    is available at http://www.egovernments.org
 
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    any later version.
 
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
 
    You should have received a copy of the GNU General Public License
    along with this program. If not, see http://www.gnu.org/licenses/ or 
    http://www.gnu.org/licenses/gpl.html .
 
    In addition to the terms of the GPL license to be adhered to in using this
    program, the following additional terms are to be complied with:
 
 	1) All versions of this program, verbatim or modified must carry this 
 	   Legal Notice.
 
 	2) Any misrepresentation of the origin of the material is prohibited. It 
 	   is required that all modified versions of this material be marked in 
 	   reasonable ways as different from the original version.
 
 	3) This license does not grant any rights to any user of the program 
 	   with regards to rights under trademark law for use of the trade names 
 	   or trademarks of eGovernments Foundation.
 
   	In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
-->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/taglib/cdn.tld" prefix="cdn"%>

<form:form method="post" action=""
	class="form-horizontal form-groups-bordered"
	modelAttribute="sewerageRatesMaster" id="sewerageRatesMasterform"
	cssClass="form-horizontal form-groups-bordered"
	enctype="multipart/form-data">
	<c:if test="${not empty message}">
		<div class="alert alert-danger" role="alert">
			<spring:message code="${message}"></spring:message>
			<fmt:formatDate pattern="dd-MM-yyyy" value="${existingActiveDate}" />
		</div>
	</c:if>
	<div class="panel panel-primary" data-collapsed="0">
		<span id="err-validate-effective-date" style="display: none"> <spring:message
				code='err.validate.effective.date' />
		</span> <span id="err-validate-overwritevalidate" style="display: none">
			<spring:message code='err.validate.overwrite.validate' />
		</span>
		 <span id="err-validate-amount" style="display: none"> <spring:message
				code='err.validate.monthlyrate' />
		</span>
		<div class="panel-heading">
			<div class="panel-title">
				<strong><spring:message code="title.create.monthlyRate.master" /></strong>
			</div>
		</div>
		<div class="panel-body custom-form">
			<div class="form-group">
				<label class="col-sm-3 control-label text-right"> <spring:message
						code="lbl.propertytype" /> <span class="mandatory"></span>
				</label>
				<div class="col-sm-3 add-margin">
					<form:select path="propertyType" data-first-option="false"
						id="propertyType" cssClass="form-control" required="required">
						<form:option value="">
							<spring:message code="lbl.select" />
						</form:option>
						<form:options items="${propertyType}" />
					</form:select>
					<form:errors path="propertyType" cssClass="add-margin error-msg" />
				</div>
			</div>
			<input type="hidden" id="MonthlyRate" value="${existingMonthlyRate}" />
			<div class="form-group">
				<label class="col-sm-3 control-label text-right"><spring:message
						code="lbl.monthlyrate"></spring:message> <span class="mandatory"></span></label>
				<div class="col-sm-3 add-margin">
					<input type="text" class="form-control patternvalidation"
						data-pattern="decimalvalue" maxlength="8" name="monthlyRate" autocomplete="off"
						id="monthlyRate" style="text-align: right" value="${monthlyRate}" required="required" />
					<form:errors path="monthlyRate" cssClass="add-margin error-msg"/>
				</div>
				<fmt:formatDate var="formattedEndDate" pattern="dd-MM-yyyy" value="${endDate}" />
				<input type="hidden" id="effectiveEndDate" value="${formattedEndDate}" />
				<label class="col-sm-2 control-label text-right"><spring:message
						code="lbl.effective.fromdate" /><span class="mandatory"></span></label>
				<div class="col-sm-3 add-margin">
					<form:input path="fromDate" id="fromDate"
						class="form-control datepicker" data-inputmask="'mask': 'd/m/y'" required="required"/>
					<form:errors path="fromDate" cssClass="add-margin error-msg"/>
				</div>
			</div>
		</div>
		<div class="form-group text-center">
			<input type="submit" value="Submit" class="btn btn-primary" id="submitform" />
			<a onclick="self.close()" class="btn btn-default"
				href="javascript:void(0)"><spring:message code="lbl.close" /></a>
		</div>
	</div>
</form:form>
<link rel="stylesheet" href="<cdn:url value='/resources/global/css/jquery/plugins/datatables/jquery.dataTables.min.css' context='/egi'/>"/>
<link rel="stylesheet" href="<cdn:url value='/resources/global/css/jquery/plugins/datatables/dataTables.bootstrap.min.css' context='/egi'/>">
<script
	src="<cdn:url  value='/resources/global/js/jquery/plugins/datatables/dataTables.bootstrap.js' context='/egi'/>"
	type="text/javascript"></script>
<script
	src="<cdn:url  value='/resources/js/masters/sewerageRates.js?rnd=${app_release_no}'/>"></script>
<script src="<cdn:url  value='/resources/javascript/helper.js?rnd=${app_release_no}'/>"></script>