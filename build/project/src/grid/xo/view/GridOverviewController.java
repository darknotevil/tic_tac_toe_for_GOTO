package grid.xo.view;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


public class GridOverviewController {

	@FXML private TextField player1name;
	@FXML private Label label_player1name;
	@FXML private TextField player2name;
	@FXML private Label label_player2name;
	@FXML private Label score_player1;
	@FXML private Label score_player2;
	@FXML private Button b1;
	@FXML private Button b2;
	@FXML private Button b3;
	@FXML private Button b4;
	@FXML private Button b5;
	@FXML private Button b6;
	@FXML private Button b7;
	@FXML private Button b8;
	@FXML private Button b9;
	@FXML private Button changename;
	@FXML private Button resetscore;
	@FXML private ChoiceBox<String> AIlevel;
	@FXML private CheckBox AIEnabler;
	@FXML private CheckBox NightThemeEnabler;
	@FXML private Button[] b=new Button[9];
    boolean GameEnd=false;
    boolean gamewithAi=false;
    public int Score1player=0;
	public int Score2player=0;
	public int AIlevelFix=0;
	public int NumberAI=0;
	final Random random=new Random();
	String normalbutton="";
	String winactbutton="-fx-background-color: radial-gradient( radius 100%, #1e5799, #7db9e8); -fx-text-fill: red;";


	//choisebox Уровень ИИ
		ObservableList<String> levelAIList = FXCollections.observableArrayList("Легко","Сложно");
		@FXML
		private void initialize(){
			AIlevel.setValue("Легко");
			AIlevel.setItems(levelAIList);
			player1name.setText("Игрок 1");
			player2name.setText("Игрок 2");
		}

	private boolean player1=true;

	//Крестики нолики
	 public void buttonClickHandler(ActionEvent evt) {
		Button selectedButton = (Button) evt.getTarget();

	   if (GameEnd==true){
		  b1.setStyle(normalbutton);
		  b2.setStyle(normalbutton);
		  b3.setStyle(normalbutton);
		  b4.setStyle(normalbutton);
		  b5.setStyle(normalbutton);
		  b6.setStyle(normalbutton);
		  b7.setStyle(normalbutton);
		  b8.setStyle(normalbutton);
		  b9.setStyle(normalbutton);
		  b1.setText("");
		  b2.setText("");
		  b3.setText("");
		  b4.setText("");
		  b5.setText("");
		  b6.setText("");
		  b7.setText("");
		  b8.setText("");
		  b9.setText("");
		  player1=true;
		  GameEnd=false;
	  } else {
		  if(gamewithAi==false){ //Игра друг с другом
		if (selectedButton.getText()==""){
			if (player1==true) {
				selectedButton.setText("x");
				player1=false;
			}
			else {
				selectedButton.setText("o");
				player1=true;
			}

		}
		checkwin();

	  } else { //Игра с ПК


		  if (AIlevelFix==0){
				if (selectedButton.getText()==""){
						selectedButton.setText("x");
						player1=false;
						checkwin(); //Если игрок победил

						if (GameEnd==false) {
							int selectfromPC=5;
							boolean freeGrid=false;
							while (freeGrid==false){
								switch(selectfromPC){
								case 1:
									if(b1.getText()==""){
										b1.setText("o");
										player1=true;
										freeGrid=true;
									} else selectfromPC=random.nextInt(9)+1;
								break;
								case 2:
									if(b2.getText()==""){
										b2.setText("o");
										player1=true;
										freeGrid=true;
									} else selectfromPC=random.nextInt(9)+1;
								break;
								case 3:
									if(b3.getText()==""){
										b3.setText("o");
										player1=true;
										freeGrid=true;
									} else selectfromPC=random.nextInt(9)+1;
								break;
								case 4:
									if(b4.getText()==""){
										b4.setText("o");
										player1=true;
										freeGrid=true;
									} else selectfromPC=random.nextInt(9)+1;
								break;
								case 5:
									if(b5.getText()==""){
										b5.setText("o");
										player1=true;
										freeGrid=true;
									} else selectfromPC=random.nextInt(9)+1;
								break;
								case 6:
									if(b6.getText()==""){
										b6.setText("o");
										player1=true;
										freeGrid=true;
									} else selectfromPC=random.nextInt(9)+1;
								break;
								case 7:
									if(b7.getText()==""){
										b7.setText("o");
										player1=true;
										freeGrid=true;
									} else selectfromPC=random.nextInt(9)+1;
								break;
								case 8:
									if(b8.getText()==""){
										b8.setText("o");
										player1=true;
										freeGrid=true;
									} else selectfromPC=random.nextInt(9)+1;
								break;
								case 9:
									if(b9.getText()==""){
										b9.setText("o");
										player1=true;
										freeGrid=true;
									} else selectfromPC=random.nextInt(9)+1;
								break;
								}
						   } //закрытие цикла
						checkwin();
						} //закрытие хода пк
				} //закрытие хода игрока
		  } else { //Сложно
			  if (selectedButton.getText()==""){
					selectedButton.setText("x");
					player1=false;
					checkwin(); //Если игрок победил

					if (GameEnd==false) {
						boolean freeGrid=false;
						if (b5.getText()=="") {
							b5.setText("o");
							player1=true;
						} else{
							if (check2x()==b5) {
						if (b1.getText()!="" && b3.getText()!="" && b7.getText()!="" && b9.getText()!="")	{
							while (freeGrid==false){
								int selectfromPC=random.nextInt(5);
								switch(selectfromPC){
								case 1:
									if(b2.getText()==""){
										b2.setText("o");
										player1=true;
										freeGrid=true;
									}
								break;
								case 2:
									if(b4.getText()==""){
										b4.setText("o");
										player1=true;
										freeGrid=true;
									}
								break;
								case 3:
									if(b6.getText()==""){
										b6.setText("o");
										player1=true;
										freeGrid=true;
									}
								break;
								case 4:
									if(b8.getText()==""){
										b8.setText("o");
										player1=true;
										freeGrid=true;
									}
								break;
							}
						}
					} else {
						while (freeGrid==false){
							int selectfromPC=random.nextInt(5);
							switch(selectfromPC){
							case 1:
								if(b1.getText()==""){
									b1.setText("o");
									player1=true;
									freeGrid=true;
								}
							break;
							case 2:
								if(b3.getText()==""){
									b3.setText("o");
									player1=true;
									freeGrid=true;
								}
							break;
							case 3:
								if(b7.getText()==""){
									b7.setText("o");
									player1=true;
									freeGrid=true;
								}
							break;
							case 4:
								if(b9.getText()==""){
									b9.setText("o");
									player1=true;
									freeGrid=true;
								}
							break;
							}
					   } //закрытие цикла
					   }
						} else {
							check2x().setText("o");
							player1=true;
							freeGrid=true;
						}
						}
					checkwin();
					}
			  }

		  }
	  }

	}
  }


	 private Button check2x() { // проверка двух крестиков подряд
		 String[][] a=new String[3][3];
		 a[0][0]=b1.getText();
		 a[0][1]=b2.getText();
		 a[0][2]=b3.getText();
		 a[1][0]=b4.getText();
		 a[1][1]=b5.getText();
		 a[1][2]=b6.getText();
		 a[2][0]=b7.getText();
		 a[2][1]=b8.getText();
		 a[2][2]=b9.getText();
		 int ifin=-1;
		 int jfin=-1;
		 for (int i=0; i<3; i++){
			 if (a[i][0]==a[i][1]&&a[i][2]=="" && a[i][0]=="x") {
				 ifin=i; jfin=2; break;
			 }
			 if (a[i][1]==a[i][2]&&a[i][0]==""  && a[i][1]=="x") {
				 ifin=i; jfin=0; break;
			 }
			 if (a[i][0]==a[i][2]&&a[i][1]==""  && a[i][0]=="x") {
				 ifin=i; jfin=1; break;
			 }
			 if (a[i][0]==a[i][2]&&a[i][1]==""  && a[i][0]=="x") {
				 ifin=i; jfin=1; break;
			 }
		}
		for (int j=0; j<3; j++){
			 if (a[0][j]==a[1][j]&& a[2][j]==""  && a[0][j]=="x") {
				 ifin=2; jfin=j; break;
			 }
			 if (a[0][j]==a[2][j]&& a[1][j]==""  && a[0][j]=="x") {
				 ifin=1; jfin=j; break;
			 }
			 if (a[2][j]==a[1][j]&& a[0][j]==""  && a[2][j]=="x") {
				 ifin=0; jfin=j; break;
			 }
		}
		 if (a[0][0]==a[1][1] && a[2][2]=="") return b9;
		// if (a[0][0]==a[2][2] && a[1][1]=="") return b5;
		 if (a[2][2]==a[1][1] && a[0][0]=="") return b1;
		 
		 
		 if (a[2][0]==a[1][1] && a[0][2]=="") return b3;
		 if (a[0][2]==a[1][1] && a[2][0]=="") return b7;
		 
		 if (ifin==0){
			 if (jfin==0 && a[ifin][jfin]=="") return b1;
			 if (jfin==1 && a[ifin][jfin]=="") return b2;
			 if (jfin==2 && a[ifin][jfin]=="") return b3;
		 }
		 if (ifin==1){
			 if (jfin==0 && a[ifin][jfin]=="") return b4;
			 if (jfin==1 && a[ifin][jfin]=="") return b5;
			 if (jfin==2 && a[ifin][jfin]=="") return b6;
		 }
		 if (ifin==2){
			 if (jfin==0 && a[ifin][jfin]=="") return b7;
			 if (jfin==1 && a[ifin][jfin]=="") return b8;
			 if (jfin==2 && a[ifin][jfin]=="") return b9;
		 }
		return b5;

	 }


//Проверка выигрыша
	private void checkwin() {
		   if (""!=b1.getText() && b1.getText() == b2.getText() && b2.getText() == b3.getText())
			   winact(b1,b2,b3);
		   if (""!=b4.getText() && b4.getText() == b5.getText() && b5.getText() == b6.getText())
			   winact(b4,b5,b6);
		   if (""!=b7.getText() && b7.getText() == b8.getText() && b8.getText() == b9.getText())
			   winact(b7,b8,b9);
		   if (""!=b1.getText() && b1.getText() == b4.getText() && b4.getText() == b7.getText())
			   winact(b1,b4,b7);
		   if (""!=b2.getText() && b2.getText() == b5.getText() && b5.getText() == b8.getText())
			   winact(b2,b5,b8);
		   if (""!=b3.getText() && b3.getText() == b6.getText() && b6.getText() == b9.getText())
			   winact(b3,b6,b9);
		   if (""!=b1.getText() && b1.getText() == b5.getText() && b5.getText() == b9.getText())
			   winact(b1,b5,b9);
		   if (""!=b3.getText() && b3.getText() == b5.getText() && b5.getText() == b7.getText())
			   winact(b3,b5,b7);
		   if (b1.getText()!="" && b2.getText()!="" && b3.getText()!="" &&
				   b4.getText()!="" && b5.getText()!="" && b6.getText()!="" &&
				   b7.getText()!="" && b8.getText()!="" && b9.getText()!="") GameEnd=true;
	}

//Действие при победе
	   private void winact(Button first, Button second, Button third){
	       first.styleProperty().setValue(winactbutton);
	       second.styleProperty().setValue(winactbutton);
	       third.styleProperty().setValue(winactbutton);
		   if (player1==false) Score1player++;
		   else Score2player++;
		   score_player1.setText(String.valueOf(Score1player));
		   score_player2.setText(String.valueOf(Score2player));
		   GameEnd=true;
		   NumberAI=0;

	   }
//Кнопка сброс очков
	   public void resetScoreHandler() {
		    	Score1player=0;
		    	Score2player=0;
		    	score_player1.setText(String.valueOf(Score1player));
		    	score_player2.setText(String.valueOf(Score2player));
	   }

//Кнопка "Изменить имя"
	   public void changeNameHandler(ActionEvent evt){
		   label_player1name.setText(player1name.getText());
		   label_player2name.setText(player2name.getText());
	   }


	   public void AIEnablerHadnler(){ //Игра с компьютером
		   resetScoreHandler();
		   AIlevel.getSelectionModel().selectedIndexProperty().addListener(
				   (ObservableValue<? extends Number> ov,Number old_val,Number new_val)->{
					   AIlevelFix=new_val.intValue();
				   });
		  if(AIEnabler.isSelected()){
			   label_player2name.setText("Компьютер");
			   player2name.setText("Компьютер");
			   GameEnd=true;
			   gamewithAi=true;

		  } else {
			  player2name.setText("Игрок 2");
			  label_player2name.setText(player2name.getText());
			  GameEnd=true;
			  gamewithAi=false;
		  }
	   }

	   public void NightThemeEnablerHandler(ActionEvent evt){ //css стили странно работали, поэтому все задается здесь
		  if(NightThemeEnabler.isSelected()){
			  normalbutton="-fx-padding: 5 22 5 22; -fx-border-color: #e2e2e2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #1d1d1d; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;";
			  GameEnd=true;
		  } else {
			  normalbutton="";
			  GameEnd=true;
		  }
	   }
}
