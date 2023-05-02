import javafx.animation.AnimationTimer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Path;
import javafx.animation.PathTransition;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.util.Duration;
import javafx.scene.media.AudioClip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class CannonGamecontroller {
	


	private boolean blockerup = true;
	private boolean targetup1 = true;
	private boolean targetup2 = true;
	private boolean targetup3 = true;
	private boolean targetup4 = true;
	private boolean targetup5 = true;
	private boolean targetup6 = true;
	private boolean targetup7 = true;
	private boolean targetup8 = true;
	private boolean targetup9 = true;
	/*This line of code initializes multiple boolean variables (blockerup, targetup1, targetup2, 
	 * targetup3, targetup4, targetup5, targetup6, targetup7, targetup8, and targetup9) to the value true.
	 * basiclly wants to know if this objects exist
	 */
	
	
	private boolean iscallied = false;//this line of code is a simple declaration and initialization of a boolean 
	//variable used for internal tracking within a class.
	
	Circle cannnonball = new Circle(); 

    @FXML
    private Rectangle blockerR;

    @FXML
    private Rectangle cannonR;

    @FXML
    private Pane pane;

    @FXML
    private Label scoreBoardlabel;

    @FXML
    private Button startbutton;

    @FXML
    private Rectangle target1R;

    @FXML
    private Rectangle target2R;

    @FXML
    private Rectangle target3R;

    @FXML
    private Rectangle target4R;

    @FXML
    private Rectangle target5R;

    @FXML
    private Rectangle target6R;

    @FXML
    private Rectangle target7R;

    @FXML
    private Rectangle target8R;

    @FXML
    private Rectangle target9R;

    @FXML
    private Label timelabel;
    
    private long startTime = 800;
    
 
    private double cannonballAngle = 0;//The variable is marked as private, which means that it can only be accessed within the class in which it is declared.
   
    private AudioClip blockerSound;
    private AudioClip targetSound;
    private AudioClip CannonSound;
   

    private int score = 0; //This line of code declares a variable named "score" and initializes it to 0

    @FXML
    void changecannonAngle(MouseEvent event) {
    	
    	CannonSound = new AudioClip(getClass().getResource("/cannon_fire.wav").toString());
      	 double mouseX = event.getX();
           double mouseY = event.getY();
           double cannonX = cannonR.getLayoutX() + cannonR.getWidth() / 2;
           double cannonY = cannonR.getLayoutY() + cannonR.getHeight() / 2;
           cannonballAngle = Math.toDegrees(Math.atan2(mouseY - cannonY, mouseX - cannonX));
           cannonR.setRotate(cannonballAngle);
           /*These lines of code are responsible for calculating the angle between
            *  the cannon and the mouse click position
            * , setting the cannon's rotation to the calculated angle, 
            * and playing a cannon fire sound effect.
            */


    }

    @FXML
    void shootcannonball(MouseEvent event) {
    	AudioClip cannonfire = new AudioClip(getClass().getResource("cannon_fire.wav").toString());
    	cannonfire.play();
//    	
    	cannnonball = new Circle();
    	
    	cannnonball.setRadius(10);

        // Define the linear gradient fill color for the cannonball
        LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, null,
                new Stop(0, Color.ORANGE),
                new Stop(1, Color.RED)
        );
        cannnonball.setFill(gradient);
//    	
    	pane.getChildren().add(cannnonball);
    	
    	double cannonRectX = cannonR.getLayoutX() + cannonR.getWidth() / 2;
    	double cannonRectY = cannonR.getLayoutY() + cannonR.getHeight() / 2;
    	
    	Path path = new Path(new MoveTo(cannonRectX, cannonRectY), new LineTo(event.getX(), event.getY()),
    			new MoveTo(0, 0), new LineTo(0, 0));
    	
    	PathTransition transition = new PathTransition(Duration.seconds(1), path);
    	
    	transition.setNode(cannnonball);
    	transition.play();
    

    	/*These lines of code define and play an audio clip of a cannon firing, create a 
    	 * circular cannonball shape with a gradient fill color, add the cannonball to a pane,
    	 *  create a path for the cannonball to follow from the center of the cannon to the location where
    	 *   the user clicked on the pane, and animate the cannonball along the path for 2 seconds using a path transition.
    	 */

    }

    @FXML
    void startbuttonpressed(ActionEvent event) {
    	AnimationTimer timer = new AnimationTimer() {   // This line of code creates a new instance of the AnimationTimer class in Java.

    	    @Override
    	    //This is the method that will be executed on each frame of the animation when using the AnimationTimer class in Java.
    	    public void handle(long now) {

    	        startTime = startTime - 1; //This line of code subtracts 1 from the value of the variable startTime
    	        timelabel.setText(String.valueOf(startTime));// updates the time label 

    	        
    	        
    	        
// to move target 1 and all other target  target 1
    	        /*This code controls the movement of a target on a pane in a Java program by adjusting its vertical position.
    	         *  The if-else statements ensure that the target moves u
    	         *  p and down within the bounds of the pane same with target 1-9 and the blocker 
    	         */
    	        if(targetup1)
	    		{
	    			target1R.setLayoutY(target1R.getLayoutY() - 5);
	    			if(target1R.getLayoutY() <= pane.getMinHeight())
	    			{
	    				targetup1 = false;
	    			}
	    			
	    		}
	    		
	    		if(targetup1 == false)
	    		{
	    			target1R.setLayoutY(target1R.getLayoutY() + 5);
	    			if(target1R.getLayoutY() >= pane.getHeight()-115)
	    			{
	    				targetup1 = true;
	    			}
	    			
	    		}
	    		/*This code checks if a cannonball intersects with a target on a pane in a Java program. 
	    		 * If there is a collision, it removes the cannonball and the target from the pane, 
	    		 * plays an audio clip, and adds 10 points to the score. The updated score is then displayed on a label.
	    		 */
	    		 if (cannnonball.getBoundsInParent().intersects(target1R.getBoundsInParent())) {
	    	            pane.getChildren().remove(cannnonball);
	    	            pane.getChildren().remove(target1R);
	    	            AudioClip targethit = new AudioClip(getClass().getResource("target_hit.wav").toString());
	    	            targethit.play();
	    	            score+= 1;// Add point to the score 
	    	 	    	scoreBoardlabel.setText(String.valueOf(score));
	    	 	    	
	    	 	 
	    	 	  
	    	        }

	    		//  target 2
	    		
	    		if(targetup2)
	    		{
	    			target2R.setLayoutY(target2R.getLayoutY() - 5);
	    			if(target2R.getLayoutY() <= pane.getMinHeight())
	    			{
	    				targetup2 = false;
	    			}
	    			
	    		}
	    		
	    		if(targetup2 == false)
	    		{
	    			target2R.setLayoutY(target2R.getLayoutY() + 5);
	    			if(target2R.getLayoutY() >= pane.getHeight()-115)
	    			{
	    				targetup2 = true;
	    			}
	    			
	    		}
	    		 if (cannnonball.getBoundsInParent().intersects(target2R.getBoundsInParent())) {
	    	            pane.getChildren().remove(cannnonball);
	    	            pane.getChildren().remove(target2R);
	    	            AudioClip targethit = new AudioClip(getClass().getResource("target_hit.wav").toString());
	    	            targethit.play();
	    	            score+= 1;// Add point to the score 
	    	 	    	scoreBoardlabel.setText(String.valueOf(score));
	    	 	    	
	    	 	   
	    	        }

	    		
	    		//target 3
	    		
	    		if(targetup3)
	    		{
	    			target3R.setLayoutY(target3R.getLayoutY() - 5);
	    			if(target3R.getLayoutY() <= pane.getMinHeight())
	    			{
	    				targetup3 = false;
	    			}
	    			
	    		}
	    		
	    		if(targetup3 == false)
	    		{
	    			target3R.setLayoutY(target3R.getLayoutY() + 5);
	    			if(target3R.getLayoutY() >= pane.getHeight()-115)
	    			{
	    				targetup3 = true;
	    			}
	    			
	    		}
	    		 if (cannnonball.getBoundsInParent().intersects(target3R.getBoundsInParent())) {
	    	            pane.getChildren().remove(cannnonball);
	    	            pane.getChildren().remove(target3R);
	    	            AudioClip targethit = new AudioClip(getClass().getResource("target_hit.wav").toString());
	    	            targethit.play();
	    	            score+= 1;// Add point to the score 
	    	 	    	scoreBoardlabel.setText(String.valueOf(score));
	    	 	    	

	    	        }

	    		
	    		//target 4
	    		
	    		if(targetup4)
	    		{
	    			target4R.setLayoutY(target4R.getLayoutY() - 5);
	    			if(target4R.getLayoutY() <= pane.getMinHeight())
	    			{
	    				targetup4 = false;
	    			}
	    			
	    		}
	    		
	    		if(targetup4 == false)
	    		{
	    			target4R.setLayoutY(target4R.getLayoutY() + 5);
	    			if(target4R.getLayoutY() >= pane.getHeight()-115)
	    			{
	    				targetup4 = true;
	    			}
	    			
	    		}
	    		 if (cannnonball.getBoundsInParent().intersects(target4R.getBoundsInParent())) {
	    	            pane.getChildren().remove(cannnonball);
	    	            pane.getChildren().remove(target4R);
	    	            AudioClip targethit = new AudioClip(getClass().getResource("target_hit.wav").toString());
	    	            targethit.play();
	    	            score+= 1;// Add point to the score 
	    	 	    	scoreBoardlabel.setText(String.valueOf(score));
	    	        }

	    		
	    		
	    		//target 5
	    		
	    		if(targetup5)
	    		{
	    			target5R.setLayoutY(target5R.getLayoutY() - 5);
	    			if(target5R.getLayoutY() <= pane.getMinHeight())
	    			{
	    				targetup5 = false;
	    			}
	    			
	    		}
	    		
	    		if(targetup5 == false)
	    		{
	    			target5R.setLayoutY(target5R.getLayoutY() + 5);
	    			if(target5R.getLayoutY() >= pane.getHeight()-115)
	    			{
	    				targetup5 = true;
	    			}
	    			
	    		}
	    		 if (cannnonball.getBoundsInParent().intersects(target5R.getBoundsInParent())) {
	    	            pane.getChildren().remove(cannnonball);
	    	            pane.getChildren().remove(target5R);
	    	            AudioClip targethit = new AudioClip(getClass().getResource("target_hit.wav").toString());
	    	            targethit.play();
	    	            score+= 1;// Add point to the score 
	    	 	    	scoreBoardlabel.setText(String.valueOf(score));
	    	        }

	    		
	    		//target 6
	    		
	    		if(targetup6)
	    		{
	    			target6R.setLayoutY(target6R.getLayoutY() - 5);
	    			if(target6R.getLayoutY() <= pane.getMinHeight())
	    			{
	    				targetup6 = false;
	    			}
	    			
	    		}
	    		
	    		if(targetup6 == false)
	    		{
	    			target6R.setLayoutY(target6R.getLayoutY() + 5);
	    			if(target6R.getLayoutY() >= pane.getHeight()-115)
	    			{
	    				targetup6 = true;
	    			}
	    			
	    		}
	    		 if (cannnonball.getBoundsInParent().intersects(target6R.getBoundsInParent())) {
	    	            pane.getChildren().remove(cannnonball);
	    	            pane.getChildren().remove(target6R);
	    	            AudioClip targethit = new AudioClip(getClass().getResource("target_hit.wav").toString());
	    	            targethit.play();
	    	            score+= 1;// Add point to the score 
	    	 	    	scoreBoardlabel.setText(String.valueOf(score));
	    	        }

	    		
	    		// target 7
	    		
	    		if(targetup7)
	    		{
	    			target7R.setLayoutY(target7R.getLayoutY() - 5);
	    			if(target7R.getLayoutY() <= pane.getMinHeight())
	    			{
	    				targetup7 = false;
	    			}
	    			
	    		}
	    		
	    		if(targetup7 == false)
	    		{
	    			target7R.setLayoutY(target7R.getLayoutY() + 5);
	    			if(target7R.getLayoutY() >= pane.getHeight()-115)
	    			{
	    				targetup7 = true;
	    			}
	    			
	    		}
	    		 if (cannnonball.getBoundsInParent().intersects(target7R.getBoundsInParent())) {
	    	            pane.getChildren().remove(cannnonball);
	    	            pane.getChildren().remove(target7R);
	    	            AudioClip targethit = new AudioClip(getClass().getResource("target_hit.wav").toString());
	    	            targethit.play();
	    	            score+= 1;// Add point to the score 
	    	 	    	scoreBoardlabel.setText(String.valueOf(score));
	    	        }

	    		
	    		
	    		// target 8
	    		
	    		if(targetup8)
	    		{
	    			target8R.setLayoutY(target8R.getLayoutY() - 5);
	    			if(target8R.getLayoutY() <= pane.getMinHeight())
	    			{
	    				targetup8 = false;
	    			}
	    			
	    		}
	    		
	    		if(targetup8 == false)
	    		{
	    			target8R.setLayoutY(target8R.getLayoutY() + 5);
	    			if(target8R.getLayoutY() >= pane.getHeight()-115)
	    			{
	    				targetup8 = true;
	    			}
	    			
	    		}
	    		
	    		 if (cannnonball.getBoundsInParent().intersects(target8R.getBoundsInParent())) {
	    	            pane.getChildren().remove(cannnonball);
	    	            pane.getChildren().remove(target8R);
	    	            AudioClip targethit = new AudioClip(getClass().getResource("target_hit.wav").toString());
	    	            targethit.play();
	    	            score+= 1;// Add point to the score 
	    	 	    	scoreBoardlabel.setText(String.valueOf(score));
	    	        }

	    		
	    		//target 9
	    		
	    		if(targetup9)
	    		{
	    			target9R.setLayoutY(target9R.getLayoutY() - 5);
	    			if(target9R.getLayoutY() <= pane.getMinHeight())
	    			{
	    				targetup9 = false;
	    			}
	    			
	    		}
	    		
	    		if(targetup9 == false)
	    		{
	    			target9R.setLayoutY(target9R.getLayoutY() + 5);
	    			if(target9R.getLayoutY() >= pane.getHeight()-115)
	    			{
	    				targetup9 = true;
	    			}
	    			
	    		}
	    		 if (cannnonball.getBoundsInParent().intersects(target9R.getBoundsInParent())) {
	    	            pane.getChildren().remove(cannnonball);
	    	            pane.getChildren().remove(target9R);
	    	            AudioClip targethit = new AudioClip(getClass().getResource("target_hit.wav").toString());
	    	            targethit.play();
	    	            score+= 1;// Add point to the score 
	    	 	    	scoreBoardlabel.setText(String.valueOf(score));
	    	 	    	
	    	        }

	    		//Movement for blocker
	    		
	    		if(blockerup)
	    		{
	    			blockerR.setLayoutY(blockerR.getLayoutY() - 1);
	    			if(blockerR.getLayoutY() <= pane.getMinHeight())
	    			{
	    				blockerup = false;
	    			}
	    			
	    		}
	    		

   	    
    		// to move the blocker 
   	    	if(blockerup)
    		{
    			blockerR.setLayoutY(blockerR.getLayoutY() - 1);
    			if(blockerR.getLayoutY() <= pane.getMinHeight())
    			{
    				blockerup = false;
    			}
    			
    		}
   	    	
    		if(blockerup == false)
    		{
    			blockerR.setLayoutY(blockerR.getLayoutY() + 1);
    			if(blockerR.getLayoutY() >= pane.getHeight()-200)
    			{
    				blockerup = true;
    			}
    			
    		}
    		
    		
    	    if (cannnonball.getBoundsInParent().intersects(blockerR.getBoundsInParent()))
    	    {
    	    	pane.getChildren().remove(cannnonball);
    	    	AudioClip blockerhit = new AudioClip(getClass().getResource("blocker_hit.wav").toString());
    	    	blockerhit.play();
    	    	score++;
    	    	timelabel.setText(String.valueOf(score));
    	    	/*stop();*/
    	    	
    	    	
                
                
    	    }
    	    /*This code checks if the timer has reached 0 or less in a Java program. 
    	     * If the condition is true, it sets the timer back to its initial value of 800,
    	     *  stops the timer, and calls the endGame() method. This is typically 
    	     *  used to end the game when the timer runs out.
    	     */
   	    	if(startTime <= 0)
    		{
    			startTime = 800;
    			
    			stop();
    			endGame();
    		}
    		
    		
    	}
    	
    };




    
    
    
    


timer.start(); //This line of code starts the timer object in a Java program,
//causing the handle() method to be called on each frame of the animation




    }
    private void endGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText("Your score is " + scoreBoardlabel.getText());
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: #ffcccc;"); // set background color to light red
       alert.show();

        
        
        startbutton.setDisable(false);
        scoreBoardlabel.setText("0");
        timelabel.setText("0.00");
        
        blockerR.setLayoutY(pane.getHeight() / 2 - blockerR.getHeight() / 2);
        target1R.setVisible(true);
        target2R.setVisible(true);
        target3R.setVisible(true);
        target5R.setVisible(true);
        target5R.setVisible(true);
        target6R.setVisible(true);
        target8R.setVisible(true);
        target9R.setVisible(true);
        /*This code defines the endGame() method in a Java program. It creates a pop-up window using the Alert class to display 
         * the player's score and reset various game elements, 
         * such as disabling the start button, resetting the score and time labels, and resetting the positions of the game targets. 
         * This is typically used to end the game when the timer runs out or the player completes a level.
         */

    }

    

}
