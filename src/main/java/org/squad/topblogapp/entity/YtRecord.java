package org.squad.topblogapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "yt_record")
@Data
public class YtRecord extends Record {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "yt_link", nullable = false)
    private String yt_link;
    @Column(name = "image", nullable = false)
    private String image;
    @Column(name = "metric", nullable = false)
    private Long metric;
}
