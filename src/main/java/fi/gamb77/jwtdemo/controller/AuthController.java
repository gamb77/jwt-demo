package fi.gamb77.jwtdemo.controller;

import fi.gamb77.jwtdemo.dto.JwtResponseDTO;
import fi.gamb77.jwtdemo.dto.LoginDTO;
import fi.gamb77.jwtdemo.security.JwtProvider;
import fi.gamb77.jwtdemo.service.actions.ActionFactory;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(tags = "auth")
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider tokenProvider;

    @Autowired
    private ActionFactory actionFactory;

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> authenticateUser(@Valid @RequestBody LoginDTO login) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getName(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        actionFactory.startLoginActions(authentication);

        return ResponseEntity.ok(new JwtResponseDTO(tokenProvider.createToken(authentication)));
    }

}
