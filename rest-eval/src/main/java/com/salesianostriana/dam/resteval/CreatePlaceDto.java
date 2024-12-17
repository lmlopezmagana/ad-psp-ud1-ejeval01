package com.salesianostriana.dam.resteval;

public record CreatePlaceDto(
        String name,
        String address,
        String coords,
        String image,
        String desc
) {

   /* public static Place toPlace(CreatePlaceDto dto) {
        return Place.builder()
                .name(dto.name)
                .address(dto.address)
                .desc(dto.desc)
                .image(dto.image)
                .coords(dto.coords)
                .build();
    }*/

    public Place toPlace() {
        return Place.builder()
                .name(this.name)
                .address(this.address)
                .desc(this.desc)
                .image(this.image)
                .coords(this.coords)
                .build();
    }

}
