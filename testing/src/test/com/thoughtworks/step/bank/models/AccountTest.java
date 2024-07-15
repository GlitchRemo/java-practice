package com.thoughtworks.step.bank.models;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

  @Test
 void onePlusOneTwo() {
  Account account = new Account();

  assertEquals(2, account.sum(1, 1));
 }
}