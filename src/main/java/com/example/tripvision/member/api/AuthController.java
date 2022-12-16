// package com.example.tripvision.member.api;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
// import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
// import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
// import org.springframework.security.oauth2.core.OAuth2AccessToken;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.validation.Valid;
// import java.net.URI;
//
// import com.example.tripvision.global.util.TokenProvider;
// import com.example.tripvision.member.dao.MemberRepository;
// import com.example.tripvision.member.dto.AuthResponse;
// import com.example.tripvision.member.dto.LoginRequest;
//
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
//
// @Slf4j
// @RestController
// @RequiredArgsConstructor
// @RequestMapping("/auth")
// public class AuthController {
//
// 	private final AuthenticationManager authenticationManager;
//
// 	private final MemberRepository memberRepository;
//
// 	private final PasswordEncoder passwordEncoder;
// 	private final TokenProvider tokenProvider;
//
// 	private final OAuth2AuthorizedClientManager authorizedClientManager;
//
// 	@GetMapping("/google/accessToken")
// 	public ResponseEntity<OAuth2AccessToken> index(Authentication authentication,
// 		HttpServletRequest servletRequest,
// 		HttpServletResponse servletResponse) {
//
//
// 		Object obj = authentication.getPrincipal();
// 		log.error(obj.toString());
// 		UserDetails userDetails = (UserDetails) obj;
// 		log.error("Authentication Value is " + userDetails.getUsername());
// 		log.error("Authentication Value is " + userDetails.getAuthorities());
// 		OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest.withClientRegistrationId("google")
// 			.principal(authentication)
// 			.attributes(attrs -> {
// 				log.error(attrs.toString());
// 				attrs.put(HttpServletRequest.class.getName(), servletRequest);
// 				attrs.put(HttpServletResponse.class.getName(), servletResponse);
// 			})
// 			.build();
//
// 		OAuth2AuthorizedClient authorizedClient = this.authorizedClientManager.authorize(authorizeRequest);
// 		OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
// 		log.error("--------- get Oauth2AccessToken");
// 		log.error(accessToken.toString());
// 		log.error("---------");
//
// 		return new ResponseEntity<>(accessToken, HttpStatus.CREATED);
// 	}
//
// 	@PostMapping("/login")
// 	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//
// 		Authentication authentication = authenticationManager.authenticate(
// 			new UsernamePasswordAuthenticationToken(
// 				loginRequest.getEmail(),
// 				loginRequest.getPassword()
// 			)
// 		);
// 		SecurityContextHolder.getContext().setAuthentication(authentication);
// 		String token = tokenProvider.createToken(authentication);
// 		return ResponseEntity.ok(new AuthResponse(token));
// 	}
//
//
//
// 	// @PostMapping("/signup")
// 	// public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
// 	// 	if(userRepository.existsByEmail(signUpRequest.getEmail())) {
// 	// 		throw new BadRequestException("Email address already in use.");
// 	// 	}
// 	//
// 	// 	// Creating user's account
// 	// 	User user = new User();
// 	// 	user.setName(signUpRequest.getName());
// 	// 	user.setEmail(signUpRequest.getEmail());
// 	// 	user.setPassword(signUpRequest.getPassword());
// 	// 	user.setProvider(AuthProvider.local);
// 	//
// 	// 	user.setPassword(passwordEncoder.encode(user.getPassword()));
// 	//
// 	// 	User result = userRepository.save(user);
// 	//
// 	// 	URI location = ServletUriComponentsBuilder
// 	// 		.fromCurrentContextPath().path("/user/me")
// 	// 		.buildAndExpand(result.getId()).toUri();
// 	//
// 	// 	return ResponseEntity.created(location)
// 	// 		.body(new ApiResponse(true, "User registered successfully@"));
// 	// }
//
// }
