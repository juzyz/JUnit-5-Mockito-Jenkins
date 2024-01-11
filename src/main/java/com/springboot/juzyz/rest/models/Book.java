package com.springboot.juzyz.rest.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@Entity
@Table
public class Book {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    @NonNull
    private String name;

    @NonNull
    private String summary;

    private int rating;
}
