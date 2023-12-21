package com.bootsample.controller.accesstocken;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bootsample.payload.AccessTokenPayload;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AccessTockenController {
    @Value("${spring.auth.host}")
    public String url;

    @Tag(name = "Issuing tokens")
    @Operation(summary = "Issuing AccessToken")
    @PostMapping(value = "/v3/auth/token")
    public Object token(@RequestBody AccessTokenPayload.Request request) throws Exception{
        
        RestTemplate restTemplate = new RestTemplate();
        
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","client_credentials");
        params.add("scope","openid");
        params.add("Accept","*/*");
        params.add("User-Agent","PostmanRuntime/7.32.3");
        params.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        headers.setBasicAuth(request.getUserName(), request.getPassWord());

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);

        ResponseEntity<AccessTokenPayload.Response> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, AccessTokenPayload.Response.class);
        //ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
    
        return new ResponseEntity<Object>(response.getBody(), HttpStatus.OK);
    }
}
