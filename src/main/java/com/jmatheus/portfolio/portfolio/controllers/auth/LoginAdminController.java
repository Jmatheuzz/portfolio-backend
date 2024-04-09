package com.jmatheus.portfolio.portfolio.controllers.auth;

import com.jmatheus.portfolio.portfolio.responses.ResponseOk;
import com.jmatheus.portfolio.portfolio.services.auth.LoginAdminService;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.auth.LoginDto;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.auth.LoggedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginAdminController {
    @Autowired
    private LoginAdminService loginAdminService;

    @PostMapping("/login-admin")
    public ResponseEntity<ResponseOk> execute(@RequestBody LoginDto data) {
        LoggedDto logged = loginAdminService.execute(data);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseOk("Success", logged));
    }


}
