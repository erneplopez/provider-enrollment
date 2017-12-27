package com.behavnotea.providerenrollment.thirdParty;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.html.HTMLAnchorElement;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HTMLUnitTestIT {
    private WebClient webClient;
    private URL url;
    private HtmlPage htmlPage;
    @Before
    public void setUp() throws Exception{
        webClient=new WebClient();
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        url=new URL("https://portal.flmmis.com/FLPublic/Provider_ProviderServices/Provider_Enrollment/Provider_Enrollment_EnrollmentStatus/tabId/57/Default.aspx");
        htmlPage=webClient.getPage(url);

    }
    @Test
    public void getWebPageTitle() throws Exception{

        Assert.assertEquals("Enrollment Status | Florida Medicaid Web Portal",htmlPage.getTitleText());
    }

    @Test
    public void submitWebPageForm() throws Exception{

        HtmlForm form=htmlPage.getFormByName("Form");
        HtmlAnchor button = htmlPage.getAnchorByHref("javascript:executingPostBack=false;__doPostBack('dnn$ctr369$EnrollmentSearchPage$SearchPage$CriteriaPanel$_ctl2$_ctl1$SearchButton','')");
        HtmlTextInput ATNField = form.getInputByName("dnn:ctr369:EnrollmentSearchPage:SearchPage:CriteriaPanel:_ctl2:_ctl0:ETN:mb_ETN");
        HtmlTextInput lastNameField = form.getInputByName("dnn:ctr369:EnrollmentSearchPage:SearchPage:CriteriaPanel:_ctl2:_ctl1:Name:mb_Name");
        ATNField.setValueAttribute("");
        lastNameField.setValueAttribute("");

        HtmlPage responsePage = button.click();
        String responsePageString= responsePage.asText();

        Assert.assertTrue(responsePageString.contains("ATN is required"));

    }
}






