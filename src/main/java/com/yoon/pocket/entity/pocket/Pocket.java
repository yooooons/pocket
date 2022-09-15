package com.yoon.pocket.entity.pocket;

import com.yoon.pocket.entity.user.User;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@NoArgsConstructor
public class Pocket {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = true)
    @Min(value = 0L, message = "0원 이상만 가능합니다.")
    private Long startBudget;

    @ColumnDefault("0")
    @Min(value = 0L, message = "0원 이상만 가능합니다.")
    private Long cost;

    private Long balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
