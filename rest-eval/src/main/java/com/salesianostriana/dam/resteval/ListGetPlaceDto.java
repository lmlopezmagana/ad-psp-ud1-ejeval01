package com.salesianostriana.dam.resteval;

import java.util.List;

public record ListGetPlaceDto(
        long count,
        List<GetPlaceDto> items
) {

    public static ListGetPlaceDto of(List<Place> list) {
        return new ListGetPlaceDto(
                list.size(),
                list.stream()
                        /*.map(new Function<Place, GetPlaceDto>() {

                            @Override
                            public GetPlaceDto apply(Place place) {
                                return GetPlaceDto.of(place);
                            }
                        })*/
                        //.map(p -> GetPlaceDto.of(p))
                        .map(GetPlaceDto::of)
                        .toList()
        );
    }
}
