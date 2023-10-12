package com.journaldev.design.Assignment2.composite_design_pattern;

// Абстрактный класс Account представляет счет с методом getBalance для получения баланса.
abstract class Account {
  public abstract float getBalance();
}

// Класс DepositeAccount представляет депозитный счет с номером и балансом.
class DepositeAccount extends Account {
  private String accountNo;
  private float accountBalance;

  public DepositeAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() {
    return accountBalance;
  }
}

// Класс SavingAccount представляет сберегательный счет с номером и балансом.
class SavingAccount extends Account {
  private String accountNo;
  private float accountBalance;

  public SavingAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() {
    return accountBalance;
  }
}

// Класс CompositeAccount представляет композитный счет, который может содержать другие счета.
class CompositeAccount extends Account {
  private float totalBalance;
  private List<Account> accountList = new ArrayList<Account>();

  public float getBalance() {
    totalBalance = 0;
    for (Account acc : accountList) {
      totalBalance = totalBalance + acc.getBalance();
    }
    return totalBalance;
  }

  public void addAccount(Account acc) {
    accountList.add(acc);
  }

  public void removeAccount(Account acc) {
    accountList.remove(acc);
  }
}

public class CompositePattern {
  public static void main(String[] args) {
    CompositeAccount component = new CompositeAccount();

    // Создаем композитный счет и добавляем депозитные и сберегательные счета.
    component.addAccount(new DepositeAccount("DA001", 100));
    component.addAccount(new DepositeAccount("DA002", 150));
    component.addAccount(new SavingAccount("SA001", 200));

    float totalBalance = component.getBalance();
    System.out.println("Общий баланс : " + totalBalance);
  }
}
