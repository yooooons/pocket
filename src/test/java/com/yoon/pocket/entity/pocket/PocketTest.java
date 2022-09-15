package com.yoon.pocket.entity.pocket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pocket 엔티티의")
@Nested
class PocketTest {


    @DisplayName("balance속성이 null일때")
    @Nested
    class PocketBalanceNull {
        @Test
        @DisplayName("가계부 작성시 지출 잔고 계산하기")
        void changeCostBalance() {
            Pocket pocket = Pocket.builder()
                    .startBudget(100000L)
                    .cost(0L)
                    .build();
            pocket.changeCostBalance(3000L);
            Assertions.assertEquals(pocket.getStartBudget(), 100000L);
            Assertions.assertEquals(pocket.getCost(), 3000L);
            Assertions.assertEquals(pocket.getBalance(),  97000L);

        }
    }

    @DisplayName("balance속성이 null이 아닐때")
    @Nested
    class PocketBalanceNotNull {
        @Test
        @DisplayName("가계부 작성시 지출 잔고 계산하기")
        void changeCostBalance() {
            Pocket pocket = Pocket.builder()
                    .startBudget(100000L)
                    .cost(50000L)
                    .balance(50000L)
                    .build();
            pocket.changeCostBalance(3000L);
            Assertions.assertEquals(pocket.getStartBudget(), 100000L);
            Assertions.assertEquals(pocket.getCost(), 53000L);
            Assertions.assertEquals(pocket.getBalance(),  47000L);

        }
    }


}