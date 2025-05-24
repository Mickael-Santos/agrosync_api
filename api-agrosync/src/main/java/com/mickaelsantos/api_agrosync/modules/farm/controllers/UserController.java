package com.mickaelsantos.api_agrosync.modules.farm.controllers;

@RestController
@RequestMapping("/api/v1/farm")
public class UserController {
    @Autowired
    private CreateFarmUseCase createFarmUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody CreateFarmRequestDto request) {
        try {
            CreateFarmResponseDto response = createFarmUseCase.execute(request);
            return ResponseEntity.ok().body(response);
        } catch (UserFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
