package com.yoon.pocket.entity.ledger;

import com.yoon.pocket.entity.pocket.Pocket;
import com.yoon.pocket.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ledger {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDate spendTime;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int price;


    @ManyToOne
    @JoinColumn(name = "pocket_id", nullable = false)
    private Pocket pocket;



}
