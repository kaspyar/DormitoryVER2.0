package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.apache.log4j.lf5.Log4JLogRecord;

import view.LogIn;
import view.MainContainer;

public class Controller {

	private MainContainer frame;
	private LogIn login;
	Logger log = Logger.getLogger(Log4JLogRecord.class.getName());

	public Controller(MainContainer mc) {
		this.frame = mc;
		frame.setVisible(true);
		
		login = new LogIn();
		frame.showPane(login);
		login.addListener(new ListenerLogIn());		
	}
/*
  Here starts all Listener<Types>
*/	
	private class ListenerLogIn implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source == login.getBtnSpravka()){
				System.out.println("ListenerLogIn: pressed getInfo");
				//login.getInfoTool().setVisible(true);
			}
			if (source == login.getBtnLogIn()){
				log.info("ListenerLogIn: pressed LogIn");
				log.info("Value user: "+login.getBoxUser().getSelectedItem());
				log.info("Value login: "+login.getTextFieldLogin().getText());
				log.info("Value pswd: "+login.getTextFieldPswd().getText());
				if (login.getTextFieldLogin().getText().equals("") || 
						login.getTextFieldPswd().getPassword().length == 0 ){
					JOptionPane.showMessageDialog(login,
			                "Field(s) is(are) emtpy!",
			                "Warning!!!",
			                JOptionPane.WARNING_MESSAGE);				
				}else{
					if (login.getBoxUser().getSelectedItem().equals("Administrator")){
						System.out.println("admin");
						/*check login and pswd for this user if */
						if (model.Model.INSTANCE.checkLogInPswd4Administrator(login.getTextFieldLogin().getText(), login.getTextFieldPswd().getPassword())){
							//admin = new Administrator();
							//admin.addListener(new AdministratorListener());
							login.getTextFieldLogin().setText("");
							login.getTextFieldPswd().setText("");
							login.getAttentLbl().setText("");
							//frame.showPane(admin);
						}else{
							JOptionPane.showMessageDialog(login,
					                "You entered wrong value(s)!",
					                "ERROR",
					                JOptionPane.ERROR_MESSAGE);
						}
					}else if (login.getBoxUser().getSelectedItem().equals("Comendant")){
						System.out.println("comend");
					} else if (login.getBoxUser().getSelectedItem().equals("Student")){
						System.out.println("student");
					}else if (login.getBoxUser().getSelectedItem().equals("Worker")){
						System.out.println("worker");
					} else{
						System.out.println("guest");
					}
				}
			}
			if (source == login.getBoxUser()){
				System.out.println("Box user value = "+login.getBoxUser().getSelectedItem());
			}
		}

	}
}
