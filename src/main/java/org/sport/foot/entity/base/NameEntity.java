package org.sport.foot.entity.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class NameEntity extends IdEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_name")
    String name;
}
