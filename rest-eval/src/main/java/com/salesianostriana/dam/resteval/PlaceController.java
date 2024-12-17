package com.salesianostriana.dam.resteval;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place/")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService service;

    @GetMapping
    public ListGetPlaceDto getAll() {
        return ListGetPlaceDto.of(
                service.getAll()
        );
    }

    @GetMapping("{id}")
    public Place getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<Place> create(
            @RequestBody CreatePlaceDto dto
    ) {
        return ResponseEntity.status(201)
                .body(
                        service.create(dto.toPlace())
                );
    }

    @PutMapping("{id}")
    public Place edit(@PathVariable Long id,
                      @RequestBody CreatePlaceDto dto) {
        return service.edit(id, dto.toPlace());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(
            @PathVariable Long id
    ) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}/tag/add/{tag}")
    public Place addTag(
            @PathVariable Long id,
            @PathVariable String tag
    ) {
        return service.addTagToPlace(id, tag);
    }

    @PutMapping("{id}/tag/del/{tag}")
    public Place delTag(
            @PathVariable Long id,
            @PathVariable String tag
    ) {
        return service.deleteTagFromPlace(id, tag);
    }


}
