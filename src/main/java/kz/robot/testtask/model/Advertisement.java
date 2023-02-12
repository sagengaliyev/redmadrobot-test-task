package kz.robot.testtask.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ADVERTISEMENT")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MINIMUM_PRICE")
    private BigDecimal minimumPrice;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "ADVERTISEMENT_IMAGES")
    private List<FileEntity> images;

    @Enumerated(EnumType.STRING)
    private AdvertisementStatus advertisementStatus = AdvertisementStatus.ACTIVE;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private User user;
}
