/*
 * eGov suite of products aim to improve the internal efficiency,transparency,
 *    accountability and the service delivery of the government  organizations.
 *
 *     Copyright (C) <2015>  eGovernments Foundation
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
package org.egov.bpa.web.controller.application;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.egov.bpa.application.entity.BpaApplication;
import org.egov.bpa.application.service.ApplicationBpaService;
import org.egov.bpa.application.service.collection.GenericBillGeneratorService;
import org.egov.bpa.service.BpaDemandService;
import org.egov.bpa.utils.BpaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/application")
public class CollectFeesController {
	
	private static final String COLLECT_ERROR_PAGE="collect-failure";

	@Autowired
    private  ApplicationBpaService applicationBpaService;
	@Autowired
    private  GenericBillGeneratorService genericBillGeneratorService;
	@Autowired
    private  BpaDemandService bpaDemandService;
   
    @RequestMapping(value = "/bpageneratebill/{applicationCode}", method = GET)
    public String showCollectFeeForm(final Model model, @PathVariable final String applicationCode) {
    	BpaApplication application=applicationBpaService.findByApplicationNumber(applicationCode);
    	Boolean bpaDuePresent=bpaDemandService.checkAnyTaxIsPendingToCollect(application);
    	if(application.getStatus()!=null && application.getStatus().getCode().equals(BpaConstants.APPLICATION_STATUS_APPROVED) && bpaDuePresent){
    	return genericBillGeneratorService.generateBillAndRedirectToCollection(application, model);
    	}
    	else{
    		model.addAttribute("message", "No Amount to Collect");
    		return COLLECT_ERROR_PAGE;
    	}
    }

}