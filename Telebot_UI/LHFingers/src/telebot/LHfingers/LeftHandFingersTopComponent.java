/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telebot.LHfingers;

import java.awt.BorderLayout;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.netbeans.api.settings.ConvertAsProperties;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//telebot.LHfingers//RighHandFingers//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "RighHandFingersTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "output", openAtStartup = false)
@ActionID(category = "Window", id = "telebot.LHfingers.RighHandFingersTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_RighHandFingersAction",
        preferredID = "RighHandFingersTopComponent"
)
@Messages({
    "CTL_RighHandFingersAction=RighHandFingers",
    "CTL_RighHandFingersTopComponent=RighHandFingers Window",
    "HINT_RighHandFingersTopComponent=This is a RighHandFingers window"
})
public final class LeftHandFingersTopComponent extends TopComponent {
    private final JFXPanel jfxPanel = new JFXPanel();
    private final boolean RIGHT_HAND = true;
    private final boolean LEFT_HAND = true;    
    
    private boolean whole_hand;
    
    //Creating fingers
    
    private final ScrollBar sc_finger_1 = new ScrollBar();
    private final ScrollBar sc_finger_2 = new ScrollBar();
    private final ScrollBar sc_finger_3 = new ScrollBar();
    private final ScrollBar sc_finger_4 = new ScrollBar();
    private final ScrollBar sc_finger_5 = new ScrollBar();
    
    private final Button btn_all_fingers = new Button("Whole Hand");
    
    private static final GridPane grid = new GridPane();
    
    public LeftHandFingersTopComponent() {
        initComponents();
        setName(Bundle.CTL_RighHandFingersTopComponent());
        setToolTipText(Bundle.HINT_RighHandFingersTopComponent());
        setLayout(new BorderLayout());
        
        whole_hand = false;
        //Setting the orientation and size of the scrolls bars (fingers)
        sc_finger_1.setOrientation(Orientation.VERTICAL);
        sc_finger_2.setOrientation(Orientation.VERTICAL);
        sc_finger_3.setOrientation(Orientation.VERTICAL);
        sc_finger_4.setOrientation(Orientation.VERTICAL);
        sc_finger_5.setOrientation(Orientation.VERTICAL);         
        
//        sc_finger_1.setMinSize(30, 200);
//        sc_finger_2.setMinSize(30, 200);
//        sc_finger_3.setMinSize(30, 200);
//        sc_finger_4.setMinSize(30, 200);
//        sc_finger_5.setMinSize(30, 200);
        
        sc_finger_1.setRotate(180);
        sc_finger_2.setRotate(180);
        sc_finger_3.setRotate(180);
        sc_finger_4.setRotate(180);
        sc_finger_5.setRotate(180);
        
        
        grid.setPadding(new Insets(5));
        grid.setHgap(5);
        grid.setVgap(5);
        GridPane.setConstraints(sc_finger_1,0,0,1,0,HPos.CENTER,VPos.CENTER,Priority.ALWAYS, Priority.ALWAYS);
        GridPane.setConstraints(sc_finger_2,1,0,1,0,HPos.CENTER,VPos.CENTER,Priority.ALWAYS, Priority.ALWAYS);
        GridPane.setConstraints(sc_finger_3,2,0,1,0,HPos.CENTER,VPos.CENTER,Priority.ALWAYS, Priority.ALWAYS);
        GridPane.setConstraints(sc_finger_4,3,0,1,0,HPos.CENTER,VPos.CENTER,Priority.ALWAYS, Priority.ALWAYS);
        GridPane.setConstraints(sc_finger_5,4,0,1,0,HPos.CENTER,VPos.CENTER,Priority.ALWAYS, Priority.ALWAYS);
        GridPane.setConstraints(btn_all_fingers,5,0,1,0,HPos.CENTER,VPos.CENTER,Priority.ALWAYS, Priority.ALWAYS);
        
        grid.getChildren().addAll(sc_finger_1,sc_finger_2,sc_finger_3,sc_finger_4,sc_finger_5,btn_all_fingers);
        
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
        jfxPanel.setScene(new Scene(grid,800,600));
            }
        });    
        
        
        
        add(new JFXPanel());
        
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
