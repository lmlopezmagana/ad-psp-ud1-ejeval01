package com.salesianostriana.dam.resteval;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository repository;

    public List<Place> getAll() {
        List<Place> result = repository.getAll();
        if (result.isEmpty())
            throw new PlaceNotFoundException("No hay lugares con esos criterios de búsqueda");
        return result;
    }

    public Place getById(Long id) {
        /*Optional<Place> result =
            repository.get(id);
        if (result.isPresent())
            return result.get();
        else
            throw new PlaceNotFoundException("No se ha podido encontrar el lugar con ID %d".formatted(id));
        */
        return repository.get(id)
                .orElseThrow(() ->
                        new PlaceNotFoundException("No se ha podido encontrar el lugar con ID %d".formatted(id)));
    }

    public Place create(Place place) {
        return repository.add(place);
    }

    public void deleteById(Long id) {
        repository.delete(id);
    }

    public Place edit(Long id, Place place) {
        return repository.edit(id, place)
                .orElseThrow(() ->
                        new PlaceNotFoundException("No se ha podido encontrar el lugar con ID %d".formatted(id)));

    }

    public Place addTagToPlace(Long id, String tag) {
        // Buscar el place
        // Añadir el tag
        // Modificar el place
        Optional<Place> placeOpt = repository.get(id);
        Place place = null;
        if (placeOpt.isPresent()) {
            place = placeOpt.get();
            place.addTag(tag);
            repository.edit(id, place);
        } else {
            new PlaceNotFoundException("No se ha podido encontrar el lugar con ID %d".formatted(id));
        }
        return place;
    }

    public Place deleteTagFromPlace(Long id, String tag) {
        // Buscar el place
        // Eliminar el tag
        // Modificar el place
        Optional<Place> placeOpt = repository.get(id);
        Place place = null;
        if (placeOpt.isPresent()) {
            place = placeOpt.get();
            place.removeTag(tag);
            repository.edit(id, place);
        } else {
            new PlaceNotFoundException("No se ha podido encontrar el lugar con ID %d".formatted(id));
        }
        return place;

    }
}
