package com.acn.tutorial.rest;

import com.acn.tutorial.model.HeldDTO;
import com.acn.tutorial.service.HeldService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/helds", produces = MediaType.APPLICATION_JSON_VALUE)
public class HeldResource {

    private final HeldService heldService;

    public HeldResource(final HeldService heldService) {
        this.heldService = heldService;
    }

    @GetMapping
    public ResponseEntity<List<HeldDTO>> getAllHelds() {
        return ResponseEntity.ok(heldService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeldDTO> getHeld(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(heldService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createHeld(@RequestBody @Valid final HeldDTO heldDTO) {
        final Long createdId = heldService.create(heldDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateHeld(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final HeldDTO heldDTO) {
        heldService.update(id, heldDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteHeld(@PathVariable(name = "id") final Long id) {
        heldService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
