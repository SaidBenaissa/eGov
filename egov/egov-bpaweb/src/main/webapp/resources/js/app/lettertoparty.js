/*
 * eGov suite of products aim to improve the internal efficiency,transparency,
 *    accountability and the service delivery of the government  organizations.
 *
 *     Copyright (C) <2017>  eGovernments Foundation
 *
 *     The updated version of eGov suite of products as by eGovernments Foundation
 *     is available at http://www.egovernments.org
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program. If not, see http://www.gnu.org/licenses/ or
 *     http://www.gnu.org/licenses/gpl.html .
 *
 *     In addition to the terms of the GPL license to be adhered to in using this
 *     program, the following additional terms are to be complied with:
 *
 *         1) All versions of this program, verbatim or modified must carry this
 *            Legal Notice.
 *
 *         2) Any misrepresentation of the origin of the material is prohibited. It
 *            is required that all modified versions of this material be marked in
 *            reasonable ways as different from the original version.
 *
 *         3) This license does not grant any rights to any user of the program
 *            with regards to rights under trademark law for use of the trade names
 *            or trademarks of eGovernments Foundation.
 *
 *   In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
 */
 
jQuery(document).ready(function($) {
	
	$("#buttonCreateSubmit").click(function(e){ 
		var chkbxLength = $('.requested:checked').length;
		if(chkbxLength <= 0){
			bootbox.alert('Please select atleast one document.');
			return false;
		}
		validateDate();
		return true;
});  
	
	$('#sentDate').on('changeDate', function(e) {
		validateDate();
	});
	$('#replyDate').on('changeDate', function(e) {
		validateReplyDate();
	});

	
});
	function getUrlToPring() {
		var url = '/bpa/lettertoparty/lettertopartyprint?pathVar='+$('#lettertoParty').val();
		$('#lettertoPartyform').attr('method', 'get');    
		$('#lettertoPartyform').attr('action', url);
		window.location = url;
	}
	function validateReplyDate() {   
		if ($('#sentDate') && $('#sentDate').val() && $('#replyDate') && $('#replyDate').val()) {
			var sentdateStr = $('#sentDate').val();
			var sentdateDateTime = moment(sentdateStr,["DD/MM/YYYY"]);
			var replyDateStr = $('#replyDate').val();
			var replyDateTime = moment(replyDateStr,["DD/MM/YYYY"]);
			if ( sentdateDateTime > replyDateTime) {
				bootbox.alert('LP Reply Date should be greater than the Letter to party sent Date');
				$('#replyDate').val('');
			}
		}   
	}	
	
	function validateDate() {   
		if ($('#sentDate') && $('#sentDate').val() && $('#letterDate') && $('#letterDate').val()) {
			var sentdateStr = $('#sentDate').val();
			var sentdateDateTime = moment(sentdateStr,["DD/MM/YYYY"]);
			var letterDateStr = $('#letterDate').val();
			var letterDateTime = moment(letterDateStr,["DD/MM/YYYY"]);
			if (letterDateTime > sentdateDateTime) {
				bootbox.alert('Letter to party sent Date  should be greater than the LP Date');
				$('#sentDate').val('');
			}
		}
	}

