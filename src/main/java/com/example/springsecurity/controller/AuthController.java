package com.example.springsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AuthController {


   private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

    public AuthController(OAuth2AuthorizedClientService oAuth2AuthorizedClientService) {
        this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
    }

    @GetMapping("/login")
   public String login(){
        return "login";
    }

  @GetMapping("/oauth2LoginSuccess")
    public String getOauth2LoginInfo(Model model, @AuthenticationPrincipal OAuth2AuthenticationToken auth2AuthenticationToken){

        //fetch client & user details
      System.out.println(auth2AuthenticationToken.getAuthorizedClientRegistrationId());
      System.out.println(auth2AuthenticationToken.getName());

      //fetch user info
      OAuth2User user = auth2AuthenticationToken.getPrincipal();
      System.out.println("userId:" + user.getName());
      System.out.printf("Email: %s%n", user.getAttributes().get("email"));

      //if you want to obtain user's auth token valule
      OAuth2AuthorizedClient client = oAuth2AuthorizedClientService
              .loadAuthorizedClient(auth2AuthenticationToken.getAuthorizedClientRegistrationId(),
                      auth2AuthenticationToken.getName());
      System.out.printf("Toke value: %s", client.getAccessToken().getTokenValue());
      model.addAttribute("name", user.getAttribute("name"));
      return "home";
  }
    @GetMapping("/formLoginSuccess")
    public String getFormLoginInfo(Model model, @AuthenticationPrincipal Authentication authentication) {
        // In Oauth based flow you get Oauth2User (in form-based login flow you get UserDetails as principal)
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        model.addAttribute("name", userDetails.getUsername());
        return "home";

    }}
