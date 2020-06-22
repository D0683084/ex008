import static org.junit.Assert.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.junit.Before;
import org.junit.Test;

import account.Account;
import account.BankAccount;
import account.Pin;
import gui.GUI;
import gui.MainMenu;
import gui.Login;
import gui.AccountMenu;
import gui.ChangePin;
import gui.CreateAccount;
import gui.Deposit;
import gui.Withdrawl;
import gui.Transfer;

public class MainTest {


	@Test
	public void GUItest() {
		GUI G = new GUI();
		assertEquals(true,G.isVisible());
		assertEquals("ATM",G.getTitle());
		System.out.println(G.getSize().height);
		assertEquals(500,G.getSize().height);
		assertEquals(500,G.getSize().width);
		assertEquals(false,G.isResizable());
		assertEquals(3,G.getDefaultCloseOperation());
		G.getmainMenuPanel().getCreateAccountButton().doClick();
			
		G.getcreateAccountPanel().getAccountNameField().setText("12345");
		G.getcreateAccountPanel().getAccountPinField().setText("0000");
		G.getcreateAccountPanel().getConfirmPinField().setText("0000");
		G.getcreateAccountPanel().getCreateAccountButton().doClick();
		G.getcreateAccountPanel().getBackButton().doClick();
		Pin p = new Pin("0000","0000");
		BigDecimal r = new BigDecimal(0); 
		BankAccount b = new BankAccount("456",p,r);
		G.getmainMenuPanel().getLoginButton().doClick();
		G.getloginPanel().getAccountNumberField().setText(String.valueOf(b.getAccountNumber()));
		G.getloginPanel().getAccountPinField().setText(String.valueOf(b.getAccountPin()));
		G.getloginPanel().getLoginButton().doClick();

		G.getaccountMenuPanel().getMakeDepositButton().doClick();
		G.getdepositPanel().getDepositAmountField().setText("123");
		G.getdepositPanel().getDepositButton().doClick();
		G.getdepositPanel().getBackButton().doClick();
		
		G.getaccountMenuPanel().getMakeWithdrawlButton().doClick();
		G.getwithdrawlPanel().getWithdrawlAmountField().setText("23");
		G.getwithdrawlPanel().getWithdrawlButton().doClick();
		G.getwithdrawlPanel().getBackButton().doClick();
		
		
		BankAccount a = new BankAccount("789",p,r);
		G.getaccountMenuPanel().getMakeTransferButton().doClick();
		G.gettransferPanel().getTransferAccountField().setText(String.valueOf(a.getAccountNumber()));
		G.gettransferPanel().getTransferAmountField().setText("50");
		G.gettransferPanel().getTransferButton().doClick();
		G.gettransferPanel().getBackButton().doClick();

		
		G.getaccountMenuPanel().getChangePinButton().doClick();
		G.getchangepinPanel().getOldPinField().setText("0000");
		G.getchangepinPanel().getNewPinField().setText("1234");
		G.getchangepinPanel().getchangeButton().doClick();
		G.getchangepinPanel().getBackButton().doClick();
		G.getaccountMenuPanel().getCheckBalanceButton().doClick();
		G.getaccountMenuPanel().getLogoutButton().doClick();
		
		G.getloginPanel().getAccountPinField().setText("1234");
		G.getmainMenuPanel().getLoginButton().doClick();
		G.getaccountMenuPanel().getCheckBalanceButton().doClick();
		G.getaccountMenuPanel().getLogoutButton().doClick();
		G.getmainMenuPanel().getLoginButton().doClick();
		G.getloginPanel().getBackButton().doClick();
		
		
		
		
	}
	
	@Test
	public void GUItest2() {
		GUI G = new GUI();

		Pin p = new Pin("0000","0000");
		BigDecimal r = new BigDecimal(0); 
		BankAccount b = new BankAccount("456",p,r);
		G.getmainMenuPanel().getLoginButton().doClick();
		G.getloginPanel().getAccountNumberField().setText(String.valueOf(b.getAccountNumber()));
		G.getloginPanel().getAccountPinField().setText(String.valueOf(b.getAccountPin()));
		G.getloginPanel().getLoginButton().doClick();

		G.getaccountMenuPanel().getMakeDepositButton().doClick();
		G.getdepositPanel().getDepositAmountField().setText("123");
		G.getdepositPanel().getDepositButton().doClick();
		G.getdepositPanel().getBackButton().doClick();
		
		G.getaccountMenuPanel().getMakeWithdrawlButton().doClick();
		G.getwithdrawlPanel().getWithdrawlAmountField().setText("150");
		G.getwithdrawlPanel().getWithdrawlButton().doClick();
				
		
	}
	
	@Test
	public void GUItest3() {
		GUI G = new GUI();

		Pin p = new Pin("0000","0000");
		BigDecimal r = new BigDecimal(0); 
		BankAccount b = new BankAccount("456",p,r);
		G.getmainMenuPanel().getLoginButton().doClick();
		G.getloginPanel().getAccountNumberField().setText(String.valueOf(b.getAccountNumber()));
		G.getloginPanel().getAccountPinField().setText("1234");
		G.getloginPanel().getLoginButton().doClick();
				
		
	}
	
	@Test
	public void GUItest4() {
		GUI G = new GUI();

		G.getcreateAccountPanel().getAccountNameField().setText("12345");
		G.getcreateAccountPanel().getAccountPinField().setText("0000");
		G.getcreateAccountPanel().getConfirmPinField().setText("1234");
		G.getcreateAccountPanel().getCreateAccountButton().doClick();
				
		
	}
	
	@Test
	public void GUItest5() {
		GUI G = new GUI();

		Pin p = new Pin("0000","0000");
		BigDecimal r = new BigDecimal(0); 
		BankAccount b = new BankAccount("456",p,r);
		G.getmainMenuPanel().getLoginButton().doClick();
		G.getloginPanel().getAccountNumberField().setText(String.valueOf(b.getAccountNumber()));
		G.getloginPanel().getAccountPinField().setText(String.valueOf(b.getAccountPin()));
		G.getloginPanel().getLoginButton().doClick();

		G.getaccountMenuPanel().getMakeDepositButton().doClick();
		G.getdepositPanel().getDepositAmountField().setText("-123");
		G.getdepositPanel().getDepositButton().doClick();

				
		
	}
	
	@Test
	public void GUItest6() {
		GUI G = new GUI();

		Pin p = new Pin("0000","0000");
		BigDecimal r = new BigDecimal(0); 
		BankAccount b = new BankAccount("456",p,r);
		G.getmainMenuPanel().getLoginButton().doClick();
		G.getloginPanel().getAccountNumberField().setText(String.valueOf(b.getAccountNumber()));
		G.getloginPanel().getAccountPinField().setText(String.valueOf(b.getAccountPin()));
		G.getloginPanel().getLoginButton().doClick();

		G.getaccountMenuPanel().getMakeDepositButton().doClick();
		G.getdepositPanel().getDepositAmountField().setText("123");
		G.getdepositPanel().getDepositButton().doClick();
		G.getdepositPanel().getBackButton().doClick();

				
		BankAccount a = new BankAccount("789",p,r);
		G.getaccountMenuPanel().getMakeTransferButton().doClick();
		G.gettransferPanel().getTransferAccountField().setText(String.valueOf(a.getAccountNumber()));
		G.gettransferPanel().getTransferAmountField().setText("150");
		G.gettransferPanel().getTransferButton().doClick();

	}
	
	@Test
	public void GUItest7() {
		GUI G = new GUI();

		Pin p = new Pin("0000","0000");
		BigDecimal r = new BigDecimal(0); 
		BankAccount b = new BankAccount("456",p,r);
		G.getmainMenuPanel().getLoginButton().doClick();
		G.getloginPanel().getAccountNumberField().setText(String.valueOf(b.getAccountNumber()));
		G.getloginPanel().getAccountPinField().setText(String.valueOf(b.getAccountPin()));
		G.getloginPanel().getLoginButton().doClick();
		
		G.getaccountMenuPanel().getChangePinButton().doClick();
		G.getchangepinPanel().getOldPinField().setText("4561");
		G.getchangepinPanel().getNewPinField().setText("1234");
		G.getchangepinPanel().getchangeButton().doClick();

	}

	@Test
	public void MainMenutest() {
		MainMenu m = new MainMenu();
		JLabel j = new JLabel("ATM Main Menu");
		Font labelFont = new Font("Dialog", Font.BOLD, 14);
		j.setFont(labelFont);
		assertEquals(j.getFont(),m.getMainMenuLabel().getFont());
		
		
	}
	
	@Test
	public void Logintest() {
		Login l = new Login();
		JLabel j = new JLabel("Login");
		Font labelFont = new Font("Dialog", Font.BOLD, 14);
		j.setFont(labelFont);
		assertEquals(j.getFont(),l.getLoginLabel().getFont());
		assertEquals(j.getFont(),l.getAccountNumberLabel().getFont());
		assertEquals(j.getFont(),l.getAccountPinLabel().getFont());
		assertEquals(j.getFont(),l.getAccountNumberField().getFont());
		assertEquals(j.getFont(),l.getAccountPinField().getFont());
	}
	
	@Test
	public void BankAccounttest() {
		Pin p = new Pin("0000","0000");
		BigDecimal r = new BigDecimal(0); 
		BankAccount b = new BankAccount("12345",p,r);
		BankAccount a = new BankAccount("12346",p,r);
		assertEquals(b,b.GET_ACCOUNT(b.getAccountNumber(),b.getAccountPin().getPin()));
		assertEquals("12345",b.getAccountName());
		assertEquals(r.setScale(2, RoundingMode.HALF_UP),b.getAccountBalance());
		b.setAccountBalance(r);
		assertEquals(true,b.equals(b));
		assertEquals(false,b.equals(a));


	}
	
	@Test
	public void BankAccounttest2() {
		Pin p = new Pin("0000","0000");
		BigDecimal r1 = new BigDecimal(-33); 
		//BankAccount b1 = new BankAccount("12345",p,r1);

	}
	
	@Test
	public void BankAccounttest3() {
		Pin p = new Pin("0000","0000");
		BigDecimal r = new BigDecimal(0); 
		BankAccount b = new BankAccount("12345",p,r);

	}
	
	@Test
	public void BankAccounttest4() {
		Pin p = new Pin("0000","0000");
		BigDecimal r = new BigDecimal(0); 
		BankAccount b = new BankAccount("12345",p,r);
		b.closeAccount("0000");
	}
	
	@Test
	public void BankAccounttest5() {
		Pin p = new Pin("0000","0000");
		BigDecimal r = new BigDecimal(0); 
		BankAccount b = new BankAccount("12345",p,r);
		//b.changeAccountPin("6000","1000","0000");
	}
	
	@Test
	public void BankAccounttest6() {
		Pin p = new Pin("0000","0000");
		BigDecimal r = new BigDecimal(0); 
		BankAccount b = new BankAccount("12345",p,r);
		b.changeAccountPin("0000","1000","1000");
	}
	
	@Test(expected=Exception.class)
	public void BankAccounttest7() {
		Pin p = new Pin("0000","0000");
		BigDecimal r = new BigDecimal(-16); 
		BankAccount b = new BankAccount("12345",p,r);
		b.IS_POSITIVE_AMOUNT(-16);
	}
	
	
	@Test
	public void Accounttest() {
		Pin p = new Pin("0000","0000");

		
	}

	@Test(expected=Exception.class)
	public void Pintest() {
		Pin p1 = new Pin("0000","A000");


		
	}
	
	@Test(expected=Exception.class)
	public void Pintest3() {
		Pin p = new Pin("0000","0000");
		BigDecimal r = new BigDecimal(0); 
		BankAccount b = new BankAccount("12345",p,r);
		p.IS_CORRECT_PIN(b.getAccountNumber(),"1234");


		
	}
	

	
	@Test(expected=Exception.class)
	public void Pintest4() {
		Pin p1 = new Pin("-000","100");

		
	}
	
	@Test(expected=Exception.class)
	public void Pintest5() {
		Pin p1 = new Pin("1234","0000");

		
	}

	@Test
	public void Pintest2() {

		Pin p = new Pin("0000","0000");
		Pin p1 = new Pin("0000","0000");
		Pin p2 = new Pin("1234","1234");
		assertEquals(true,p.equals(p1));
		assertEquals(false,p.equals(p2));
		
	}
	
	@Test
	public void Deposittest() {

		Deposit d = new Deposit();
		d.getDepositAmountField().setText("18");
		assertEquals("Deposit Amount:",d.getDepositAmountLabel().getText());
		assertEquals("18",d.getDepositAmountField().getText());
		assertEquals("Deposit",d.getDepositLabel().getText());
		assertEquals(18.0,d.getDepositAmount(),0.001);
	}
	
	@Test
	public void Deposittest2() {

		Deposit d = new Deposit();
		d.getDepositAmountField().setText("xt");
		d.getDepositAmount();
	}
	
	
	@Test
	public void withdrawtest() {

		Withdrawl w = new Withdrawl();
		w.getWithdrawlAmountField().setText("18");
		assertEquals("Withdrawl Amount:",w.getWithdrawlAmountLabel().getText());
		assertEquals("18",w.getWithdrawlAmountField().getText());
		assertEquals("Withdrawl",w.getWithdrawlLabel().getText());
		assertEquals(18.0,w.getWithdrawlAmount(),0.001);
	}
	
	@Test
	public void withdrawtest2() {

		Withdrawl w = new Withdrawl();
		w.getWithdrawlAmountField().setText("vy");
		w.getWithdrawlAmount();
	}
	
	

	
	@Test
	public void transfertest() {

		Transfer t = new Transfer();
		t.getTransferAmountField().setText("18");
		t.getTransferAccountField().setText("957186");
		assertEquals("Transfer Amount:",t.getTransferAmountLabel().getText());
		assertEquals("18",t.getTransferAmountField().getText());
		assertEquals("957186",t.getTransferAccountField().getText());
		assertEquals("Transfer Account:",t.getTransferAccountLabel().getText());
		assertEquals("Transfer",t.getTransferLabel().getText());
		assertEquals(18.0,t.getTransferAmount(),0.001);
		assertEquals(957186,t.getTransferAccount());
	}
	
	@Test
	public void transfertest2() {

		Transfer t = new Transfer();
		t.getTransferAmountField().setText("xy");
		t.getTransferAmount();
	}
	
	@Test
	public void transfertest3() {

		Transfer t = new Transfer();
		t.getTransferAccountField().setText("xyy");
		t.getTransferAccount();
	}
	
	@Test
	public void AccountMenutest() {
		AccountMenu am = new AccountMenu();
		assertEquals("Account Menu",am.getAccountMenuLabel().getText());

	}
	
	@Test
	public void CreatAccounttest() {
		CreateAccount am = new CreateAccount();
		assertEquals("Create Account",am.getCreateAccountLabel().getText());
		assertEquals("Name:",am.getAccountNameLabel().getText());
		assertEquals("Account PIN:",am.getAccountPinLabel().getText());
		assertEquals("Confirm PIN:",am.getConfirmPinLabel().getText());

		
	}
	
	@Test
	public void ChangePintest() {
		ChangePin c = new ChangePin();
		assertEquals("ChangePin",c.getChangePinLabel().getText());
		assertEquals("Old Pin:",c.getOldPinLabel().getText());
		assertEquals("New Pin:",c.getNewPinLabel().getText());
		c.getNewPinField().setText("1234");
		assertEquals(1234,c.getnewpin());

		
	}
	
	@Test
	public void ChangePintest1() {
		ChangePin c = new ChangePin();
		c.getNewPinField().setText("Ab");
		c.getnewpin();


	
	}
	
	@Test(expected=Exception.class)
	public void AccountPintest() {
		Pin p = new Pin("0000","0000");
		BigDecimal r = new BigDecimal(0); 
		BankAccount b = new BankAccount("12345",p,r);
		b.getAccountHistory();
		b.ACCOUNT_EXISTS(123456);
	
	}
	

	

}
