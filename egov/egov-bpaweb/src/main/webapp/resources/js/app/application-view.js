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
jQuery(document).ready(function() {
	
	$( ".serviceType" ).trigger( "change" );
	$( ".applicationAmenity" ).trigger( "change" );
	
	var seviceTypeName = $("#serviceType").val();
	$('.show-hide').hide();
	if('Change in occupancy' == seviceTypeName){
		$('.changeInOccupancyArea').show();
	} else if('Alteration' == seviceTypeName){
		$('.alterationInArea').show();
	} else if('Adding of Extension' == seviceTypeName){
		$('.additionInArea').show();
	} else if('Permission for Temporary hut or shed' == seviceTypeName){
		$('.noofhutorshed').show();
	} else {
		$('.totalPlintArea').show();
	}
	
	loadAmenities();
function loadAmenities(){
		var amenities = [];
		if($( "#serviceType" ).val() == 'Permission for Temporary hut or shed'){
			amenities.push('Permission for Temporary hut or shed');
		}
		var amenityDesc = $("#applicationAmenity").val().split(',');
		$.each(amenityDesc, function(index, amenityDesc) {
			amenities.push(amenityDesc);
		});
		
		var result="";
		$.each(amenities, function(idx, value){            
			//console.log('is even?', $(this).text(), idx, );
			var isEven=(parseInt(idx)%2 === 0);
			if(isEven){
				result= result+ (result?"</div><div class='row add-border'>":"<div class='row add-border'>");
			}
			result=result+getTemplateComplie(value, isEven);
        });
		result=result+"</div>";
		$('#amenitiesOuptuts').html(result);
	}
	
	function getTemplateComplie(value, isFirstPosition){
		var templateStr="";
		
		switch(value) {
		    case "Well":
		        templateStr=$('#well-view-template').html();
		        break;
		    case "Compound Wall":
		    	templateStr=$('#compound-view-template').html();
		        break;
		    case "Shutter or Door Conversion/Erection under rule 100 or 101":
		    	templateStr=$('#shutter-view-template').html();
		        break;
		    case "Roof Conversion under rule 100 or 101":
		    	templateStr=$('#roof-view-template').html();
		        break;
		    case "Tower Construction":
		    	templateStr=$('#tower-view-template').html();
		        break;
		    case "Pole Structures":
		    	templateStr=$('#poles-view-template').html();
		        break;
		    case "Permission for Temporary hut or shed":
		    	templateStr=$('#sheds-view-template').html();
		        break;
		}
		
		return templateStr;
	}
	
	
});
