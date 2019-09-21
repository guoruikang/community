package com.grk.community.cmt.controller;

import com.grk.community.cmt.dto.AccessTokenDTO;
import com.grk.community.cmt.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OAuthController {

    @Autowired
    private GithubProvider githubProvider;
    @GetMapping("/callback")

    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("8292565902432edec292");
        accessTokenDTO.setClient_secret("f460037f3a60da40a77506df7302378494530434");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);

        githubProvider.getAccessToken(accessTokenDTO);

        return "index";

    }
}
