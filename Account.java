class BankAccount {

    protected int amount; // создайте переменную int amount. Доступ к переменной должен быть только из наследников и классов в текущем пакете
    protected String currency;  // создайте переменную String currency. Доступ к переменной должен быть только из наследников и классов в текущем пакете
 
     public void replenishBalance(int amount) {
         this.amount =+ amount; // реализуйте метод. Он общий для всех наследников
         System.out.println("Счёт пополнен на " + amount + " " + currency);
     }
 
     public void withdrawCash(int amount) {
 
     }
 
     public void showBalance() {
        
     }
 }
 
 class DebitAccount extends BankAccount /* унаследуйте класс от BankAccount */ {
 
     public DebitAccount(int amount, String currency) {
          // если amount < 0, вывести сообщение "Баланс дебетового счета не может быть меньше 0"
          // иначе присвоить переменным amount и currency значения, переданные в конструкторе
         if (amount <0) { System.out.println("Баланс дебетового счета не может быть меньше 0");}
         else {super.amount = amount; super.currency = currency;}
         super.replenishBalance(amount);
     }
 
     @Override
     public void withdrawCash(int amount) {
          // если на счету достаточно денег
              // вычесть amount из amount класса
              // вывести сообщение "Вы сняли {amount} {currency}"
          // иначе вывести сообщение "У вас недостаточно средств для снятия суммы {amount} {currency}"
         if ((super.amount - amount)>=0) {
             this.amount = super.amount - amount;
         } else System.out.println("У вас недостаточно средств для снятия суммы "+ amount+ currency);
     }
 
     @Override
     public void showBalance() {
         System.out.println("Остаток на счету "+ Math.abs(amount)+ currency); // вывести сообщение "На вашем счету осталось {amount} {currency}"
     }
 }
 
 // создайте класс CreditAccount, который будет наследоваться от класса BankAccount
 class CreditAccount extends BankAccount /* унаследуйте класс от BankAccount */ {
 private int creditLimit;
          // создайте переменную int creditLimit. Переменная должна быть доступна только 
     //  в пределах класса CreditAccount
 
      // создайте конструктор, который принимает на вход переменные
     // (int amount, String currency, int creditLimit) и присваивает их значения переменным класса
         public CreditAccount(int amount, String currency, int creditLimit) {
              this.creditLimit = creditLimit;
             super.amount = amount;
             super.currency = currency;
         super.replenishBalance(amount);
            
  }
     // переопределите метод withdrawCash(int amount)
          // если после снятия наличных будет превышен кредитный лимит
              // выведите сообщение "У вас недостаточно средств для снятия суммы {amount} {currency}"
          // иначе уменьшить сумму на счёте и вывести сообщение "Вы сняли {amount} {currency}"
  @Override
     public void withdrawCash(int amount) {
         if ((super.amount - amount)< creditLimit) {
             this.amount = super.amount - amount;
         System.out.println("Вы сняли "+ amount+ currency);
         }
         else System.out.println("У вас недостаточно средств для снятия суммы "+ amount+ currency);
         }
     
     
      // переопределите метод showBalance()
          // если на счету положительная сумма, то выведите сообщение "На вашем счету {amount} {currency}", 
         // иначе "Ваша задолженность по кредитному счету составляет {amount} {currency}"
      @Override
     public void showBalance() {
        if (super.amount >=0) System.out.println("На вашем счету осталось "+ amount+ currency);
         else System.out.println("Задолженность по кредитному счёту составляет " + Math.abs(amount)+ currency);
     }
     
      
  }
 
  