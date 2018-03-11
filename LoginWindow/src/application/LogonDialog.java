package application;

import java.util.Optional;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class LogonDialog {

	String info1;
	String info2;
	
	private Dialog<Pair<MyEnum, String>> dialog;
	private GridPane grid;
	private ButtonType loginButtonType;
	private ButtonType cancelButtonType;
	private ChoiceBox cbxEnv;
	private ComboBox cbxUsers;
	private PasswordField passField;
	private UsersData new_users;
    final int WIDTH = 200;

    public LogonDialog(String info1, String info2) {
        this.info1 = info1;
        this.info2 = info2;
        new_users = new UsersData();
        init_window();      
    }
    public void init_window() 
    {
    	dialog = new Dialog<>();
        dialog.setResultConverter(buttonType-> resultConverter(buttonType));
        dialog.setTitle(info1);
        dialog.setHeaderText(info2);
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        dialog.getDialogPane().setContent(grid);
        display_elements();
    }
    private void display_elements() 
    {
    	display_Icon();
    	display_Choicebox();
        display_Combobox();
    	display_PasswordField();
    	display_Buttons();
    }
    private void display_Combobox() {
    	cbxUsers= new ComboBox<String>();
    	cbxUsers.setEditable(true);
    	cbxUsers.setPrefWidth(WIDTH);
    	for (User element : new_users.users) {
    	if (cbxEnv.getValue().toString().equals(element.enviroment.toString()))
    		cbxUsers.getItems().add(element.name);
    	}
    	Label lblUser= new Label("U¿ytkownik:");
    	lblUser.setPrefWidth(WIDTH / 2);
    	cbxUsers.valueProperty().addListener((observable, oldVal, newVal) -> cbxUsers_Changed(newVal));
    	cbxUsers.getEditor().textProperty().addListener((obs, oldText, newText) -> {
    		cbxUsers.setValue(newText);
    		cbxUsers_Changed(newText);
        });
    	grid.add(lblUser, 0, 1);
    	grid.add(cbxUsers, 1, 1);
		
	}
	private void display_Buttons() {
		loginButtonType= new ButtonType("Logon", ButtonData.OK_DONE);
    	cancelButtonType= new ButtonType("Anuluj",ButtonData.CANCEL_CLOSE);
    	dialog.getDialogPane().getButtonTypes().add(loginButtonType);
    	dialog.getDialogPane().getButtonTypes().add(cancelButtonType);
    	dialog.getDialogPane().lookupButton(loginButtonType).setDisable(true);
		
	}
	private void display_PasswordField() {
		passField= new PasswordField();
    	passField.setPromptText("Has³o");
    	passField.setPrefWidth(WIDTH);
    	Label lblPass= new Label("Has³o:");
    	lblPass.setPrefWidth(WIDTH / 2);
    	passField.textProperty().addListener((observable, oldVal, newVal) -> passField_Changed(newVal));
    	grid.add(lblPass, 0, 2);
    	grid.add(passField, 1, 2);
		
	}
	private void  display_Choicebox() {
		cbxEnv= new ChoiceBox<MyEnum>();
        Label lblEnv= new Label("Œrodowisko:");
        lblEnv.setPrefWidth(WIDTH/2);
        cbxEnv.getItems().add(MyEnum.FIRST_CHOICE);
        cbxEnv.getItems().add(MyEnum.SECOND_CHOICE);
        cbxEnv.getItems().add(MyEnum.THIRD_CHOICE);
        cbxEnv.setValue(cbxEnv.getItems().get(0));
        cbxEnv.setPrefWidth(WIDTH);
        cbxEnv.valueProperty().addListener((observable, oldVal, newVal) -> cbxEnv_Changed(newVal));
        grid.add(lblEnv, 0, 0);
        grid.add(cbxEnv, 1, 0);
		
	}
	private void display_Icon() {
		ImageView iv1 = new ImageView(new Image("https://image.flaticon.com/icons/png/128/248/248928.png"));
    	iv1.setFitWidth(50);
    	iv1.setFitHeight(50);
     	dialog.setGraphic(iv1);
		
	}
	private void passField_Changed(String newVal) {
    	if ((!(newVal == null)) && (!cbxUsers.getValue().toString().isEmpty()))
    		dialog.getDialogPane().lookupButton(loginButtonType).setDisable(false);
	}
	private void cbxUsers_Changed(Object newVal) {
		System.out.println("robie");
		if ((!passField.getText().isEmpty()) && (!newVal.toString().isEmpty()))
    		dialog.getDialogPane().lookupButton(loginButtonType).setDisable(false);
	}
	private void cbxEnv_Changed(Object new_env)
    {
    	cbxUsers.getItems().clear();
    	for (User element : new_users.users) {
        	if (new_env.toString().equals(element.enviroment.toString()))
        		cbxUsers.getItems().add(element.name);
        	}
    }
	private Pair<MyEnum, String> resultConverter(ButtonType buttonType) {
    	if (buttonType == loginButtonType) {
    	if (new_users.isPassCorrect(cbxEnv.getValue().toString(),cbxUsers.getValue().toString(), passField.getText())) {
    		String aa = cbxUsers.getValue().toString();
    		return new Pair<MyEnum, String>((MyEnum) cbxEnv.getValue(), aa);
    	}
    	}
		return null; 
    }
	public Optional<Pair<MyEnum, String>> showAndWait() {
		return dialog.showAndWait();
	} 
	
}
