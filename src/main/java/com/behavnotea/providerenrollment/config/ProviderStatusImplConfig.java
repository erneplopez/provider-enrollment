package com.behavnotea.providerenrollment.config;

import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URL;

@Configuration
public class ProviderStatusImplConfig {
    @Bean
    public WebClient getWebClientInstance(){
        WebClient webClient= new WebClient();
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        return webClient;
    }
    @Bean
    public URL getUrl() throws Exception{
        return new URL("https://portal.flmmis.com/FLPublic/Provider_ProviderServices/Provider_Enrollment/Provider_Enrollment_EnrollmentStatus/tabId/57/Default.aspx");
    }

    @Bean
    public String getFormName(){
        return new String("Form");
    }
    @Bean
    public String getNameInputName(){
        return new String("dnn:ctr369:EnrollmentSearchPage:SearchPage:CriteriaPanel:_ctl2:_ctl0:ETN:mb_ETN");
    }
    @Bean
    public String getAtnInputName(){
        return new String("dnn:ctr369:EnrollmentSearchPage:SearchPage:CriteriaPanel:_ctl2:_ctl1:Name:mb_Name");
    }
    @Bean
    public String getAnchorHref(){
        return new String("javascript:executingPostBack=false;__doPostBack('dnn$ctr369$EnrollmentSearchPage$SearchPage$CriteriaPanel$_ctl2$_ctl1$SearchButton','')");
    }
}
