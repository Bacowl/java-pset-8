import java.text.DecimalFormat;

public class BankAccount {

    private static long prevAccountNo = 100000009L;
    private long accountNumber;
    private double balance;
    private AccountOwner accountOwner;


    public BankAccount(AccountOwner accountOwner, double balance) {
    }

        /*
         * Formats the account balance in preparation to be written to the data file.
         *
         * @return a fixed-width string in line with the data file specifications.
         */

        public String getFormattedBalance () {
            String pattern = "###,###.##";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            return "$" + decimalFormat.format(getBalance()) + ".";
        }

        public long getAccountNumber () {
            return accountNumber;
        }

        public String getMaskedAccountNumber () {
            return "****" + String.valueOf(accountNumber).substring(5);
        }


        public AccountOwner getAccountOwner () {
            return accountOwner;
        }

        public void setAccountOwner (AccountOwner accountOwner){
            this.accountOwner = accountOwner;
        }

    public int getBalance() {
        return validateBalance(balance);
    }

        public int deposit ( double amount){
            if (amount <= 0) {
                return ATM.INVALID_AMOUNT;
            } else {
                balance = balance + amount;
            }
            return ATM.SUCCESS;
        }

        public int transfer ( long account, double amount){
            if (amount <= 0) {
                return ATM.INVALID_AMOUNT;
            } else if (amount > balance) {
                return ATM.INSUFFICIENT_FUNDS;
            } else {
                BankAccount destinationAccount = null;
                destinationAccount = ATM.lookup(account);
                if (destinationAccount == null) {
                    return ATM.ACCOUNT_NOT_FOUND;
                } else {
                    balance = balance - amount;
                    return ATM.SUCCESS;
                }
            }

        }

        public int withdraw ( double amount){
            if (amount <= 0) {
                return ATM.INVALID_AMOUNT;
            } else if (amount > balance) {
                return ATM.INSUFFICIENT_FUNDS;
            } else {
                balance = balance - amount;
            }
            return ATM.SUCCESS;
        }
        public int validateBalance ( double balance){
            if (getBalance() > 0) {
                return ATM.INVALID_AMOUNT;
            } else {
                return ATM.SUCCESS;
            }
        }

}