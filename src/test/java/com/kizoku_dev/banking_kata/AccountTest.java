package com.kizoku_dev.banking_kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AccountTest {

    @Test
    void testCreateAccount() {
        Account account = new Account(0);
        assertThat(account).isNotNull();
    }

    @Test
    void testDeposit() {
        Account account = new Account(0);
        account.deposit(1000);
        assertThat(account.getBalance()).isEqualTo(1000);
    }

    @Test
    void testDepositDecimal() {
        Account account = new Account(0);
        account.deposit(1000.50);
        assertThat(account.getBalance()).isEqualTo(1000.50, withPrecision(2d));
    }

    @Test
    void testWithdraw() {
        Account account = new Account(1500);
        assertThatNoException().isThrownBy(() -> account.withdraw(1000));
        assertThat(account.getBalance()).isEqualTo(500);
    }

    @Test
    void testWithdrawDecimal() {
        Account account = new Account(1500);
        assertThatNoException().isThrownBy(() -> account.withdraw(1000.50));
        assertThat(account.getBalance()).isEqualTo(499.50, withPrecision(2d));
    }

    @Test
    void testWithdrawTooMuchMoney() {
        Account account = new Account(1500);
        assertThatThrownBy(() -> account.withdraw(2000))
                .isInstanceOf(WithdrawException.class)
                .hasMessage(WithdrawException.NOT_ENOUGH_MONEY);
    }
}
