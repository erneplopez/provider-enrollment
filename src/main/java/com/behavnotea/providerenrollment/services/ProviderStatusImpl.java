package com.behavnotea.providerenrollment.services;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProviderStatusImpl implements ProviderStatus{

    private WebClient webClient;
    private URL url;
    private String formName;
    private String nameInputName;
    private String atnInputName;
    private String anchorHref;
    public ProviderStatusImpl(WebClient webClient,
                              URL url,
                              @Qualifier("getFormName")String formName,
                              @Qualifier("getNameInputName")String nameInputName,
                              @Qualifier("getAtnInputName")String atnInputName,
                              @Qualifier("getAnchorHref")String anchorHref) {
        this.webClient = webClient;
        this.url = url;
        this.formName = formName;
        this.nameInputName = nameInputName;
        this.atnInputName = atnInputName;
        this.anchorHref=anchorHref;
    }

    public Map get(String lastName, String atn){
        Map<String,String> providerStatus=new HashMap();
        try{
            HtmlPage htmlPage=this.getHTMLPage();
            setHtmlFormFields(htmlPage,lastName,atn);
            HtmlPage responseHtmlPage=this.submitForm(htmlPage);
            String responseHtmlPageAsText=convertResponsePageToText(responseHtmlPage);
        }catch(Exception e){

        }

        return providerStatus;
    }
    private HtmlPage getHTMLPage()throws Exception{
        HtmlPage htmlPage=webClient.getPage(url);
        return htmlPage;
    }
    private void setHtmlFormFields(HtmlPage htmlPage,String lastName,String atn)throws Exception{
        HtmlForm form=htmlPage.getFormByName(formName);
        HtmlTextInput ATNField = form.getInputByName(nameInputName);
        HtmlTextInput lastNameField = form.getInputByName(atnInputName);
        ATNField.setValueAttribute(atn);
        lastNameField.setValueAttribute(lastName);
    }
    private HtmlPage submitForm(HtmlPage htmlPage) throws Exception{
        HtmlAnchor button = htmlPage.getAnchorByHref(anchorHref);
        HtmlPage responseHtmlPage = button.click();
        return responseHtmlPage;
    }
    private String convertResponsePageToText(HtmlPage htmlPage){
        return htmlPage.asText();
    }
}
