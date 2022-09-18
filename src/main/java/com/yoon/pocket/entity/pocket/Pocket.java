package com.yoon.pocket.entity.pocket;

import com.yoon.pocket.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.YearMonth;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Pocket {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private YearMonth yearMonth;

    @Column(nullable = false)
    @Min(value = 0L, message = "0원 이상만 가능합니다.")
    private Long startBudget;

    @ColumnDefault("0")
    @Min(value = 0L, message = "0원 이상만 가능합니다.")
    private Long cost;

    private Long balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void changeCostBalance(Long cost) {
        if (this.balance == null) {
            this.balance = this.startBudget - this.cost;
        }
        this.cost += cost;
        this.balance -= cost;
    }




}
