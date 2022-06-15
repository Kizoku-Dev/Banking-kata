package com.kizoku_dev.banking_kata;

import com.kizoku_dev.banking_kata.exception.DepositException;
import com.kizoku_dev.banking_kata.exception.OperationException;
import com.kizoku_dev.banking_kata.exception.WithdrawException;
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
        assertThatNoException().isThrownBy(() -> account.deposit(1000));
        assertThat(account.getBalance()).isEqualTo(1000);
    }

    @Test
    void testDepositDecimal() {
        Account account = new Account(0);
        assertThatNoException().isThrownBy(() -> account.deposit(1000.50));
        assertThat(account.getBalance()).isEqualTo(1000.50, withPrecision(2d));
    }

    @Test
    void testDepositZero() {
        Account account = new Account(0);
        assertThatThrownBy(() -> account.deposit(0))
                .isInstanceOf(DepositException.class)
                .hasMessage(String.format(OperationException.ZERO_VALUE, "deposit"));
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
    void testWithdrawZero() {
        Account account = new Account(1500);
        assertThatThrownBy(() -> account.withdraw(0))
                .isInstanceOf(WithdrawException.class)
                .hasMessage(String.format(OperationException.ZERO_VALUE, "withdraw"));
    }

    @Test
    void testWithdrawTooMuchMoney() {
        Account account = new Account(1500);
        assertThatThrownBy(() -> account.withdraw(2000))
                .isInstanceOf(OperationException.class)
                .hasMessage(OperationException.NOT_ENOUGH_MONEY);
    }

    @Test
    void testPrintStatement() {
        Account account = new Account(1500);
        assertThatNoException().isThrownBy(() -> account.deposit(25.66));
        assertThatNoException().isThrownBy(() -> account.withdraw(100));
        System.out.println(account.getStatement().printStatement());
        assertThat(account.getStatement().printStatement()).isEqualTo(
                """
                        Date		Amount		Balance
                        15.06.2022	+25.66		1525.66
                        15.06.2022	-100.0		1425.66
                        """
        );
    }
}
