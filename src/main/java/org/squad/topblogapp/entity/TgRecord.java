package org.squad.topblogapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tg_record")
@Data
public class TgRecord extends Record {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "tg_link", nullable = false)
    private String tg_link;
    @Column(name = "image", nullable = false)
    private String image;
    @Column(name = "metric", nullable = false)
    private Long metric;
}
