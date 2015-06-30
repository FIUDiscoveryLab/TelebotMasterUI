
package telebot.fingers;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javax.swing.JPanel;

//TODO: Storage the position of the fingers for each hand in case we swith it restores it
//TODO Find a way to 


public class Fingers_UI extends JPanel{
    
    private final JFXPanel jfxPanel = new JFXPanel();
    private final boolean RIGHT_HAND = true;
    private final boolean LEFT_HAND = true;
    
    private boolean selected_hand;
    private boolean whole_hand;
    
    //Creating fingers
    
    private final ScrollBar sc_finger_1 = new ScrollBar();
    private final ScrollBar sc_finger_2 = new ScrollBar();
    private final ScrollBar sc_finger_3 = new ScrollBar();
    private final ScrollBar sc_finger_4 = new ScrollBar();
    private final ScrollBar sc_finger_5 = new ScrollBar();
    
    /*This button will provide the functionality of 
    *holding all the fingers at the time    
    */
    
    
    
    private final Button btn_all_fingers = new Button("Whole Hand");
    
    //this is the container that I am using 
    private final GridPane grid = new GridPane();
    
    //this is a comboBox to switch hands
    private final ObservableList<String> options = FXCollections.observableArrayList(
        "Right Hand",
        "Left Hand"
        );
    private final ComboBox cmb_switch_hands = new ComboBox(options);
    
    public Fingers_UI(LayoutManager layout) {
        super(layout);       
        initComponents();
        
    }

    public Fingers_UI(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        initComponents();
        
    }

    public Fingers_UI(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        initComponents();
    }
    private void initComponents() {
        selected_hand = RIGHT_HAND;
        whole_hand = false;
        
        
        //Setting the orientation and size of the scrolls bars (fingers)
        sc_finger_1.setOrientation(Orientation.VERTICAL);
        sc_finger_2.setOrientation(Orientation.VERTICAL);
        sc_finger_3.setOrientation(Orientation.VERTICAL);
        sc_finger_4.setOrientation(Orientation.VERTICAL);
        sc_finger_5.setOrientation(Orientation.VERTICAL);         
        
        sc_finger_1.setMinSize(30, 200);
        sc_finger_2.setMinSize(30, 200);
        sc_finger_3.setMinSize(30, 200);
        sc_finger_4.setMinSize(30, 200);
        sc_finger_5.setMinSize(30, 200);
        
        sc_finger_1.setRotate(180);
        sc_finger_2.setRotate(180);
        sc_finger_3.setRotate(180);
        sc_finger_4.setRotate(180);
        sc_finger_5.setRotate(180);
        
        
        
        //setting the initial value for the comboBox
        
        cmb_switch_hands.setValue("Right Hand");
        
        createScene();      
        
        
        add(jfxPanel, BorderLayout.CENTER);      
        
    
    }
    
    private void createScene() {
        
        
        //Setting the position and the gap between columns
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        
        grid.add(sc_finger_1,0,0,1,2);
        grid.add(sc_finger_2,1,0,1,2);
        grid.add(sc_finger_3,2,0,1,2);
        grid.add(sc_finger_4,3,0,1,2);
        grid.add(sc_finger_5,4,0,1,2);
        
        grid.add(btn_all_fingers,6,1,1,1);
       
        grid.add(cmb_switch_hands,6,0,3,1);
        
        Platform.runLater(new Runnable() {
            @Override 
            public void run() {
        btn_all_fingers.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                whole_hand = !whole_hand;
                        
                if (whole_hand) {
                    
                    enableWholeHand(whole_hand);
                    
                    setMidPoint();                   
                    btn_all_fingers.setText("Single Finger");
                }
                else{
                    
                    enableWholeHand(whole_hand);                    
                    setMidPoint();
                    
                    btn_all_fingers.setText("Whole Hand");
                    
                }
            }
        });
        sc_finger_3.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                if (whole_hand) {
                    sc_finger_1.setValue(new_val.doubleValue());
                    sc_finger_2.setValue(new_val.doubleValue());
                    sc_finger_4.setValue(new_val.doubleValue());
                    sc_finger_5.setValue(new_val.doubleValue());
                    
                    System.out.println(new_val);
                }
            }
        });
            
        
        cmb_switch_hands.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String old_value, String new_value) {                
                if ("Right Hand".equals(new_value)) {
                    selected_hand = RIGHT_HAND; 
                    setMidPoint();
                    
                }
                else{               
                    
                    selected_hand =LEFT_HAND;
                    setMidPoint();
                }
               
            }    
        });        
        
        jfxPanel.setScene(new Scene(grid,800,600));
            }
        });
    }
    
    public void setMidPoint(){
        sc_finger_1.setValue(50); //need to figure out how to create a single method for this in JavaFX
        sc_finger_2.setValue(50);
        sc_finger_3.setValue(50);
        sc_finger_4.setValue(50);
        sc_finger_5.setValue(50);
        
    }
    
    public void enableWholeHand(boolean value){
        sc_finger_1.setDisable(value);
        sc_finger_2.setDisable(value);
        sc_finger_4.setDisable(value);
        sc_finger_5.setDisable(value);
    }
    
    
}
