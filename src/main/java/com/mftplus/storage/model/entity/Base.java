package com.mftplus.storage.model.entity;

import com.google.gson.Gson;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder


@MappedSuperclass
public class Base implements Serializable {
    @Column(length = 1)
    @JsonbTransient
    private boolean deleted;


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
